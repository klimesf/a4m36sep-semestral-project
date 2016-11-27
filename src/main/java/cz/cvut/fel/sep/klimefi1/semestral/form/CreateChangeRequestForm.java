package cz.cvut.fel.sep.klimefi1.semestral.form;


import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;

import javax.validation.constraints.NotNull;

public class CreateChangeRequestForm {

    private Long clientId;

    @NotNull
    private ChangeRequest.Type type;

    private String note;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public ChangeRequest.Type getType() {
        return type;
    }

    public void setType(ChangeRequest.Type type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
