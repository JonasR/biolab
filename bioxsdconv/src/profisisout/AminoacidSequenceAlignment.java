//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.26 at 10:17:24 PM CEST 
//


package profisisout;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Alignment of 2..n amino-acid sequences. A *multiple sequence alignment* in the sense that all sequences are treated equally
 * 
 * <p>Java class for AminoacidSequenceAlignment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AminoacidSequenceAlignment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://bioxsd.org/BioXSD-1.1}GeneralAminoacidSequenceAlignment">
 *       &lt;sequence>
 *         &lt;element name="alignedBy" type="{http://bioxsd.org/BioXSD-1.1}MethodResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="alignedSequence" type="{http://bioxsd.org/BioXSD-1.1}AlignedAminoacidSequence" maxOccurs="unbounded" minOccurs="2"/>
 *         &lt;element name="note" type="{http://bioxsd.org/BioXSD-1.1}Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AminoacidSequenceAlignment")
public class AminoacidSequenceAlignment
    extends GeneralAminoacidSequenceAlignment
{


}