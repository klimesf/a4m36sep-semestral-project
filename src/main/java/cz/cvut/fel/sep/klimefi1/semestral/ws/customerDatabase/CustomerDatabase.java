package cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.8
 * 2016-12-03T15:27:29.348+01:00
 * Generated source version: 3.1.8
 * 
 */
@WebServiceClient(name = "CustomerDatabase", 
                  wsdlLocation = "http://localhost:8088/mockCustomerDatabaseSOAP?wsdl",
                  targetNamespace = "http://www.cvut.cz/FEL/") 
public class CustomerDatabase extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.cvut.cz/FEL/", "CustomerDatabase");
    public final static QName CustomerDatabaseSOAP = new QName("http://www.cvut.cz/FEL/", "CustomerDatabaseSOAP");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8088/mockCustomerDatabaseSOAP?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerDatabase.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8088/mockCustomerDatabaseSOAP?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerDatabase(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerDatabase(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerDatabase() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CustomerDatabase(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CustomerDatabase(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CustomerDatabase(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CustomerDatabaseWSDL
     */
    @WebEndpoint(name = "CustomerDatabaseSOAP")
    public CustomerDatabaseWSDL getCustomerDatabaseSOAP() {
        return super.getPort(CustomerDatabaseSOAP, CustomerDatabaseWSDL.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerDatabaseWSDL
     */
    @WebEndpoint(name = "CustomerDatabaseSOAP")
    public CustomerDatabaseWSDL getCustomerDatabaseSOAP(WebServiceFeature... features) {
        return super.getPort(CustomerDatabaseSOAP, CustomerDatabaseWSDL.class, features);
    }

}