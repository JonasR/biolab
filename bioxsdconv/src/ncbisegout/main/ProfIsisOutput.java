package ncbisegout.main;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;

import profisisout.FeatureRecord.BlockWithOccurrenceReferences.ScoreType;

import profisisout.GeneralSequencePoint;
import profisisout.SequencePosition;

import profisisout.FeatureType;
import profisisout.FeatureRecord.BlockWithOccurrenceReferences.Annotation.CondensedReferences;
import profisisout.FeatureRecord.BlockWithOccurrenceReferences.Annotation;
import profisisout.FeatureRecord.BlockWithOccurrenceReferences.Annotation.Occurrence;
import profisisout.BiosequenceRecord;
import profisisout.EntryReference;
import profisisout.FeatureRecord;
import profisisout.ObjectFactory;
import profisisout.Score;
import profisisout.SemanticConcept;
import profisisout.FeatureRecord.BlockWithOccurrenceReferences;
import profisisout.FeatureRecord.ReferenceSequence;
import profisisout.FeatureRecord.BlockWithOccurrenceReferences.Method;
import profisisout.filereader.AminoAcid;
import profisisout.filereader.ProfIsisObject;

/**
 * Write Profisis output to an XML file
 * @author jonas
 *
 */
public class ProfIsisOutput {


	private final String methodLocalId = "M#Pi";
	private final String scorePPIValue = "S#pi";
	private final String scorePPIBool = "S#pr";
	
	private ObjectFactory of;
	private FeatureRecord fr;
	private ProfIsisObject piObj;
	
	/**
	 * 
	 * @param piObj Contains the output of the profisis run
	 */
	public ProfIsisOutput(ProfIsisObject piObj)
	{
		of = new ObjectFactory();
		fr = of.createFeatureRecord();
		this.piObj = piObj;
	}
	
	/**
	 * Create XML
	 */
	public void make()
	{
		ReferenceSequence refSeq = new ReferenceSequence();
		BiosequenceRecord bioSeqRec = new BiosequenceRecord();
		bioSeqRec.setSequence(piObj.Sequence);
		refSeq.setSequenceRecord(bioSeqRec);
		fr.setReferenceSequence(refSeq);
		
		List<Object> bwocrList = fr.getAnnotationOrBlockWithOccurrenceReferences();
		BlockWithOccurrenceReferences bwocr =  new BlockWithOccurrenceReferences();
		bwocrList.add(bwocr);
		
		//Method element
		List<FeatureRecord.BlockWithOccurrenceReferences.Method> methodDescList = bwocr.getMethod();
		Method piMethod = new Method();
		methodDescList.add(piMethod);
		piMethod.setVersion("1.0.11");
		piMethod.setLocalId(methodLocalId);
		piMethod.setName("profisis");
//		piMethod.setWsdl(value)
		
		////Category concept subelement
		List<SemanticConcept> piMethodCatConList = piMethod.getCategoryConcept();
		SemanticConcept piMethodCatCon = new SemanticConcept();
		piMethodCatConList.add(piMethodCatCon);
		piMethodCatCon.setAccession("2464");
		piMethodCatCon.setConceptUri("http://edamontology.org/operation_2464");
		piMethodCatCon.setOntologyName("EDAM");
		piMethodCatCon.setTerm("Protein-protein interaction prediction");
		
		////Citation subelement
		List<EntryReference> piMethodCitationList = piMethod.getCitation();
		EntryReference piMethodCitation = new EntryReference();
		piMethodCitationList.add(piMethodCitation);
		GregorianCalendar cal = new GregorianCalendar(2007, 1, 15);
		try
		{
			piMethodCitation.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		} catch (DatatypeConfigurationException e) {} //this cannot go wrong... 
		piMethodCitation.setDbName("PubMed");
		piMethodCitation.setDbUri("http://www.ncbi.nlm.nih.gov/pubmed");
		piMethodCitation.setAccession("17237081");
		
		//Score type element
		populateScoreTypes(bwocr.getScoreType());
		
		//Annotation element
		populateAnnotation(bwocr.getAnnotation());
	}
	
	private void populateScoreTypes(List<ScoreType> list)
	{
		ScoreType st = new ScoreType();
		ScoreType st2 = new ScoreType();
		list.add(st);
		list.add(st2);
		
		//Populate score type
		st.setLocalId(scorePPIValue);
		st.setName("Protein-protein interaction score");
		st.setNote("The raw score");
		
		st2.setLocalId(scorePPIBool);
		st2.setName("Protein-protein interaction prediction");
		st2.setNote("The binary prediction whether the residue is an interacting residue or not");
	}
	
	private void populateAnnotation(List<Annotation> list)
	{
		Annotation a = new Annotation();
		list.add(a);
		
		//Populate annotation
		////Feature
		FeatureType aF = new FeatureType();
		a.setFeature(aF);
		
		List<JAXBElement<?>> aFChildren = aF.getContent();
		JAXBElement<String> aFName = new JAXBElement<String>(new QName("http://bioxsd.org/BioXSD-1.1","name","bx"), String.class , "Protein-protein interaction site");
		aFChildren.add(aFName);
		
		//////Equal concept subelement
		SemanticConcept equalConcept = new SemanticConcept();
		equalConcept.setTerm("protein_protein_contact");
		equalConcept.setConceptUri("http://purl.obolibrary.org/obo/SO_0001093");
		equalConcept.setAccession("0001093");
		equalConcept.setOntologyName("Sequence Ontology");
		JAXBElement<SemanticConcept> afEqualConcept = new JAXBElement<SemanticConcept>(
				new QName("http://bioxsd.org/BioXSD-1.1", "equalConcept","bx"), SemanticConcept.class, equalConcept);
		aFChildren.add(afEqualConcept);
		
		//Condensed References
		CondensedReferences cr =  new CondensedReferences();
		cr.setMethodIdRef(this.methodLocalId);
		
		//Occurrences
		List<Occurrence> lOcc = a.getOccurrence();
		populateOccurences(lOcc, this.piObj);
	}
	
	private void populateOccurences(List<Occurrence> list, ProfIsisObject piObj)
	{
		List<AminoAcid> positions = piObj.positions;
		for (AminoAcid aa: positions)
		{		
			Occurrence temp = new Occurrence();
			list.add(temp);
			
			//Position
			SequencePosition sp = new SequencePosition();
			GeneralSequencePoint gsp = new GeneralSequencePoint();
			gsp.setPos(Long.valueOf(aa.position));
			sp.getPoint().add(gsp);
			temp.setPosition(sp);
			
			//ScoreList
			List<Score> ls = temp.getScore();
			
			Score s = new Score();
			s.setScoreTypeIdRef(scorePPIValue);
			s.setValue(aa.value+"");
			ls.add(s);
			
			Score s2 = new Score();
			s2.setScoreTypeIdRef(scorePPIBool);
			s2.setValue(aa.prediction+"");
			ls.add(s2);
		}
	}
	
	/**
	 * Finalize XML and write to stdout. Requires previous execution of make()
	 */
	public void marshal()
	{
		try
		{
			JAXBElement<FeatureRecord> je = of.createProteinProteinInteractionSite(fr);
			
			JAXBContext jc = JAXBContext.newInstance("profisisout");
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://i12r-tbl.informatik.tu-muenchen.de/~jonas/profisis/output http://i12r-tbl.informatik.tu-muenchen.de/~jonas/profisisout.xsd");
			m.marshal(je, System.out);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
