
package cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase package. 
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

    private final static QName _CreateCustomerChangeOrderResponse1_QNAME = new QName("http://www.cvut.cz/FEL/", "CreateCustomerChangeOrderResponse1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReadAllCustomers }
     * 
     */
    public ReadAllCustomers createReadAllCustomers() {
        return new ReadAllCustomers();
    }

    /**
     * Create an instance of {@link ReadAllCustomersResponse1 }
     * 
     */
    public ReadAllCustomersResponse1 createReadAllCustomersResponse1() {
        return new ReadAllCustomersResponse1();
    }

    /**
     * Create an instance of {@link CustomerType }
     * 
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link ReadCustomerDetails }
     * 
     */
    public ReadCustomerDetails createReadCustomerDetails() {
        return new ReadCustomerDetails();
    }

    /**
     * Create an instance of {@link ReadCustomerDetailsResponse1 }
     * 
     */
    public ReadCustomerDetailsResponse1 createReadCustomerDetailsResponse1() {
        return new ReadCustomerDetailsResponse1();
    }

    /**
     * Create an instance of {@link CustomerDetailType }
     * 
     */
    public CustomerDetailType createCustomerDetailType() {
        return new CustomerDetailType();
    }

    /**
     * Create an instance of {@link CreateCustomerChangeOrder }
     * 
     */
    public CreateCustomerChangeOrder createCreateCustomerChangeOrder() {
        return new CreateCustomerChangeOrder();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link PhoneType }
     * 
     */
    public PhoneType createPhoneType() {
        return new PhoneType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cvut.cz/FEL/", name = "CreateCustomerChangeOrderResponse1")
    public JAXBElement<Object> createCreateCustomerChangeOrderResponse1(Object value) {
        return new JAXBElement<Object>(_CreateCustomerChangeOrderResponse1_QNAME, Object.class, null, value);
    }

}
