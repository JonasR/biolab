//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.15 at 10:06:18 PM CEST 
//


package ncbisegout;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Position in the sequence, referring either to a subsequence, a single point, an insertion, or outside of the sequence, possibly uncertain
 * 
 * <p>Java class for GeneralSequencePosition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneralSequencePosition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="point" type="{http://bioxsd.org/BioXSD-1.1}GeneralSequencePoint" maxOccurs="unbounded"/>
 *         &lt;element name="insertion" type="{http://bioxsd.org/BioXSD-1.1}GeneralSequenceInsertionPoint"/>
 *         &lt;element name="segment" type="{http://bioxsd.org/BioXSD-1.1}GeneralSequenceSegment" maxOccurs="unbounded"/>
 *         &lt;element name="nextPoint" type="{http://bioxsd.org/BioXSD-1.1}Flag"/>
 *         &lt;element name="nextPartition" type="{http://bioxsd.org/BioXSD-1.1}GeneralSequencePartition"/>
 *         &lt;element name="samePoint" type="{http://bioxsd.org/BioXSD-1.1}Flag"/>
 *         &lt;element name="samePartition" type="{http://bioxsd.org/BioXSD-1.1}Flag"/>
 *         &lt;element name="outside" type="{http://bioxsd.org/BioXSD-1.1}GeneralOutsideSequencePosition"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralSequencePosition", propOrder = {
    "point",
    "insertion",
    "segment",
    "nextPoint",
    "nextPartition",
    "samePoint",
    "samePartition",
    "outside"
})
@XmlSeeAlso({
    SequencePosition.class
})
public class GeneralSequencePosition {

    protected List<GeneralSequencePoint> point;
    protected GeneralSequenceInsertionPoint insertion;
    protected List<GeneralSequenceSegment> segment;
    protected Flag nextPoint;
    protected GeneralSequencePartition nextPartition;
    protected Flag samePoint;
    protected Flag samePartition;
    protected GeneralOutsideSequencePosition outside;

    /**
     * Gets the value of the point property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the point property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneralSequencePoint }
     * 
     * 
     */
    public List<GeneralSequencePoint> getPoint() {
        if (point == null) {
            point = new ArrayList<GeneralSequencePoint>();
        }
        return this.point;
    }

    /**
     * Gets the value of the insertion property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralSequenceInsertionPoint }
     *     
     */
    public GeneralSequenceInsertionPoint getInsertion() {
        return insertion;
    }

    /**
     * Sets the value of the insertion property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralSequenceInsertionPoint }
     *     
     */
    public void setInsertion(GeneralSequenceInsertionPoint value) {
        this.insertion = value;
    }

    /**
     * Gets the value of the segment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneralSequenceSegment }
     * 
     * 
     */
    public List<GeneralSequenceSegment> getSegment() {
        if (segment == null) {
            segment = new ArrayList<GeneralSequenceSegment>();
        }
        return this.segment;
    }

    /**
     * Gets the value of the nextPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Flag }
     *     
     */
    public Flag getNextPoint() {
        return nextPoint;
    }

    /**
     * Sets the value of the nextPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flag }
     *     
     */
    public void setNextPoint(Flag value) {
        this.nextPoint = value;
    }

    /**
     * Gets the value of the nextPartition property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralSequencePartition }
     *     
     */
    public GeneralSequencePartition getNextPartition() {
        return nextPartition;
    }

    /**
     * Sets the value of the nextPartition property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralSequencePartition }
     *     
     */
    public void setNextPartition(GeneralSequencePartition value) {
        this.nextPartition = value;
    }

    /**
     * Gets the value of the samePoint property.
     * 
     * @return
     *     possible object is
     *     {@link Flag }
     *     
     */
    public Flag getSamePoint() {
        return samePoint;
    }

    /**
     * Sets the value of the samePoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flag }
     *     
     */
    public void setSamePoint(Flag value) {
        this.samePoint = value;
    }

    /**
     * Gets the value of the samePartition property.
     * 
     * @return
     *     possible object is
     *     {@link Flag }
     *     
     */
    public Flag getSamePartition() {
        return samePartition;
    }

    /**
     * Sets the value of the samePartition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flag }
     *     
     */
    public void setSamePartition(Flag value) {
        this.samePartition = value;
    }

    /**
     * Gets the value of the outside property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralOutsideSequencePosition }
     *     
     */
    public GeneralOutsideSequencePosition getOutside() {
        return outside;
    }

    /**
     * Sets the value of the outside property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralOutsideSequencePosition }
     *     
     */
    public void setOutside(GeneralOutsideSequencePosition value) {
        this.outside = value;
    }

}
