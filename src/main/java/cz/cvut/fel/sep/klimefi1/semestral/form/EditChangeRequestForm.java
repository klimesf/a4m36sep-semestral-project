package cz.cvut.fel.sep.klimefi1.semestral.form;


import cz.cvut.fel.sep.klimefi1.semestral.dto.ClientDetailDTO;
import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;

import javax.validation.constraints.NotNull;

public class EditChangeRequestForm {

    @NotNull
    private Long clientId;

    @NotNull
    protected String firstName;

    @NotNull
    protected String surname;

    @NotNull
    protected String address;

    @NotNull
    protected String phoneNum;

    @NotNull
    protected String birthNum;

    @NotNull
    protected String countryOfOrigin;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getBirthNum() {
        return birthNum;
    }

    public void setBirthNum(String birthNum) {
        this.birthNum = birthNum;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public ChangeRequest createChangeRequest() {
        return new ChangeRequest(getClientId(), ChangeRequest.Type.CHANGE_DATA, getFirstName(), getSurname(), getAddress(), getPhoneNum(), getBirthNum(), getCountryOfOrigin());
    }

    public void preFillData(ClientDetailDTO client) {
        if (client != null) {
            if (client.getFirstName().size() > 0) {
                setFirstName(client.getFirstName().iterator().next());
            }

            if (client.getSurname().size() > 0) {
                setSurname(client.getSurname().iterator().next());
            }

            if (client.getAddress().size() > 0) {
                setAddress(client.getAddress().iterator().next());
            }

            if (client.getPhoneNum().size() > 0) {
                setPhoneNum(client.getPhoneNum().iterator().next());
            }

            setBirthNum(client.getBirthNum());
            setCountryOfOrigin(client.getCountryOfOrigin());
        }
    }
}
