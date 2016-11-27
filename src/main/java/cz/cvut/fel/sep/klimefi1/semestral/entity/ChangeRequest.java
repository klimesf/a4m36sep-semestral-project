package cz.cvut.fel.sep.klimefi1.semestral.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ChangeRequest {

    private Long id;

    private Long clientId;

    private Type type;

    private String note;

    private Boolean pushedToApi = false;

    public enum Type {
        ADD,
        REMOVE,
        CHANGE_DATA,
        SUSPEND,
        REFUND
    }

    public ChangeRequest() {
    }

    public ChangeRequest(Long clientId, Type type, String note) {
        this.clientId = clientId;
        this.type = type;
        this.note = note;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
    }

    public String getNote() {
        return note;
    }

    public Long getClientId() {
        return clientId;
    }

    @NotNull
    public Boolean getPushedToApi() {
        if (pushedToApi == null) {
            return false;
        }
        return pushedToApi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPushedToApi(Boolean pushedToApi) {
        this.pushedToApi = pushedToApi;
    }
}
