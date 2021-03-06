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
 * <p>Java class for RecommendedVerdict.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RecommendedVerdict">
 *   &lt;restriction base="{http://bioxsd.org/BioXSD-1.1}Name">
 *     &lt;enumeration value="Present"/>
 *     &lt;enumeration value="Putative"/>
 *     &lt;enumeration value="Improbable"/>
 *     &lt;enumeration value="Not present"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RecommendedVerdict")
@XmlEnum
public enum RecommendedVerdict {

    @XmlEnumValue("Present")
    PRESENT("Present"),
    @XmlEnumValue("Putative")
    PUTATIVE("Putative"),
    @XmlEnumValue("Improbable")
    IMPROBABLE("Improbable"),
    @XmlEnumValue("Not present")
    NOT_PRESENT("Not present");
    private final String value;

    RecommendedVerdict(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecommendedVerdict fromValue(String v) {
        for (RecommendedVerdict c: RecommendedVerdict.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
