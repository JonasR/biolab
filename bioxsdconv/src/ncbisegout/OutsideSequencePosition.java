//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.15 at 10:06:18 PM CEST 
//


package ncbisegout;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Certain position outside of the sequence
 * 
 * <p>Java class for OutsideSequencePosition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutsideSequencePosition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://bioxsd.org/BioXSD-1.1}GeneralOutsideSequencePosition">
 *       &lt;sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="correspondance" type="{http://bioxsd.org/BioXSD-1.1}OutsidePositionCorrespondance"/>
 *           &lt;choice>
 *             &lt;element name="point" type="{http://bioxsd.org/BioXSD-1.1}OutsideSequencePoint" maxOccurs="unbounded"/>
 *             &lt;element name="insertion" type="{http://bioxsd.org/BioXSD-1.1}OutsideSequencePoint"/>
 *             &lt;element name="segment" type="{http://bioxsd.org/BioXSD-1.1}OutsideSequenceSegment" maxOccurs="unbounded"/>
 *           &lt;/choice>
 *         &lt;/sequence>
 *         &lt;element name="explicitSequenceReference" type="{http://bioxsd.org/BioXSD-1.1}SequenceReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutsideSequencePosition")
public class OutsideSequencePosition
    extends GeneralOutsideSequencePosition
{


}
