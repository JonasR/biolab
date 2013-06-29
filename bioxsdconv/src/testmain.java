import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import ncbisegout.filereader.FileReader;
import ncbisegout.main.NcbiSeqOutput;


public class testmain {

	/**
	 * @param args
	 * @throws DatatypeConfigurationException 
	 */
	public static void main(String[] args) throws DatatypeConfigurationException
	{
		if(args.length == 0)
		{
			System.err.println("Please supply output file as first command line argument");
			System.exit(1);
		}
		File fOutput = new File(args[0]);
		
		FileReader fr = new FileReader();
		NcbiSeqOutput n = new NcbiSeqOutput(fr.read_ncbiseg_noParam(fOutput));
		
		n.make();
		n.marshal();
	}
}
