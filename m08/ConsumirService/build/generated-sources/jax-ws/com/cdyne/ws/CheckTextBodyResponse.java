
package com.cdyne.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentSummary" type="{http://ws.cdyne.com/}DocumentSummary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "documentSummary"
})
@XmlRootElement(name = "CheckTextBodyResponse")
public class CheckTextBodyResponse {

    @XmlElement(name = "DocumentSummary", required = true, nillable = true)
    protected DocumentSummary documentSummary;

    /**
     * Obtiene el valor de la propiedad documentSummary.
     * 
     * @return
     *     possible object is
     *     {@link DocumentSummary }
     *     
     */
    public DocumentSummary getDocumentSummary() {
        return documentSummary;
    }

    /**
     * Define el valor de la propiedad documentSummary.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentSummary }
     *     
     */
    public void setDocumentSummary(DocumentSummary value) {
        this.documentSummary = value;
    }

}
