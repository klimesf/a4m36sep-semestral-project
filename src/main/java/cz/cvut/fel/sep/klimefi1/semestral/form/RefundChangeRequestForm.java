package cz.cvut.fel.sep.klimefi1.semestral.form;


import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RefundChangeRequestForm {

    @NotNull
    @Min(1)
    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public ChangeRequest createChangeRequest() {
        return new ChangeRequest(getClientId(), ChangeRequest.Type.REFUND);
    }

}
