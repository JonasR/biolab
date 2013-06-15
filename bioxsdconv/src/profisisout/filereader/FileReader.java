package profisisout.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: delur
 * Date: 6/15/13
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
class ProfIsisObject{
    String idLine;
    String Sequence;
    ArrayList<AminoAcid> positions;


    ProfIsisObject(){
        positions = new ArrayList <AminoAcid>();
    }

}

class AminoAcid{
    int position;
    String aminoAcid;
    int value;
    boolean prediction;

    AminoAcid( int position, String aminoAcid, int value, boolean prediction){
        this.position = position;
        this.aminoAcid = aminoAcid;
        this.value = value;
        this.prediction = prediction;
    }
}


public class FileReader {
    BufferedReader in;
    ProfIsisObject profIsisObject;

    public ProfIsisObject read_profisis_ppParam(File file){
        profIsisObject = new ProfIsisObject();
        String sequence = "";
        String prediction = "";
        try {
            in = new BufferedReader( new java.io.FileReader( file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            String strLine;
            while( (strLine = in.readLine()) != null && !(strLine.startsWith("1 ")) ){
                if ( strLine.startsWith(">") ){  //read headerline
                    profIsisObject.idLine = strLine.substring(1);
                    strLine = in.readLine(); // read next line to continue processing
                }
                sequence += strLine; // first line is the sequence
                prediction +=  in.readLine(); // second is the prediction
                in.readLine();// third is empty

            }

            // dropped out of while loop =>  <position> <aminoacid> <score> list starts; process first line that was already read
            String[] tokens = strLine.split("\\s");
            int tmp = Integer.valueOf(tokens[0]);
            profIsisObject.positions.add(new AminoAcid(tmp, tokens[1], Integer.valueOf(tokens[2]),prediction.charAt(tmp -1)=='P' ));

            while( (strLine = in.readLine()) != null)  {
                tokens = strLine.split("\\s");
                tmp = Integer.valueOf(tokens[0]);
                profIsisObject.positions.add(new AminoAcid(tmp, tokens[1], Integer.valueOf(tokens[2]),prediction.charAt(tmp -1)=='P' ));
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        profIsisObject.Sequence = sequence;
        return profIsisObject;
    }

    public ProfIsisObject read_profisis_prvalParam(File file){
        profIsisObject = new ProfIsisObject();
        String sequence = "";
        try {
            in = new BufferedReader( new java.io.FileReader( file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            String strLine;

            while( (strLine = in.readLine()) != null)  {
                String[] tokens = strLine.split("\\s");
                int tmp = Integer.valueOf(tokens[0]);
                profIsisObject.positions.add(new AminoAcid(tmp, tokens[1], Integer.valueOf(tokens[2]),false ));
                sequence += tokens[1];
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        profIsisObject.Sequence = sequence;
        return profIsisObject;
    }



}
