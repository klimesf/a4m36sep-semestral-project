package cz.cvut.fel.sep.klimefi1.semestral.repository;


import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import org.springframework.data.repository.CrudRepository;

public interface ChangeRequestRepository extends CrudRepository<ChangeRequest, Long> {

    /**
     * Finds all ChangeRequests which have not been uploaded yet.
     * @return
     */
    Iterable<ChangeRequest> findNonUploaded();
}
