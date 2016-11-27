package cz.cvut.fel.sep.klimefi1.semestral.service;

import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ChangeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ChangeRequestUploader {

    @Autowired
    private ChangeRequestRepository repository;

    private Logger logger = Logger.getGlobal();

    public void upload() {
        for (ChangeRequest request : repository.findNonUploaded()) {
            // TODO: implement
            logger.info("Pushed ChangeRequest with id: " + request.getId() + " to external API.");
        }
    }
}
