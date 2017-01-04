package cz.cvut.fel.sep.klimefi1.semestral.repository;

import cz.cvut.fel.sep.klimefi1.semestral.dto.ClientDTO;
import cz.cvut.fel.sep.klimefi1.semestral.dto.ClientDetailDTO;

import java.math.BigInteger;
import java.util.List;

public interface ClientRepository {

    /**
     * Lists all Customers.
     *
     * @return The list of customers.
     */
    List<ClientDTO> findAll();

    /**
     * Lists all Customers.
     *
     * @return The list of customers.
     */
    List<ClientDTO> findAll(BigInteger limit, BigInteger offset);

    /**
     * Finds Customer with given ID.
     *
     * @param id The ID.
     * @return The Customer.
     */
    ClientDetailDTO find(Integer id);
}
