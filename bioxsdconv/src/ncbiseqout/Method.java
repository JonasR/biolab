//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 11:32:28 PM CEST 
//


package ncbiseqout;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Method complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Method">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categoryConcept" type="{http://bioxsd.org/BioXSD-1.1}SemanticConcept" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="citation" type="{http://bioxsd.org/BioXSD-1.1}EntryReference" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://bioxsd.org/BioXSD-1.1}WebserviceReference"/>
 *       &lt;attribute name="name" use="required" type="{http://bioxsd.org/BioXSD-1.1}Name" />
 *       &lt;attribute name="uri" type="{http://bioxsd.org/BioXSD-1.1}Uri" />
 *       &lt;attribute name="version" type="{http://bioxsd.org/BioXSD-1.1}Name" />
 *       &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Method", propOrder = {
    "categoryConcept",
    "citation"
})
@XmlSeeAlso({
    ncbiseqout.FeatureRecord.BlockWithOccurrenceReferences.Method.class,
    ncbiseqout.MethodResult.Method.class
})
public class Method {

    protected List<SemanticConcept> categoryConcept;
    protected List<EntryReference> citation;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "uri")
    protected String uri;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlAttribute(name = "wsdl")
    protected String wsdl;
    @XmlAttribute(name = "wsdlService")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String wsdlService;
    @XmlAttribute(name = "wsdlPort")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String wsdlPort;
    @XmlAttribute(name = "webserviceOperation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String webserviceOperation;
    @XmlAttribute(name = "webserviceVersion")
    protected String webserviceVersion;
    @XmlAttribute(name = "webserviceDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar webserviceDate;

    /**
     * Gets the value of the categoryConcept property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoryConcept property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoryConcept().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SemanticConcept }
     * 
     * 
     */
    public List<SemanticConcept> getCategoryConcept() {
        if (categoryConcept == null) {
            categoryConcept = new ArrayList<SemanticConcept>();
        }
        return this.categoryConcept;
    }

    /**
     * Gets the value of the citation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the citation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCitation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryReference }
     * 
     * 
     */
    public List<EntryReference> getCitation() {
        if (citation == null) {
            citation = new ArrayList<EntryReference>();
        }
        return this.citation;
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
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the wsdl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsdl() {
        return wsdl;
    }

    /**
     * Sets the value of the wsdl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsdl(String value) {
        this.wsdl = value;
    }

    /**
     * Gets the value of the wsdlService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsdlService() {
        return wsdlService;
    }

    /**
     * Sets the value of the wsdlService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsdlService(String value) {
        this.wsdlService = value;
    }

    /**
     * Gets the value of the wsdlPort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsdlPort() {
        return wsdlPort;
    }

    /**
     * Sets the value of the wsdlPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsdlPort(String value) {
        this.wsdlPort = value;
    }

    /**
     * Gets the value of the webserviceOperation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebserviceOperation() {
        return webserviceOperation;
    }

    /**
     * Sets the value of the webserviceOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebserviceOperation(String value) {
        this.webserviceOperation = value;
    }

    /**
     * Gets the value of the webserviceVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebserviceVersion() {
        return webserviceVersion;
    }

    /**
     * Sets the value of the webserviceVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebserviceVersion(String value) {
        this.webserviceVersion = value;
    }

    /**
     * Gets the value of the webserviceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWebserviceDate() {
        return webserviceDate;
    }

    /**
     * Sets the value of the webserviceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWebserviceDate(XMLGregorianCalendar value) {
        this.webserviceDate = value;
    }

}
