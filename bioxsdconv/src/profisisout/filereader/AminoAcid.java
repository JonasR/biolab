package profisisout.filereader;

public class AminoAcid{
    public int position;
    public String aminoAcid;
    public int value;
    public boolean prediction;

    public AminoAcid( int position, String aminoAcid, int value, boolean prediction){
        this.position = position;
        this.aminoAcid = aminoAcid;
        this.value = value;
        this.prediction = prediction;
    }
}
