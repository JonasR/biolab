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
import ncbisegout.FeatureRecord.Annotation.CondensedReferences;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences.Annotation;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences.Annotation.Occurrence;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences.Method;
import ncbisegout.FeatureRecord.BlockWithOccurrenceReferences.ScoreType;
import ncbisegout.FeatureRecord.ReferenceSequence;
import ncbisegout.FeatureType;
import ncbisegout.GeneralSequencePoint;
import ncbisegout.ObjectFactory;
import ncbisegout.Score;
import ncbisegout.SemanticConcept;
import ncbisegout.SequencePosition;

public class NcbiSeqOutput
{
	private final String methodLocalId = "M#Se";
	
	private ObjectFactory of;
	private FeatureRecord fr;
	private List<Long> lowComplexityPositions;
	
	public NcbiSeqOutput(List<Long> lowComplexityPositions)
	{
		of = new ObjectFactory();
		fr = of.createFeatureRecord();
		this.lowComplexityPositions = lowComplexityPositions;
	}
	
	public void make(String test) throws DatatypeConfigurationException
	{
		//TODO the whole namespace thing is still somewhat off
		
//		FeatureRecord fr = of.createFeatureRecord();
		ReferenceSequence refSeq = new ReferenceSequence();
		BiosequenceRecord bioSeqRec = new BiosequenceRecord();
		bioSeqRec.setSequence(test);
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
		ncbiSegMethodCitation.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(1993, 06, 01))); //output is too long, find a way to shorten this. (also make sure it shows 06 not 07..)
		//TODO does not seem to be in pubmed, so nothing else to do here i guess?
		ncbiSegMethodCitationList.add(ncbiSegMethodCitation);
		methodDescList.add(ncbiSegMethod);
		
		
		//ScoreTypes NOTE not sure if we even need this?
		//ScoreType requires a 'value' which we don't have, so I guess we don't do this
//		populateScoreTypes(bwocr.getScoreType());
		
		//Annotation
		populateAnnotation(bwocr.getAnnotation());
	}
	
	/**
	 * @param list 
	 * 
	 */
	private void populateScoreTypes(List<ScoreType> list)
	{
		ScoreType st = new ScoreType();
		list.add(st);
		
		//Populate score type
		st.setLocalId("S#lc");
		
		//NOTE below maybe not needed?
		st.setName("Low complexity residue");
		List<ncbisegout.Method> methodList= st.getMethod();
		ncbisegout.Method stMet = new ncbisegout.Method();
		stMet.setName("Low complexity residue");
	}
	
	private void populateAnnotation(List<Annotation> list)
	{
		Annotation a = new Annotation();
		list.add(a);
		
		//Populate annotation
		///Feature
		FeatureType aF = new FeatureType();
		a.setFeature(aF);
		List<JAXBElement<?>> aFChildren = aF.getContent(); //alowed in there: JAXBElement<String> JAXBElement<FeatureTypeDetails> JAXBElement<String> JAXBElement<SemanticConcept> JAXBElement<SemanticConcept> JAXBElement<String>
		JAXBElement<String> aFName = new JAXBElement<String>(new QName("http://bioxsd.org/BioXSD-1.1","name","bx"), String.class , "Low complexity residue");
//		SemanticConcept equalConcept = new SemanticConcept();
//		equalConcept.setTerm("")
//		JAXBElement<SemanticConcept> afEqualConcept = new JAXBElement<SemanticConcept>(new QName("equalConcept"), null, new SemanticConcept().s);
		aFChildren.add(aFName);
		
		//Condensed References
		CondensedReferences cr =  new CondensedReferences();

		//TODO how to add methodidref?
		
		//Occurrences
		List<Occurrence> lOcc = a.getOccurrence();
		populateOccurences(lOcc, lowComplexityPositions);
	}
	
	private void populateOccurences(List<Occurrence> list, List<Long> positions)
	{
		for (Long pos : positions)
		{
			Occurrence temp = new Occurrence();
			//position
			SequencePosition sp = new SequencePosition();
			GeneralSequencePoint gsp = new GeneralSequencePoint();
			gsp.setPos(pos);
			sp.getPoint().add(gsp);
			temp.setPosition(sp);
			//score
//			List<Score> ls = temp.getScore();
//			Score s = new Score();
//			s.setScoreTypeIdRef("S#lc");
//			ls.add(s);
			
			list.add(temp);
		}
	}
	
	
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
