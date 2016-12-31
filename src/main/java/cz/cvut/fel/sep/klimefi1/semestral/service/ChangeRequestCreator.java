package cz.cvut.fel.sep.klimefi1.semestral.service;

import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ChangeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.logging.Logger;


@Service
public class ChangeRequestCreator {

    private final ChangeRequestRepository repository;

    private Logger logger = Logger.getGlobal();

    @Autowired
    public ChangeRequestCreator(ChangeRequestRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ChangeRequest create(ChangeRequest changeRequest) {
        // TODO: Check id client with given id exists

        if (changeRequest.getClientId() == null && changeRequest.getType() != ChangeRequest.Type.ADD) {
            throw new ValidationException("ClientId is required.");
        }
        if (changeRequest.getType() == ChangeRequest.Type.ADD && changeRequest.getFirstName().equals("")) {
            throw new ValidationException("First name is required.");
        }
        if (changeRequest.getType() == ChangeRequest.Type.ADD && changeRequest.getSurname().equals("")) {
            throw new ValidationException("Surname is required.");
        }
        if (changeRequest.getType() == ChangeRequest.Type.ADD && changeRequest.getAddress().equals("")) {
            throw new ValidationException("Address is required.");
        }
        if (changeRequest.getType() == ChangeRequest.Type.ADD && changeRequest.getPhoneNum().equals("")) {
            throw new ValidationException("Phone number is required.");
        }
        if (changeRequest.getType() == ChangeRequest.Type.ADD && changeRequest.getBirthNum().equals("")) {
            throw new ValidationException("Birth number is required.");
        }
        if (changeRequest.getType() == ChangeRequest.Type.ADD && changeRequest.getCountryOfOrigin().equals("")) {
            throw new ValidationException("Country of origin is required.");
        }

        changeRequest.setPushedToApi(false);
        repository.save(changeRequest);
        logger.info("Created new ChangeRequest with id: " + changeRequest.getId());
        return changeRequest;
    }

}
