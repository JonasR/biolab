package profisisout.filereader;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: delur
 * Date: 6/15/13
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        //Tests
        FileReader fr = new FileReader();
        ProfIsisObject obj = fr.read_profisis_ppParam(new File("/home/delur/biolab/profisis/profisis_ppParam.txt"));

        System.out.println(obj.idLine);
        System.out.println(obj.Sequence);
        for( AminoAcid aa: obj.positions){
            System.out.print(aa.position + " " + aa.aminoAcid + " " + aa.prediction + " " + aa.value +"\n");
        }
    }
}
