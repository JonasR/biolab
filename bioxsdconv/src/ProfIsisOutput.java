import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import profisisout.BiosequenceRecord;
import profisisout.EntryReference;
import profisisout.FeatureRecord;
import profisisout.ObjectFactory;
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
		
		//TODO scoretypes
		
		//TODO annotation
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
