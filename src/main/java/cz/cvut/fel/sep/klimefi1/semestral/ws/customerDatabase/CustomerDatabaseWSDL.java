package cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.8
 * 2016-12-03T15:27:29.341+01:00
 * Generated source version: 3.1.8
 * 
 */
@WebService(targetNamespace = "http://www.cvut.cz/FEL/", name = "CustomerDatabaseWSDL")
@XmlSeeAlso({ObjectFactory.class})
public interface CustomerDatabaseWSDL {

    @WebMethod(operationName = "ReadCustomerDetails", action = "http://www.cvut.cz/FEL/ReadCustomerDetails")
    @RequestWrapper(localName = "ReadCustomerDetails", targetNamespace = "http://www.cvut.cz/FEL/", className = "cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.ReadCustomerDetails")
    @ResponseWrapper(localName = "ReadCustomerDetailsResponse1", targetNamespace = "http://www.cvut.cz/FEL/", className = "cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.ReadCustomerDetailsResponse1")
    public void readCustomerDetails(
        @WebParam(mode = WebParam.Mode.INOUT, name = "id", targetNamespace = "")
        javax.xml.ws.Holder<java.math.BigInteger> id,
        @WebParam(mode = WebParam.Mode.OUT, name = "status", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.String> status,
        @WebParam(mode = WebParam.Mode.OUT, name = "customer", targetNamespace = "")
        javax.xml.ws.Holder<CustomerDetailType> customer
    );

    @WebMethod(operationName = "ReadAllCustomers", action = "http://www.cvut.cz/FEL/ReadAllCustomers")
    @RequestWrapper(localName = "ReadAllCustomers", targetNamespace = "http://www.cvut.cz/FEL/", className = "cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.ReadAllCustomers")
    @ResponseWrapper(localName = "ReadAllCustomersResponse1", targetNamespace = "http://www.cvut.cz/FEL/", className = "cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.ReadAllCustomersResponse1")
    @WebResult(name = "customer", targetNamespace = "")
    public java.util.List<cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerType> readAllCustomers(
        @WebParam(name = "from", targetNamespace = "")
        java.math.BigInteger from,
        @WebParam(name = "count", targetNamespace = "")
        java.math.BigInteger count
    );

    @WebMethod(operationName = "CreateCustomerChangeOrder", action = "http://www.cvut.cz/FEL/CreateCustomerChangeOrder")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "CreateCustomerChangeOrderResponse1", targetNamespace = "http://www.cvut.cz/FEL/", partName = "parameters")
    public java.lang.Object createCustomerChangeOrder(
        @WebParam(partName = "parameters", name = "CreateCustomerChangeOrder", targetNamespace = "http://www.cvut.cz/FEL/")
        CreateCustomerChangeOrder parameters
    );
}
