
package com.cdyne.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Words complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Words">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Suggestions" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="word" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SuggestionCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Words", propOrder = {
    "suggestions",
    "word",
    "suggestionCount"
})
public class Words {

    @XmlElement(name = "Suggestions")
    protected List<String> suggestions;
    protected String word;
    @XmlElement(name = "SuggestionCount")
    protected int suggestionCount;

    /**
     * Gets the value of the suggestions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the suggestions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuggestions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSuggestions() {
        if (suggestions == null) {
            suggestions = new ArrayList<String>();
        }
        return this.suggestions;
    }

    /**
     * Obtiene el valor de la propiedad word.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWord() {
        return word;
    }

    /**
     * Define el valor de la propiedad word.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWord(String value) {
        this.word = value;
    }

    /**
     * Obtiene el valor de la propiedad suggestionCount.
     * 
     */
    public int getSuggestionCount() {
        return suggestionCount;
    }

    /**
     * Define el valor de la propiedad suggestionCount.
     * 
     */
    public void setSuggestionCount(int value) {
        this.suggestionCount = value;
    }

}
