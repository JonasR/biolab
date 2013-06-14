import javax.xml.datatype.DatatypeConfigurationException;


public class testmain {

	/**
	 * @param args
	 * @throws DatatypeConfigurationException 
	 */
	public static void main(String[] args) throws DatatypeConfigurationException
	{
		NcbiSeqOutput n = new NcbiSeqOutput();
		n.make("CCCCCCCCCCCCCCCCGGGGG");
		n.marshal();

	}

}
