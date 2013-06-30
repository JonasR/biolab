package ncbisegout.filereader;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: delur
 * Date: 6/13/13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        //Tests
        FileReader fr = new FileReader();
        NcbiSegObject obj = fr.read_ncbiseg_noParam(new File("/home/delur/biolab/ncbi-seg/ncbi_N.txt") );

        System.out.println(obj.idLine);
        System.out.println(obj.Sequence);
        System.out.println("Low Complexity:");
        for (Pair p : obj.lowComplexityRegions){
            System.out.println(p.first + " - " + p.second);
        }

        System.out.println();

        System.out.println("Normal Complexity:");
        for (Pair p : obj.normalComplexityRegions){
            System.out.println(p.first + " - " + p.second);
        }
    }
}
