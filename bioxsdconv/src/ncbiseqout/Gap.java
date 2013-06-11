//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 11:32:28 PM CEST 
//


package ncbiseqout;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Single gap in an aligned sequence
 * 
 * <p>Java class for Gap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Gap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="pos" use="required" type="{http://bioxsd.org/BioXSD-1.1}InsertionInteger" />
 *       &lt;attribute name="len" use="required" type="{http://bioxsd.org/BioXSD-1.1}PositiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gap")
public class Gap {

    @XmlAttribute(name = "pos", required = true)
    protected long pos;
    @XmlAttribute(name = "len", required = true)
    protected long len;

    /**
     * Gets the value of the pos property.
     * 
     */
    public long getPos() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     */
    public void setPos(long value) {
        this.pos = value;
    }

    /**
     * Gets the value of the len property.
     * 
     */
    public long getLen() {
        return len;
    }

    /**
     * Sets the value of the len property.
     * 
     */
    public void setLen(long value) {
        this.len = value;
    }

}
