import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;


public class testmain {

	/**
	 * @param args
	 * @throws DatatypeConfigurationException 
	 */
	public static void main(String[] args) throws DatatypeConfigurationException
	{
		List<Long> ll = new ArrayList<Long>();
		ll.add(100L);
		ll.add(200L);
		
		NcbiSeqOutput n = new NcbiSeqOutput(ll);
		n.make("CCCCCCCCCCCCCCCCGGGGG");
		n.marshal();

	}

}
