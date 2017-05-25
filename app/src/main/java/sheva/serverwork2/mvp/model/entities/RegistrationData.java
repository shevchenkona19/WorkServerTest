package sheva.serverwork2.mvp.model.entities;

public class RegistrationData {
    private String username;
    private String password;
    private String email;

    public RegistrationData(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
