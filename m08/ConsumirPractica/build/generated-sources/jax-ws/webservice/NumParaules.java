
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para numParaules complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="numParaules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numParaules" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "numParaules", propOrder = {
    "numParaules"
})
public class NumParaules {

    protected String numParaules;

    /**
     * Obtiene el valor de la propiedad numParaules.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumParaules() {
        return numParaules;
    }

    /**
     * Define el valor de la propiedad numParaules.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumParaules(String value) {
        this.numParaules = value;
    }

}
