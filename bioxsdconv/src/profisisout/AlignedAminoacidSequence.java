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
 * <p>Java class for AlignedAminoacidSequence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlignedAminoacidSequence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://bioxsd.org/BioXSD-1.1}AlignedGeneralAminoacidSequence">
 *       &lt;sequence>
 *         &lt;element name="localAlignmentPosition" type="{http://bioxsd.org/BioXSD-1.1}SequencePosition" minOccurs="0"/>
 *         &lt;element name="sequenceRecord" type="{http://bioxsd.org/BioXSD-1.1}AminoacidSequenceRecord"/>
 *         &lt;element name="gap" type="{http://bioxsd.org/BioXSD-1.1}Gap" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="insert" type="{http://bioxsd.org/BioXSD-1.1}Insert" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="frameshift" type="{http://bioxsd.org/BioXSD-1.1}Frameshift" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reversedDirection" type="{http://bioxsd.org/BioXSD-1.1}Flag" minOccurs="0"/>
 *         &lt;element name="sequenceScore" type="{http://bioxsd.org/BioXSD-1.1}Result" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlignedAminoacidSequence")
public class AlignedAminoacidSequence
    extends AlignedGeneralAminoacidSequence
{


}
