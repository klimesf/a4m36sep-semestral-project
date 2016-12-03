package cz.cvut.fel.sep.klimefi1.semestral.repository;

import cz.cvut.fel.sep.klimefi1.semestral.dto.ClientDTO;
import cz.cvut.fel.sep.klimefi1.semestral.dto.ClientDetailDTO;
import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.*;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
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
    public List<ClientDTO> findAll() {
        List<CustomerType> customers = createPort().readAllCustomers(BigInteger.ZERO, BigInteger.TEN);
        List<ClientDTO> clients = new ArrayList<>();
        for (CustomerType customer : customers) {
            ClientDTO client = new ClientDTO(
                    customer.getId().intValue(),
                    customer.getFirstName(),
                    customer.getSurname(),
                    customer.getStatus()
            );
            clients.add(client);
        }
        return clients;
    }

    @Override
    public ClientDetailDTO find(Integer id) {
        Holder<BigInteger> idHolder = new Holder<BigInteger>(new BigInteger(String.valueOf(id)));
        Holder<String> statusHolder = new Holder<String>();
        Holder<CustomerDetailType> customerHolder = new Holder<CustomerDetailType>();
        createPort().readCustomerDetails(idHolder, statusHolder, customerHolder);

        String firstName = String.join(" ", customerHolder.value.getFirstName());
        String surname = String.join(" ", customerHolder.value.getSurname());

        String phoneNum = null;
        for (PhoneType p : customerHolder.value.getPhoneNum()) {
            phoneNum = phoneNum == null ? p.getPhoneNum() : String.join(", ", phoneNum, p.getPhoneNum());
        }

        String address = null;
        for (AddressType a : customerHolder.value.getAddress()) {
            StringBuilder sb = new StringBuilder()
                    .append(a.getStreetName()).append(" ").append(a.getStreetNum()).append(", ")
                    .append(a.getCity()).append(", ").append(a.getCountry());
            address = address == null ? sb.toString() : String.join(", ", address, sb.toString());
        }

        return new ClientDetailDTO(
                id,
                firstName,
                surname,
                address,
                phoneNum,
                customerHolder.value.getBirthNum(),
                customerHolder.value.getCountryOfOrigin(),
                statusHolder.value
        );
    }
}
