//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.26 at 10:17:24 PM CEST 
//


package profisisout;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecommendedOntologyName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RecommendedOntologyName">
 *   &lt;restriction base="{http://bioxsd.org/BioXSD-1.1}Name">
 *     &lt;enumeration value="Gene Ontology"/>
 *     &lt;enumeration value="Sequence Ontology"/>
 *     &lt;enumeration value="ChEBI"/>
 *     &lt;enumeration value="EDAM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RecommendedOntologyName")
@XmlEnum
public enum RecommendedOntologyName {

    @XmlEnumValue("Gene Ontology")
    GENE_ONTOLOGY("Gene Ontology"),
    @XmlEnumValue("Sequence Ontology")
    SEQUENCE_ONTOLOGY("Sequence Ontology"),
    @XmlEnumValue("ChEBI")
    CH_EBI("ChEBI"),
    EDAM("EDAM");
    private final String value;

    RecommendedOntologyName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecommendedOntologyName fromValue(String v) {
        for (RecommendedOntologyName c: RecommendedOntologyName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
