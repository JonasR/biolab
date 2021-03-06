//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.26 at 10:17:24 PM CEST 
//


package profisisout;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Position outside of the reference sequence, referring to a continuous segment, possibly uncertain
 * 
 * <p>Java class for GeneralOutsideSequenceSegment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneralOutsideSequenceSegment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="min" type="{http://bioxsd.org/BioXSD-1.1}NonzeroInteger" />
 *       &lt;attribute name="max" type="{http://bioxsd.org/BioXSD-1.1}NonzeroInteger" />
 *       &lt;attribute name="strand" type="{http://bioxsd.org/BioXSD-1.1}Strand" />
 *       &lt;attribute name="minCertainty" type="{http://bioxsd.org/BioXSD-1.1}Certainty" default="Certain" />
 *       &lt;attribute name="maxCertainty" type="{http://bioxsd.org/BioXSD-1.1}Certainty" default="Certain" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralOutsideSequenceSegment")
@XmlSeeAlso({
    OutsideSequenceSegment.class
})
public class GeneralOutsideSequenceSegment {

    @XmlAttribute(name = "min")
    protected Long min;
    @XmlAttribute(name = "max")
    protected Long max;
    @XmlAttribute(name = "strand")
    protected String strand;
    @XmlAttribute(name = "minCertainty")
    protected String minCertainty;
    @XmlAttribute(name = "maxCertainty")
    protected String maxCertainty;

    /**
     * Gets the value of the min property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMin() {
        return min;
    }

    /**
     * Sets the value of the min property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMin(Long value) {
        this.min = value;
    }

    /**
     * Gets the value of the max property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMax(Long value) {
        this.max = value;
    }

    /**
     * Gets the value of the strand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrand() {
        return strand;
    }

    /**
     * Sets the value of the strand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrand(String value) {
        this.strand = value;
    }

    /**
     * Gets the value of the minCertainty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinCertainty() {
        if (minCertainty == null) {
            return "Certain";
        } else {
            return minCertainty;
        }
    }

    /**
     * Sets the value of the minCertainty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinCertainty(String value) {
        this.minCertainty = value;
    }

    /**
     * Gets the value of the maxCertainty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxCertainty() {
        if (maxCertainty == null) {
            return "Certain";
        } else {
            return maxCertainty;
        }
    }

    /**
     * Sets the value of the maxCertainty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxCertainty(String value) {
        this.maxCertainty = value;
    }

}
