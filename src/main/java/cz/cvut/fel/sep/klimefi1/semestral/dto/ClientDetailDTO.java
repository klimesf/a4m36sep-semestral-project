package cz.cvut.fel.sep.klimefi1.semestral.dto;

import java.util.List;

public class ClientDetailDTO {
    private Integer id;
    private List<String> firstName;
    private List<String> surname;
    private List<String> address;
    private List<String> phoneNum;
    private String birthNum;
    private String countryOfOrigin;
    private String status;

    public ClientDetailDTO(Integer id, List<String> firstName, List<String> surname, List<String> address, List<String> phoneNum, String birthNum, String countryOfOrigin, String status) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.birthNum = birthNum;
        this.countryOfOrigin = countryOfOrigin;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public List<String> getFirstName() {
        return firstName;
    }

    public List<String> getSurname() {
        return surname;
    }

    public List<String> getAddress() {
        return address;
    }

    public List<String> getPhoneNum() {
        return phoneNum;
    }

    public String getBirthNum() {
        return birthNum;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getStatus() {
        return status;
    }
}
