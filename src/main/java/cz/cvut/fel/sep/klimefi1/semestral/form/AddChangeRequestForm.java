package cz.cvut.fel.sep.klimefi1.semestral.form;


import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class AddChangeRequestForm {

    @NotEmpty
    protected String firstName;

    @NotEmpty
    protected String surname;

    @NotEmpty
    protected String address;

    @Pattern(regexp = "[0-9]{9}")
    protected String phoneNum;

    @Pattern(regexp = "[0-9]{10}")
    protected String birthNum;

    @NotEmpty
    protected String countryOfOrigin;

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
        return new ChangeRequest(null, ChangeRequest.Type.ADD, getFirstName(), getSurname(), getAddress(), getPhoneNum(), getBirthNum(), getCountryOfOrigin());
    }

}
