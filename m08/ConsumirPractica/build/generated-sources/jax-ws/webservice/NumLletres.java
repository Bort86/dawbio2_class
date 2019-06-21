
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para numLletres complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="numLletres">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numLletres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "numLletres", propOrder = {
    "numLletres"
})
public class NumLletres {

    protected String numLletres;

    /**
     * Obtiene el valor de la propiedad numLletres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumLletres() {
        return numLletres;
    }

    /**
     * Define el valor de la propiedad numLletres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumLletres(String value) {
        this.numLletres = value;
    }

}
