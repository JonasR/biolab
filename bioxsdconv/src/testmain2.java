import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;


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
		
		ProfIsisOutput n = new ProfIsisOutput(ll);
		n.make("CCCCCCCCCCCCCCCCGGGGG");
		n.marshal();

	}

}
