package cz.cvut.fel.sep.klimefi1.semestral.repository;


import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import org.springframework.data.repository.CrudRepository;

public interface ChangeRequestRepository extends CrudRepository<ChangeRequest, Long> {

    /**
     * Finds all ChangeRequests with pushedToApi parameter same as the given one.
     * @return
     */
    Iterable<ChangeRequest> findByPushedToApi(Boolean pushedToApi);
}
