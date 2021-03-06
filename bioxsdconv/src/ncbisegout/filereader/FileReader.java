package ncbisegout.filereader;





import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {
    BufferedReader in;
    NcbiSegObject ncbiSegObject;

    public NcbiSegObject read_ncbiseg_noParam(File file){
        ncbiSegObject = new NcbiSegObject();
        String sequence = "";
        try {
            in = new BufferedReader( new java.io.FileReader( file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            String strLine = in.readLine();
            if ( strLine.startsWith(">") ){  //read headerline
                ncbiSegObject.idLine = strLine.substring(1);
                in.readLine();  //skip empty line
            }

            while( (strLine = in.readLine()) != null){
                String[] tokens = strLine.trim().split("[\\s]+");

                if (tokens[0].matches("([a-z]+)") ) { // low complexity Region
                    if (tokens.length !=1){
                        if (tokens[1].matches("[\\d]+.[\\d]+")){ //first line of region, add region to list
                            String[] positions = tokens[1].split("-");
                            Integer first = Integer.parseInt(positions[0]);
                            Integer second = Integer.parseInt(positions[1]);
                            ncbiSegObject.lowComplexityRegions.add(new Pair(first , second));

                        }
                    }

                    // add string to sequence
                    sequence += tokens[0].trim();

                }
                else if ( tokens[tokens.length-1].matches("[A-Z]+") ){ // normal complexity region
                    //System.out.println("High complexity!");

                    if (tokens.length !=1){
                        if (tokens[0].matches("[\\d]+.[\\d]+")){ //first line of region, add region to list
                            //System.out.println("inner if!");
                            String[] positions = tokens[tokens.length-2].split("-");
                            Integer first = Integer.parseInt(positions[0]);
                            Integer second = Integer.parseInt(positions[1]);
                            ncbiSegObject.normalComplexityRegions.add(new Pair(first , second));
                        }
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

    public NcbiSegObject read_ncbiseg_qParam(File file){
        ncbiSegObject = new NcbiSegObject();
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
                for ( int i = 0; i < tokens.length; i++){
                    if (tokens[i].length() <= 4 ) { // properbly numbering => ignore
                    }
                    else{
                        sequence += tokens[i].trim();
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        ncbiSegObject.Sequence = sequence;

        {
            // build Region lists from Sequence
            boolean inLowComplexityRegion = Character.isLowerCase( sequence.charAt(0) );
            int first = 1;
            int second = 1;
            for (int i = 1; i < sequence.length(); i++){
                if ( inLowComplexityRegion && Character.isLowerCase( sequence.charAt(i) ) ){
                    second = i+1;
                }
                else if( inLowComplexityRegion && Character.isUpperCase( sequence.charAt(i) ) ){
                    ncbiSegObject.lowComplexityRegions.add(new Pair(first , second));
                    inLowComplexityRegion = false;
                    first = i+1;
                    second = i+1;
                }
                else if ( !inLowComplexityRegion && Character.isUpperCase( sequence.charAt(i) ) ){
                    second = i+1;
                }
                else if( !inLowComplexityRegion && Character.isLowerCase( sequence.charAt(i) ) ){
                    ncbiSegObject.normalComplexityRegions.add(new Pair(first , second));
                    inLowComplexityRegion = true;
                    first = i+1;
                    second = i+1;
                }
            }
            second = sequence.length();
            if( inLowComplexityRegion){
                ncbiSegObject.lowComplexityRegions.add(new Pair(first , second));
            }
            else{
                ncbiSegObject.normalComplexityRegions.add(new Pair(first , second));
            }
        }
        return ncbiSegObject;
    }

    public NcbiSegObject read_ncbiseg_xParam(File file){
        ncbiSegObject = new NcbiSegObject();
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
                    continue;
                }

                sequence += strLine.trim();

            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        ncbiSegObject.Sequence = sequence;

        {
            // build Region lists from Sequence
            boolean inLowComplexityRegion = Character.isLowerCase( sequence.charAt(0) );
            int first = 1;
            int second = 1;
            for (int i = 1; i < sequence.length(); i++){
                if ( inLowComplexityRegion && Character.isLowerCase( sequence.charAt(i) ) ){
                    second = i+1;
                }
                else if( inLowComplexityRegion && Character.isUpperCase( sequence.charAt(i) ) ){
                    ncbiSegObject.lowComplexityRegions.add(new Pair(first , second));
                    inLowComplexityRegion = false;
                    first = i+1;
                    second = i+1;
                }
                else if ( !inLowComplexityRegion && Character.isUpperCase( sequence.charAt(i) ) ){
                    second = i+1;
                }
                else if( !inLowComplexityRegion && Character.isLowerCase( sequence.charAt(i) ) ){
                    ncbiSegObject.normalComplexityRegions.add(new Pair(first , second));
                    inLowComplexityRegion = true;
                    first = i+1;
                    second = i+1;
                }

            }
            second = sequence.length();
            if( inLowComplexityRegion){
                ncbiSegObject.lowComplexityRegions.add(new Pair(first , second));
            }
            else{
                ncbiSegObject.normalComplexityRegions.add(new Pair(first , second));
            }
        }
        return ncbiSegObject;
    }

}
