package cz.cvut.fel.sep.klimefi1.semestral.repository;

import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerDetailType;
import cz.cvut.fel.sep.klimefi1.semestral.ws.customerDatabase.CustomerType;

import java.util.List;

public interface ClientRepository {

    /**
     * Lists all Customers.
     *
     * @return The list of customers.
     */
    List<CustomerType> findAll();

    /**
     * Finds Customer with given ID.
     *
     * @param id The ID.
     * @return The Customer.
     */
    CustomerDetailType find(Integer id);
}
