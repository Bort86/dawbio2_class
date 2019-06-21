
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NumParaules_QNAME = new QName("http://webservice/", "numParaules");
    private final static QName _NumParaulesResponse_QNAME = new QName("http://webservice/", "numParaulesResponse");
    private final static QName _NumLletres_QNAME = new QName("http://webservice/", "numLletres");
    private final static QName _NumLletresResponse_QNAME = new QName("http://webservice/", "numLletresResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NumParaulesResponse }
     * 
     */
    public NumParaulesResponse createNumParaulesResponse() {
        return new NumParaulesResponse();
    }

    /**
     * Create an instance of {@link NumParaules }
     * 
     */
    public NumParaules createNumParaules() {
        return new NumParaules();
    }

    /**
     * Create an instance of {@link NumLletres }
     * 
     */
    public NumLletres createNumLletres() {
        return new NumLletres();
    }

    /**
     * Create an instance of {@link NumLletresResponse }
     * 
     */
    public NumLletresResponse createNumLletresResponse() {
        return new NumLletresResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumParaules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "numParaules")
    public JAXBElement<NumParaules> createNumParaules(NumParaules value) {
        return new JAXBElement<NumParaules>(_NumParaules_QNAME, NumParaules.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumParaulesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "numParaulesResponse")
    public JAXBElement<NumParaulesResponse> createNumParaulesResponse(NumParaulesResponse value) {
        return new JAXBElement<NumParaulesResponse>(_NumParaulesResponse_QNAME, NumParaulesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumLletres }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "numLletres")
    public JAXBElement<NumLletres> createNumLletres(NumLletres value) {
        return new JAXBElement<NumLletres>(_NumLletres_QNAME, NumLletres.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumLletresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "numLletresResponse")
    public JAXBElement<NumLletresResponse> createNumLletresResponse(NumLletresResponse value) {
        return new JAXBElement<NumLletresResponse>(_NumLletresResponse_QNAME, NumLletresResponse.class, null, value);
    }

}
