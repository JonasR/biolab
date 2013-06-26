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


public class ProfIsisOutput {


private final String methodLocalId = "M#Pi";
	
	private ObjectFactory of;
	private FeatureRecord fr;
	private List<Long> ppiSites;
	
	public ProfIsisOutput(List<Long> ppiSites)
	{
		of = new ObjectFactory();
		fr = of.createFeatureRecord();
		this.ppiSites = ppiSites;
	}
	
	public void make(String refSequence) throws DatatypeConfigurationException
	{
		ReferenceSequence refSeq = new ReferenceSequence();
		BiosequenceRecord bioSeqRec = new BiosequenceRecord();
		bioSeqRec.setSequence(refSequence);
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
//		piMethod.set
		
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
		piMethodCitation.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(2007, 1, 15))); //output is too long, find a way to shorten this? 
		piMethodCitation.setDbName("PubMed");
		piMethodCitation.setDbUri("http://www.ncbi.nlm.nih.gov/pubmed");
		piMethodCitation.setAccession("17237081");
		
		//NOTE: no relevant input and output parameters
		
		populateScoreTypes(bwocr.getScoreType());
		
		//Annotation element
		populateAnnotation(bwocr.getAnnotation());
	}
	
	private void populateScoreTypes(List<ScoreType> list)
	{
		ScoreType st = new ScoreType();
		list.add(st);
		
		//Populate score type
		st.setLocalId("S#pi");
		st.setName("Protein-protein interaction");
		
		// NOTE I don't believe we have anything to put into the code below...
//		List<profisisout.Method> methodList= st.getMethod();
//		profisisout.Method stMet = new profisisout.Method();
//		stMet.setName("Protein-protein interaction");
//		methodList.add(stMet);
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
		populateOccurences(lOcc, this.ppiSites);
	}
	
	private void populateOccurences(List<Occurrence> list, List<Long> positions)
	{
		for (Long pos : positions)
		{
			Occurrence temp = new Occurrence();
			//Position
			SequencePosition sp = new SequencePosition();
			GeneralSequencePoint gsp = new GeneralSequencePoint();
			gsp.setPos(pos);
			sp.getPoint().add(gsp);
			temp.setPosition(sp);
			
			//Score
			List<Score> ls = temp.getScore();
			Score s = new Score();
			s.setScoreTypeIdRef("S#pi");
			s.setValue("affe");	// TODO insert value here, we need a second list, or a hash
			ls.add(s);
			
			list.add(temp);
		}
	}
	
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
