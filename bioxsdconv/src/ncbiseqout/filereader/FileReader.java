package ncbiseqout.filereader;



import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: delur
 * Date: 6/13/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */

class NcbiSegObject{
    String idLine;
    String Sequence;
    ArrayList<Pair<Integer,Integer>> lowComplexityRegions;
    ArrayList<Pair<Integer,Integer>> normalComplexityRegions;

    NcbiSegObject(){
        lowComplexityRegions = new ArrayList <Pair<Integer,Integer>>();
        normalComplexityRegions = new ArrayList <Pair<Integer,Integer>>();
    }

}


public class FileReader {
    BufferedReader in;
    NcbiSegObject ncbiSegObject = new NcbiSegObject();

    public NcbiSegObject read_ncbiseg_noParam(File file){
        String sequence = "";
        try {
            in = new BufferedReader( new java.io.FileReader( file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            String strLine;
            while( (strLine = in.readLine()) != null){
                if ( strLine.startsWith(">") ){  //read headerline
                    ncbiSegObject.idLine = strLine.substring(1);
                    strLine = in.readLine();  //skip empty line
                }

                String[] tokens = strLine.split("\\s");
                if (tokens[0].matches("[\\s]*[a-z]+") ) { // low complexity Region
                    if (tokens[1].matches("-")){ //first line of region, add region to list
                        String[] positions = tokens[1].split("-");
                        Integer first = Integer.parseInt(positions[0]);
                        Integer second = Integer.parseInt(positions[1]);
                        ncbiSegObject.lowComplexityRegions.add(new Pair<Integer,Integer>(first , second));
                    }
                    // add string to sequence
                    sequence += tokens[0].trim();

                }
                else if ( tokens[tokens.length-1].matches("[A-Z]+") ){ // normal complexity region
                    if (tokens[tokens.length-2].matches("-")){ //first line of region, add region to list
                        String[] positions = tokens[tokens.length-2].split("-");
                        Integer first = Integer.parseInt(positions[0]);
                        Integer second = Integer.parseInt(positions[1]);
                        ncbiSegObject.normalComplexityRegions.add(new Pair<Integer,Integer>(first , second));
                    }
                    // add string to sequence
                    sequence += tokens[tokens.length-1].trim();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        ncbiSegObject.Sequence = sequence;
        return ncbiSegObject;
    }

}
