package cz.cvut.fel.sep.klimefi1.semestral.service;


import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ChangeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class ChangeRequestDeleter {

    @Autowired
    private ChangeRequestRepository repository;

    private Logger logger = Logger.getGlobal();

    /**
     * Deletes ChangeRequest with given id.
     * @param id
     * @return
     */
    @Transactional
    public Boolean delete(Long id) {
        return delete(repository.findOne(id));
    }

    /**
     * Deletes given ChangeRequest.
     *
     * @param changeRequest
     * @return true if delete was successful or false if not.
     */
    @Transactional
    public Boolean delete(ChangeRequest changeRequest) {
        if (changeRequest == null) {
            return false;
        }

        if (changeRequest.getPushedToApi()) {
            return false;
        }

        repository.delete(changeRequest);
        logger.info("Deleted ChangeRequest with id: " + changeRequest.getId());
        return true;
    }

}
