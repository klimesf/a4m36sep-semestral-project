package cz.cvut.fel.sep.klimefi1.semestral.dto;

public class ClientDetailDTO {
    private Integer id;
    private String firstName;
    private String surname;
    private String address;
    private String phoneNum;
    private String birthNum;
    private String countryOfOrigin;
    private String status;

    public ClientDetailDTO(Integer id, String firstName, String surname, String address, String phoneNum, String birthNum, String countryOfOrigin, String status) {
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

    public String getStatus() {
        return status;
    }
}
