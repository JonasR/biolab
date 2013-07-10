package ncbisegout.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import ncbisegout.filereader.FileReader;

/**
 * Convert a ncbi-seg output to XML using the XSD at http://i12r-tbl.informatik.tu-muenchen.de/~jonas/ncbisegout.xsd
 * @author jonas
 *
 */
public class CreateNCBISegSchemaInstance {

	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.err.println("Please supply output file as first command line argument");
			System.exit(1);
		}
		File fOutput = new File(args[0]);
		
		FileReader fr = new FileReader();
		NcbiSeqOutput n = new NcbiSeqOutput(fr.read_ncbiseg_qParam(fOutput));
		
		n.make();
		n.marshal();
	}

}
