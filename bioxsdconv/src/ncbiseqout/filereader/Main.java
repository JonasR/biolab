package ncbiseqout.filereader;

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
        NcbiSegObject obj = fr.read_ncbiseg_noParam(new File("/home/delur/biolab/ncbi-seg/ncbi_noParam.txt") );

        System.out.println(obj.idLine);
        System.out.println(obj.Sequence);
    }
}