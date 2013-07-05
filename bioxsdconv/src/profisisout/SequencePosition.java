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
 * Certain position in the sequence, referring either to a subsequence, a single point, an insertion, or outside of the sequence
 * 
 * <p>Java class for SequencePosition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SequencePosition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://bioxsd.org/BioXSD-1.1}GeneralSequencePosition">
 *       &lt;choice>
 *         &lt;element name="point" type="{http://bioxsd.org/BioXSD-1.1}SequencePoint" maxOccurs="unbounded"/>
 *         &lt;element name="insertion" type="{http://bioxsd.org/BioXSD-1.1}SequenceInsertionPoint"/>
 *         &lt;element name="segment" type="{http://bioxsd.org/BioXSD-1.1}SequenceSegment" maxOccurs="unbounded"/>
 *         &lt;element name="nextPoint" type="{http://bioxsd.org/BioXSD-1.1}Flag"/>
 *         &lt;element name="nextPartition" type="{http://bioxsd.org/BioXSD-1.1}SequencePartition"/>
 *         &lt;element name="samePoint" type="{http://bioxsd.org/BioXSD-1.1}Flag"/>
 *         &lt;element name="samePartition" type="{http://bioxsd.org/BioXSD-1.1}Flag"/>
 *         &lt;element name="outside" type="{http://bioxsd.org/BioXSD-1.1}OutsideSequencePosition"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequencePosition")
public class SequencePosition
    extends GeneralSequencePosition
{


}
