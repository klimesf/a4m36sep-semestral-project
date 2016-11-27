package cz.cvut.fel.sep.klimefi1.semestral.form;


import javax.validation.constraints.NotNull;

public class CreateChangeRequestForm {

    private Integer clientId;

    @NotNull
    private Type type;

    private String note;

    public enum Type {
        ADD,
        REMOVE,
        CHANGE_DATA,
        SUSPEND,
        REFUND
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
