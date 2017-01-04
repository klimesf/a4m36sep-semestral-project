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
        changeRequest.setPushedToApi(false);
        repository.save(changeRequest);
        logger.info("Created new ChangeRequest with id: " + changeRequest.getId());
        return changeRequest;
    }

}
