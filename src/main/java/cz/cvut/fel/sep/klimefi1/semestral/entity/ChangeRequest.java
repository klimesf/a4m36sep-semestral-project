package cz.cvut.fel.sep.klimefi1.semestral.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ChangeRequest {

    private Long id;

    private Long clientId;

    private Type type;

    private Boolean pushedToApi = false;

    protected String firstName;

    protected String surname;

    protected String address;

    protected String phoneNum;

    protected String birthNum;

    protected String countryOfOrigin;

    public enum Type {
        ADD,
        REMOVE,
        CHANGE_DATA,
        SUSPEND,
        REFUND
    }

    public ChangeRequest() {
    }

    public ChangeRequest(Long clientId, Type type, String firstName, String surname, String address, String phoneNum, String birthNum, String countryOfOrigin) {
        this.clientId = clientId;
        this.type = type;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.birthNum = birthNum;
        this.countryOfOrigin = countryOfOrigin;
    }

    public ChangeRequest(Long clientId, Type type) {
        this.clientId = clientId;
        this.type = type;
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

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getBirthNum() {
        return birthNum;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
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

    public void setPushedToApi(Boolean pushedToApi) {
        this.pushedToApi = pushedToApi;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setBirthNum(String birthNum) {
        this.birthNum = birthNum;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

}
