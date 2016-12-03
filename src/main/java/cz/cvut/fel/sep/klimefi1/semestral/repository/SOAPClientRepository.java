package cz.cvut.fel.sep.klimefi1.semestral.repository;

import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerDatabase;
import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerDatabaseWSDL;
import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerDetailType;
import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerType;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;

@Service
public class SOAPClientRepository implements ClientRepository {

    private static final QName SERVICE_NAME = new QName("http://www.cvut.cz/FEL/", "CustomerDatabase");

    private CustomerDatabaseWSDL createPort() {
        URL wsdlURL = CustomerDatabase.WSDL_LOCATION;
        CustomerDatabase ss = new CustomerDatabase(wsdlURL, SERVICE_NAME);
        return ss.getCustomerDatabaseSOAP();
    }

    @Override
    public List<CustomerType> findAll() {
        return createPort().readAllCustomers(BigInteger.ZERO, BigInteger.TEN);
    }

    @Override
    public CustomerDetailType find(Integer id) {
        BigInteger _readCustomerDetails_idVal = new BigInteger("0");
        Holder<BigInteger> _readCustomerDetails_id = new Holder<BigInteger>(_readCustomerDetails_idVal);
        Holder<String> _readCustomerDetails_status = new Holder<String>();
        Holder<CustomerDetailType> _readCustomerDetails_customer = new Holder<CustomerDetailType>();
        createPort().readCustomerDetails(_readCustomerDetails_id, _readCustomerDetails_status, _readCustomerDetails_customer);

        return _readCustomerDetails_customer.value;
    }
}
