//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.15 at 10:06:18 PM CEST 
//


package ncbisegout;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutsidePositionCorrespondance.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OutsidePositionCorrespondance">
 *   &lt;restriction base="{http://bioxsd.org/BioXSD-1.1}Name">
 *     &lt;enumeration value="In chromosome/scaffold/contig"/>
 *     &lt;enumeration value="In explicit sequence"/>
 *     &lt;enumeration value="In implicit supersequence"/>
 *     &lt;enumeration value="Relative to 1st translated base"/>
 *     &lt;enumeration value="Relative to 1st transcribed base"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OutsidePositionCorrespondance")
@XmlEnum
public enum OutsidePositionCorrespondance {


    /**
     * The outside position is in the nucleotide sequence of the either explicitly given chromosome or scaffold/contig, or the chromosome/scaffold/contig of the reference sequence.
     * Outside-positions 1..m are positions in the chromosome
     * 
     */
    @XmlEnumValue("In chromosome/scaffold/contig")
    IN_CHROMOSOME_SCAFFOLD_CONTIG("In chromosome/scaffold/contig"),

    /**
     * The outside position is in an explicitly referenced nucleotide or amino-acid sequence. Can but does not have to be a supersequence of the reference sequence.
     * Outside-positions 1..m are in the explicitly referenced supersequence. Fill in the 'explicitSequenceReference' element
     * 
     */
    @XmlEnumValue("In explicit sequence")
    IN_EXPLICIT_SEQUENCE("In explicit sequence"),

    /**
     * The outside position is in a nucleotide or amino-acid supersequence (respectively) of the reference subsequence.
     * Positions 1..n correspond, position -1 is the preceding (next point to the left) from 1
     * 
     */
    @XmlEnumValue("In implicit supersequence")
    IN_IMPLICIT_SUPERSEQUENCE("In implicit supersequence"),

    /**
     * The outside position is in a nucleotide sequence.
     * Position 1 corresponds to the 1st base of the 1st translated codon within the reference isoform, position -1 is the next to the left from 1
     * (NB. CDSs include the start and stop codons: do not use this correspondance option for outside features of CDSs)
     * 
     */
    @XmlEnumValue("Relative to 1st translated base")
    RELATIVE_TO_1_ST_TRANSLATED_BASE("Relative to 1st translated base"),

    /**
     * The outside position is in a nucleotide sequence.
     * Position 1 corresponds to the 1st base transcribed within the reference isoform, position -1 is the next to the left from 1
     * 
     */
    @XmlEnumValue("Relative to 1st transcribed base")
    RELATIVE_TO_1_ST_TRANSCRIBED_BASE("Relative to 1st transcribed base");
    private final String value;

    OutsidePositionCorrespondance(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OutsidePositionCorrespondance fromValue(String v) {
        for (OutsidePositionCorrespondance c: OutsidePositionCorrespondance.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
