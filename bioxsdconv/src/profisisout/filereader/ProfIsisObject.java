package profisisout.filereader;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: delur
 * Date: 6/15/13
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProfIsisObject{
    public String idLine;
    public String Sequence;
    public ArrayList<AminoAcid> positions;


    public ProfIsisObject(){
        positions = new ArrayList <AminoAcid>();
    }

}
