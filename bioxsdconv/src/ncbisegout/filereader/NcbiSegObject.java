package ncbisegout.filereader;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: delur
 * Date: 6/13/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */

public class NcbiSegObject{
    public String idLine;
    public String Sequence;
    public ArrayList<Pair<Integer,Integer>> lowComplexityRegions;
    public ArrayList<Pair<Integer,Integer>> normalComplexityRegions;

    public NcbiSegObject(){
        lowComplexityRegions = new ArrayList <Pair<Integer,Integer>>();
        normalComplexityRegions = new ArrayList <Pair<Integer,Integer>>();
    }

}
