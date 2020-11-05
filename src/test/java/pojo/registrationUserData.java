package pojo;

public class registrationUserData {

    private String firstName;
    private String lastName;
    private String telephone;
    private String password;

    public registrationUserData(String _firstName, String _lastName, String _telephone, String _password) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.telephone = _telephone;
        this.password = _password;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getTelephone() {
        return this.telephone;
    }
    public String getPassword() {
        return this.password;
    }
}
