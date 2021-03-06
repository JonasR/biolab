//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.15 at 10:06:18 PM CEST 
//


package ncbisegout;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TranslationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TranslationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="geneticCode" type="{http://bioxsd.org/BioXSD-1.1}GeneticCode" minOccurs="0"/>
 *         &lt;element name="phase" type="{http://bioxsd.org/BioXSD-1.1}Phase" minOccurs="0"/>
 *         &lt;element name="reversedTranslationDirection" type="{http://bioxsd.org/BioXSD-1.1}Flag" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TranslationData", propOrder = {
    "geneticCode",
    "phase",
    "reversedTranslationDirection"
})
@XmlSeeAlso({
    AminoacidTranslationData.class
})
public class TranslationData {

    protected GeneticCode geneticCode;
    protected Integer phase;
    protected Flag reversedTranslationDirection;

    /**
     * Gets the value of the geneticCode property.
     * 
     * @return
     *     possible object is
     *     {@link GeneticCode }
     *     
     */
    public GeneticCode getGeneticCode() {
        return geneticCode;
    }

    /**
     * Sets the value of the geneticCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneticCode }
     *     
     */
    public void setGeneticCode(GeneticCode value) {
        this.geneticCode = value;
    }

    /**
     * Gets the value of the phase property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPhase() {
        return phase;
    }

    /**
     * Sets the value of the phase property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPhase(Integer value) {
        this.phase = value;
    }

    /**
     * Gets the value of the reversedTranslationDirection property.
     * 
     * @return
     *     possible object is
     *     {@link Flag }
     *     
     */
    public Flag getReversedTranslationDirection() {
        return reversedTranslationDirection;
    }

    /**
     * Sets the value of the reversedTranslationDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flag }
     *     
     */
    public void setReversedTranslationDirection(Flag value) {
        this.reversedTranslationDirection = value;
    }

}
