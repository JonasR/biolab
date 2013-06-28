package ncbisegout.filereader;



import java.util.ArrayList;

public class NcbiSegObject{
    public String idLine;
    public String Sequence;
    public ArrayList<Pair> lowComplexityRegions;
    public ArrayList<Pair> normalComplexityRegions;

    public NcbiSegObject(){
        lowComplexityRegions = new ArrayList <Pair>();
        normalComplexityRegions = new ArrayList <Pair>();
    }

}
