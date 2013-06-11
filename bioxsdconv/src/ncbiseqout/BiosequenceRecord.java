//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 11:32:28 PM CEST 
//


package ncbiseqout;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Nucleotide or amino-acid sequence record including the generic sequence and optional metadata
 * 
 * <p>Java class for BiosequenceRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BiosequenceRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sequence" type="{http://bioxsd.org/BioXSD-1.1}Biosequence"/>
 *         &lt;element name="species" type="{http://bioxsd.org/BioXSD-1.1}Species" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://bioxsd.org/BioXSD-1.1}SequenceReference" minOccurs="0"/>
 *         &lt;element name="name" type="{http://bioxsd.org/BioXSD-1.1}Name" minOccurs="0"/>
 *         &lt;element name="note" type="{http://bioxsd.org/BioXSD-1.1}Text" minOccurs="0"/>
 *         &lt;element name="translationData" type="{http://bioxsd.org/BioXSD-1.1}TranslationData" minOccurs="0"/>
 *         &lt;element name="inlineBaseQuality" type="{http://bioxsd.org/BioXSD-1.1}BaseQualityString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BiosequenceRecord", propOrder = {
    "sequence",
    "species",
    "reference",
    "name",
    "note",
    "translationData",
    "inlineBaseQuality"
})
@XmlSeeAlso({
    GeneralAminoacidSequenceRecord.class,
    GeneralNucleotideSequenceRecord.class
})
public class BiosequenceRecord {

    @XmlElement(required = true)
    protected String sequence;
    protected Species species;
    protected SequenceReference reference;
    protected String name;
    protected String note;
    protected TranslationData translationData;
    protected String inlineBaseQuality;

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequence(String value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the species property.
     * 
     * @return
     *     possible object is
     *     {@link Species }
     *     
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Sets the value of the species property.
     * 
     * @param value
     *     allowed object is
     *     {@link Species }
     *     
     */
    public void setSpecies(Species value) {
        this.species = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceReference }
     *     
     */
    public SequenceReference getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceReference }
     *     
     */
    public void setReference(SequenceReference value) {
        this.reference = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Gets the value of the translationData property.
     * 
     * @return
     *     possible object is
     *     {@link TranslationData }
     *     
     */
    public TranslationData getTranslationData() {
        return translationData;
    }

    /**
     * Sets the value of the translationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TranslationData }
     *     
     */
    public void setTranslationData(TranslationData value) {
        this.translationData = value;
    }

    /**
     * Gets the value of the inlineBaseQuality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInlineBaseQuality() {
        return inlineBaseQuality;
    }

    /**
     * Sets the value of the inlineBaseQuality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInlineBaseQuality(String value) {
        this.inlineBaseQuality = value;
    }

}
