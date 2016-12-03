package cz.cvut.fel.sep.klimefi1.semestral.dto;

public class ClientDTO {
    private Integer id;
    private String firstName;
    private String surname;
    private String status;

    public ClientDTO(Integer id, String firstName, String surname, String status) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
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

    public String getStatus() {
        return status;
    }
}
