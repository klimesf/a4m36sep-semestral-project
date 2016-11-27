package cz.cvut.fel.sep.klimefi1.semestral.service;

import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ChangeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ChangeRequestUploader {

    private final ChangeRequestRepository repository;

    private Logger logger = Logger.getGlobal();

    @Autowired
    public ChangeRequestUploader(ChangeRequestRepository repository) {
        this.repository = repository;
    }

    public void upload() {
        for (ChangeRequest request : repository.findByPushedToApi(false)) {
            // TODO: implement
            logger.info("Pushed ChangeRequest with id: " + request.getId() + " to external API.");
        }
    }
}
