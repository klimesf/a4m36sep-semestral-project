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

    private static final Integer ENTITIES_PER_PAGE = 50;

    private static final QName SERVICE_NAME = new QName("http://www.cvut.cz/FEL/", "CustomerDatabase");

    private CustomerDatabaseWSDL createPort() {
        URL wsdlURL = CustomerDatabase.WSDL_LOCATION;
        CustomerDatabase ss = new CustomerDatabase(wsdlURL, SERVICE_NAME);
        return ss.getCustomerDatabaseSOAP();
    }

    @Override
    public List<ClientDTO> findAll() {
        List<CustomerType> customers = createPort().readAllCustomers(BigInteger.ZERO, BigInteger.valueOf(50L));

        return transformToDTO(customers);
    }

    @Override
    public List<ClientDTO> findAll(BigInteger limit, BigInteger offset) {
        List<CustomerType> customers = createPort().readAllCustomers(offset, limit);
        return transformToDTO(customers);
    }

    @Override
    public ClientDetailDTO find(Integer id) {
        Holder<BigInteger> idHolder = new Holder<BigInteger>(new BigInteger(String.valueOf(id)));
        Holder<String> statusHolder = new Holder<String>();
        Holder<CustomerDetailType> customerHolder = new Holder<CustomerDetailType>();
        createPort().readCustomerDetails(idHolder, statusHolder, customerHolder);

        List<String> phoneNum = new ArrayList<>();
        for (PhoneType p : customerHolder.value.getPhoneNum()) {
            phoneNum.add(p.getPhoneNum());
        }

        List<String> addresses = new ArrayList<>();
        for (AddressType a : customerHolder.value.getAddress()) {
            StringBuilder sb = new StringBuilder()
                    .append(a.getStreetName()).append(" ").append(a.getStreetNum()).append(", ")
                    .append(a.getCity()).append(", ").append(a.getPostalCode()).append(", ").append(a.getCountry());
            addresses.add(sb.toString());
        }

        return new ClientDetailDTO(
                id,
                customerHolder.value.getFirstName(),
                customerHolder.value.getSurname(),
                addresses,
                phoneNum,
                customerHolder.value.getBirthNum(),
                customerHolder.value.getCountryOfOrigin(),
                statusHolder.value
        );
    }

    private List<ClientDTO> transformToDTO(List<CustomerType> customers) {
        List<ClientDTO> clients = new ArrayList<>();

        Integer counter = 1;
        for (CustomerType customer : customers) {
            if (counter++ > ENTITIES_PER_PAGE) {
                break;
            }
            BigInteger id = customer.getId();
            ClientDTO client = new ClientDTO(
                    id != null ? id.intValue() : null,
                    customer.getFirstName(),
                    customer.getSurname(),
                    customer.getStatus()
            );
            clients.add(client);
        }
        return clients;
    }
}
