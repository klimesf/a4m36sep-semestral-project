package cz.cvut.fel.sep.klimefi1.semestral.service;

import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ChangeRequestRepository;
import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CreateCustomerChangeOrder;
import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerDatabase;
import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerDatabaseWSDL;
import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerDetailType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.math.BigInteger;
import java.net.URL;
import java.util.logging.Logger;

@Service
public class ChangeRequestUploader {

    private final ChangeRequestRepository repository;

    private Logger logger = Logger.getGlobal();

    private static final QName SERVICE_NAME = new QName("http://www.cvut.cz/FEL/", "CustomerDatabase");

    private CustomerDatabaseWSDL createPort() {
        URL wsdlURL = CustomerDatabase.WSDL_LOCATION;
        CustomerDatabase ss = new CustomerDatabase(wsdlURL, SERVICE_NAME);
        return ss.getCustomerDatabaseSOAP();
    }

    @Autowired
    public ChangeRequestUploader(ChangeRequestRepository repository) {
        this.repository = repository;
    }

    public void upload() {
        for (ChangeRequest request : repository.findByPushedToApi(false)) {
            CreateCustomerChangeOrder parameters = new CreateCustomerChangeOrder();
            parameters.setId(new BigInteger(String.valueOf(request.getId())));
            parameters.setCustomer(new CustomerDetailType());
            createPort().createCustomerChangeOrder(parameters);

            logger.info("Pushed ChangeRequest with id: " + request.getId() + " to external API.");
        }
    }
}
