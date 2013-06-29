package ncbisegout.filereader;

/**
 * Created with IntelliJ IDEA.
 * User: delur
 * Date: 6/13/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */

public class Pair
{
    public int getFirst() {
		return first;
	}
	public int getSecond() {
		return second;
	}
	int first;
    int second;
    public Pair(int first, int second){
         this.first = first;
        this.second = second;
    }
}
