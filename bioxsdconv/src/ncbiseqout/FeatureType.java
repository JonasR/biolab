//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 11:32:28 PM CEST 
//


package ncbiseqout;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * Annotation by a particular feature. That is, a single-feature sequence annotation track for one particular reference sequence
 * 
 * <p>Java class for FeatureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeatureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="name" type="{http://bioxsd.org/BioXSD-1.1}Name"/>
 *             &lt;element name="equalConcept" type="{http://bioxsd.org/BioXSD-1.1}SemanticConcept" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="equalConcept" type="{http://bioxsd.org/BioXSD-1.1}SemanticConcept" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *         &lt;element name="equalAlias" type="{http://bioxsd.org/BioXSD-1.1}Name" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="className" type="{http://bioxsd.org/BioXSD-1.1}Name" minOccurs="0"/>
 *         &lt;element name="classConcept" type="{http://bioxsd.org/BioXSD-1.1}SemanticConcept" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="properties" type="{http://bioxsd.org/BioXSD-1.1}FeatureTypeDetails" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureType", propOrder = {
    "content"
})
public class FeatureType {

    @XmlElementRefs({
        @XmlElementRef(name = "equalAlias", namespace = "http://bioxsd.org/BioXSD-1.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "properties", namespace = "http://bioxsd.org/BioXSD-1.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "className", namespace = "http://bioxsd.org/BioXSD-1.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "name", namespace = "http://bioxsd.org/BioXSD-1.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "equalConcept", namespace = "http://bioxsd.org/BioXSD-1.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "classConcept", namespace = "http://bioxsd.org/BioXSD-1.1", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "EqualConcept" is used by two different parts of a schema. See: 
     * line 525 of http://bioxsd.org/BioXSD-1.1.xsd
     * line 523 of http://bioxsd.org/BioXSD-1.1.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link FeatureTypeDetails }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link SemanticConcept }{@code >}
     * {@link JAXBElement }{@code <}{@link SemanticConcept }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
    }

}