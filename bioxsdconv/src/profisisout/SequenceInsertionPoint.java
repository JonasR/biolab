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
 * Certain position of an insertion into the sequence.
 * NB. Insertion *behind* (to the right of) the given point in the direction of the sequence; *-1* for preceeding the sequence
 * 
 * <p>Java class for SequenceInsertionPoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SequenceInsertionPoint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://bioxsd.org/BioXSD-1.1}GeneralSequenceInsertionPoint">
 *       &lt;attribute name="pos" use="required" type="{http://bioxsd.org/BioXSD-1.1}InsertionInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceInsertionPoint")
public class SequenceInsertionPoint
    extends GeneralSequenceInsertionPoint
{


}
