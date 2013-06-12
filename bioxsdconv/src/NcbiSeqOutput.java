import java.util.*;
import javax.xml.bind.*;

import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;

import ncbiseqout.*;
import ncbiseqout.FeatureRecord.BlockWithOccurrenceReferences;
import ncbiseqout.FeatureRecord.ReferenceSequence;

public class NcbiSeqOutput
{
	private ObjectFactory of;
	private FeatureRecord fr;
	
	public NcbiSeqOutput()
	{
		of = new ObjectFactory();
		fr = of.createFeatureRecord();
	}
	
	public void make(String test)
	{
//		FeatureRecord fr = of.createFeatureRecord();
		ReferenceSequence refSeq = new ReferenceSequence();
		BiosequenceRecord bioSeqRec = new BiosequenceRecord();
		bioSeqRec.setSequence(test);
		refSeq.setSequenceRecord(bioSeqRec);
		fr.setReferenceSequence(refSeq);		
		BlockWithOccurrenceReferences bocc = (BlockWithOccurrenceReferences)fr.getAnnotationOrBlockWithOccurrenceReferences();
		bocc.
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
