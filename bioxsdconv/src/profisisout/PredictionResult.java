//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.26 at 10:17:24 PM CEST 
//


package profisisout;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PredictionResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PredictionResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="method" type="{http://bioxsd.org/BioXSD-1.1}Method"/>
 *           &lt;element name="methodIdRef" type="{http://bioxsd.org/BioXSD-1.1}LocalId"/>
 *         &lt;/choice>
 *         &lt;element name="score" type="{http://bioxsd.org/BioXSD-1.1}Score" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="verdict" type="{http://bioxsd.org/BioXSD-1.1}Verdict" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PredictionResult", propOrder = {
    "method",
    "methodIdRef",
    "score",
    "verdict"
})
public class PredictionResult {

    protected Method method;
    protected String methodIdRef;
    protected List<Score> score;
    protected String verdict;

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link Method }
     *     
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link Method }
     *     
     */
    public void setMethod(Method value) {
        this.method = value;
    }

    /**
     * Gets the value of the methodIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethodIdRef() {
        return methodIdRef;
    }

    /**
     * Sets the value of the methodIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethodIdRef(String value) {
        this.methodIdRef = value;
    }

    /**
     * Gets the value of the score property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the score property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Score }
     * 
     * 
     */
    public List<Score> getScore() {
        if (score == null) {
            score = new ArrayList<Score>();
        }
        return this.score;
    }

    /**
     * Gets the value of the verdict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerdict() {
        return verdict;
    }

    /**
     * Sets the value of the verdict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerdict(String value) {
        this.verdict = value;
    }

}