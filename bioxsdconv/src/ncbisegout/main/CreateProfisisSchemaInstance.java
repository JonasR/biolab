package ncbisegout.main;

import java.io.File;

import profisisout.filereader.FileReader;

/**
 * Convert a Profisis output to XML using the XSD at http://i12r-tbl.informatik.tu-muenchen.de/~jonas/profisisout.xsd
 * @author jonas
 *
 */
public class CreateProfisisSchemaInstance {

	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.err.println("Please supply output file as first command line argument");
			System.exit(1);
		}
		File fOutput = new File(args[0]);
		
		FileReader fr = new FileReader();
		ProfIsisOutput n = new ProfIsisOutput(fr.read_profisis_ppParam(fOutput));
		n.make();
		n.marshal();
	}

}
