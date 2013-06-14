import java.util.*;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import ncbiseqout.BiosequenceRecord;
import ncbiseqout.EntryReference;
import ncbiseqout.FeatureRecord;
import ncbiseqout.FeatureRecord.BlockWithOccurrenceReferences.Annotation;
import ncbiseqout.FeatureRecord.BlockWithOccurrenceReferences.Method;
import ncbiseqout.FeatureRecord.BlockWithOccurrenceReferences;
import ncbiseqout.FeatureRecord.BlockWithOccurrenceReferences.ScoreType;
import ncbiseqout.SemanticConcept;
import ncbiseqout.FeatureRecord.ReferenceSequence;
import ncbiseqout.ObjectFactory;

public class NcbiSeqOutput
{
	private ObjectFactory of;
	private FeatureRecord fr;
	
	public NcbiSeqOutput()
	{
		of = new ObjectFactory();
		fr = of.createFeatureRecord();
	}
	
	public void make(String test) throws DatatypeConfigurationException
	{
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
		ncbiSegMethod.setLocalId("M#seg");
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
		
		
		//ScoreTypes
		populateScoreTypes(bwocr.getScoreType());
		
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
		
	}
	
	private void populateAnnotation(List<Annotation> list)
	{
		Annotation a = new Annotation();
		list.add(a);
		
		//Populate annotation
		
	}
	
	public void marshal()
	{
		try
		{
			JAXBElement<FeatureRecord> je = of.createLowComplexityRegion(fr);
			
			JAXBContext jc = JAXBContext.newInstance("ncbiseqout");
			Marshaller m = jc.createMarshaller();
			m.marshal(je, System.out);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
