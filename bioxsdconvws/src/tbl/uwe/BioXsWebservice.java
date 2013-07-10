package tbl.uwe;
/**
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.jws.WebMethod;  
import javax.jws.WebService;  

import ncbisegout.filereader.FileReader;
import ncbisegout.main.NcbiSeqOutput;
/**
 * @author uwe
 *
 */
@WebService  
public class BioXsWebservice {  
      
    @WebMethod  
    public String version() throws FileNotFoundException {  
    	return "0.0.1-1";  
    }  
    
    @WebMethod  
    public String test() throws FileNotFoundException {  
    	BioXsWebservice bxws = new BioXsWebservice();
    	
    	String in = ">PRIO_HUMAN MAJOR PRION PROTEIN PRECURSOR\n"+
					"             .         .         .         .         .         .\n"+
					"  1 MANLGCWMLVLFVATWSDLGLCKKRPKPGGWNTGGSRYPGQGSPGGNRYppqggggwgqp\n"+
					" 61 hgggwgqphgggwgqphgggwgqphgggwgqgggTHSQWNKPSKPKTNMKHMagaaaaga\n"+
					"121 vvgglggymlgsamsRPIIHFGSDYEDRYYRENMHRYPNQVYYRPMDEYSNQNNFVHDCV\n"+
					"181 NITIKQHtvttttkgenftetDVKMMERVVEQMCITQYERESQAYYQRGSSMVLFSsppv\n"+
					"241 illisfliflivG 253";
    	
    	return bxws.doConvert(in);
        //return "0.0.1-1";  
    }  
    
    public static void main (String[] args) throws FileNotFoundException
    {
    	BioXsWebservice bxws = new BioXsWebservice();
    	
    	System.out.println(bxws.test());
    }
    
    @WebMethod  
	public String doConvert(String seq) throws FileNotFoundException
	{
		if(seq.length() == 0)
		{
			System.err.println("Please supply output file as first command line argument");
			System.exit(1);
		}
		
		PrintStream out = null;
		try {
		    out = new PrintStream(new FileOutputStream("/var/tmp/seq.tmp"));
		    out.print(seq);
		}
		finally {
		    if (out != null) out.close();
		}
		
		File fOutput = new File("/var/tmp/seq.tmp");
		
		FileReader fr = new FileReader();
		NcbiSeqOutput n = new NcbiSeqOutput(fr.read_ncbiseg_qParam(fOutput));
		
		n.make();
		
		return n.marshalToString();
	}
	
    
}  