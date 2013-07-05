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
 * Amino-acid sequence record including the generic amino-acid sequence and optional metadata
 * 
 * <p>Java class for GeneralAminoacidSequenceRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneralAminoacidSequenceRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://bioxsd.org/BioXSD-1.1}BiosequenceRecord">
 *       &lt;sequence>
 *         &lt;element name="sequence" type="{http://bioxsd.org/BioXSD-1.1}GeneralAminoacidSequence"/>
 *         &lt;element name="species" type="{http://bioxsd.org/BioXSD-1.1}Species" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://bioxsd.org/BioXSD-1.1}SequenceReference" minOccurs="0"/>
 *         &lt;element name="name" type="{http://bioxsd.org/BioXSD-1.1}Name" minOccurs="0"/>
 *         &lt;element name="note" type="{http://bioxsd.org/BioXSD-1.1}Text" minOccurs="0"/>
 *         &lt;element name="translationData" type="{http://bioxsd.org/BioXSD-1.1}AminoacidTranslationData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralAminoacidSequenceRecord")
@XmlSeeAlso({
    AminoacidSequenceRecord.class
})
public class GeneralAminoacidSequenceRecord
    extends BiosequenceRecord
{


}