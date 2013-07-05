package ncbisegout.main;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;

import ncbisegout.BiosequenceRecord;
import ncbisegout.EntryReference;
import ncbisegout.FeatureRecord;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences.Annotation;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences.Annotation.CondensedReferences;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences.Annotation.Occurrence;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences.Method;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences.ScoreType;
import ncbisegout.FeatureRecord.ReferenceSequence;
import ncbisegout.FeatureType;
import ncbisegout.GeneralSequenceSegment;
import ncbisegout.ObjectFactory;
import ncbisegout.Score;
import ncbisegout.SemanticConcept;
import ncbisegout.SequencePosition;
import ncbisegout.filereader.NcbiSegObject;
import ncbisegout.filereader.Pair;

/**
 * Write ncbi-seg output to an XML file
 * @author jonas
 *
 */
public class NcbiSeqOutput
{
	private final String methodLocalId = "M#Se";
	private final String scoreLowCompl = "S#lc";
	
	private ObjectFactory of;
	private FeatureRecord fr;
	private NcbiSegObject nsObj;
	
	public NcbiSeqOutput(NcbiSegObject nsObj)
	{
		of = new ObjectFactory();
		fr = of.createFeatureRecord();
		this.nsObj = nsObj;
	}
	
	/**
	 * Create XML
	 */
	public void make()
	{
		ReferenceSequence refSeq = new ReferenceSequence();
		BiosequenceRecord bioSeqRec = new BiosequenceRecord();
		bioSeqRec.setSequence(nsObj.Sequence.toUpperCase());
		refSeq.setSequenceRecord(bioSeqRec);
		fr.setReferenceSequence(refSeq);		
		List<Object> bwocrList = fr.getAnnotationOrBlockWithOccurrenceReferences();
		BlockWithOccurrenceReferences bwocr =  new BlockWithOccurrenceReferences();
		bwocrList.add(bwocr);
		
		//Method element
		List<FeatureRecord.BlockWithOccurrenceReferences.Method> methodDescList = bwocr.getMethod();
		Method ncbiSegMethod = new Method();
		ncbiSegMethod.setVersion("0.0.20000620");
		ncbiSegMethod.setLocalId(methodLocalId);
		ncbiSegMethod.setName("ncbi-seg");
		
		////Category concept subelement
		List<SemanticConcept> ncbiSegMethodCatConList =  ncbiSegMethod.getCategoryConcept();
		SemanticConcept ncbiSegMethodCatCon = new SemanticConcept();
		ncbiSegMethodCatCon.setAccession("0234");
		ncbiSegMethodCatCon.setConceptUri("http://edamontology.org/operation_0234");
		ncbiSegMethodCatCon.setOntologyName("EDAM");
		ncbiSegMethodCatCon.setTerm("Sequence complexity calculation");
		ncbiSegMethodCatConList.add(ncbiSegMethodCatCon);
		
		////Citation subelement
		List<EntryReference> ncbiSegMethodCitationList = ncbiSegMethod.getCitation();
		EntryReference ncbiSegMethodCitation = new EntryReference();
		GregorianCalendar cal = new GregorianCalendar(1993, GregorianCalendar.JUNE, 1);
		try
		{
			ncbiSegMethodCitation.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		} catch (DatatypeConfigurationException e) {} //NOTE don't see how this could go wrong...
		//NOTE Not indexed in PubMed and I wouldn't consider ScienceDirect a database, so nothing else to add here
		ncbiSegMethodCitationList.add(ncbiSegMethodCitation);
		methodDescList.add(ncbiSegMethod);
		
		//ScoreType element
		populateScoreTypes(bwocr.getScoreType());
		
		//Annotation
		populateAnnotation(bwocr.getAnnotation());
	}
	
	private void populateScoreTypes(List<ScoreType> list)
	{
		ScoreType st = new ScoreType();
		list.add(st);
		
		//Populate score type
		st.setLocalId("S#lc");
		st.setName("Low complexity segment prediction");
		st.setNote("The binary prediction whether the segment is low complexity");
	}
	
	private void populateAnnotation(List<Annotation> list)
	{
		Annotation a = new Annotation();
		list.add(a);
		
		//Populate annotation
		///Feature
		FeatureType aF = new FeatureType();
		a.setFeature(aF);
		
		List<JAXBElement<?>> aFChildren = aF.getContent(); 
		JAXBElement<String> aFName = new JAXBElement<String>(new QName("http://bioxsd.org/BioXSD-1.1","name","bx"), String.class , "Low complexity residue");
		aFChildren.add(aFName);

		//////Equal concept subelement
		SemanticConcept equalConcept = new SemanticConcept();
		equalConcept.setTerm("low_complexity_region");
		equalConcept.setConceptUri("http://purl.obolibrary.org/obo/SO_0001005");
		equalConcept.setAccession("0001005");
		equalConcept.setOntologyName("Sequence Ontology");
		JAXBElement<SemanticConcept> afEqualConcept = new JAXBElement<SemanticConcept>(
				new QName("http://bioxsd.org/BioXSD-1.1", "equalConcept","bx"), SemanticConcept.class, equalConcept);
		aFChildren.add(afEqualConcept);
		
		//Condensed References
		CondensedReferences cr =  new CondensedReferences();
		cr.setMethodIdRef(methodLocalId);
		
		//Occurrences
		List<Occurrence> lOcc = a.getOccurrence();
		populateOccurences(lOcc);
	}
	
	private void populateOccurences(List<Occurrence> list)
	{
		List<Pair> lcrs = nsObj.lowComplexityRegions;
		for (Pair region : lcrs)
		{
			Occurrence temp = new Occurrence();
			list.add(temp);
			
			//Position
			SequencePosition sp = new SequencePosition();
			GeneralSequenceSegment gse = new GeneralSequenceSegment();
			gse.setMin(Long.valueOf(region.getFirst()));
			gse.setMax(Long.valueOf(region.getSecond()));
			sp.getSegment().add(gse);
			temp.setPosition(sp);
			
			//ScoreList 
			List<Score> ls = temp.getScore();
			
			Score s = new Score();
			s.setScoreTypeIdRef(scoreLowCompl);
			s.setValue("true"); //NOTE not the most ideal thing, but every score must contain a value...
			ls.add(s);
		}
		
		List<Pair> hcrs = nsObj.normalComplexityRegions;
		for (Pair region : hcrs)
		{
			Occurrence temp = new Occurrence();
			list.add(temp);
			
			//Position
			SequencePosition sp = new SequencePosition();
			GeneralSequenceSegment gse = new GeneralSequenceSegment();
			gse.setMin(Long.valueOf(region.getFirst()));
			gse.setMax(Long.valueOf(region.getSecond()));
			sp.getSegment().add(gse);
			temp.setPosition(sp);
			
			//ScoreList 
			List<Score> ls = temp.getScore();
			
			Score s = new Score();
			s.setScoreTypeIdRef(scoreLowCompl);
			s.setValue("false");
			ls.add(s);
		}
	}
	
	/**
	 * Finalize XML and write to stdout. Requires previous execution of make()
	 */
	public void marshal()
	{
		try
		{
			JAXBElement<FeatureRecord> je = of.createLowComplexityRegion(fr);
			
			JAXBContext jc = JAXBContext.newInstance("ncbisegout");
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://i12r-tbl.informatik.tu-muenchen.de/~jonas/ncbiseq/output http://i12r-tbl.informatik.tu-muenchen.de/~jonas/ncbisegout.xsd");
			m.marshal(je, System.out);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
