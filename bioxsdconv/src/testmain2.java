import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import profisisout.filereader.FileReader;


public class testmain2 {

	/**
	 * @param args
	 * @throws DatatypeConfigurationException 
	 */
	public static void main(String[] args) throws DatatypeConfigurationException {
		// TODO Auto-generated method stub

		List<Long> ll = new ArrayList<Long>();
		ll.add(100L);
		ll.add(200L);
		
		FileReader fr = new FileReader();
		ProfIsisOutput n = new ProfIsisOutput(fr.read_profisis_prvalParam(new File("/home/jonas/gitRepos/biolab/data/output/profisisoutprval.profisis")));
		n.make();
		n.marshal();

	}

}
