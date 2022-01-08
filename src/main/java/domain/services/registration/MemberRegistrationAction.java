package domain.services.registration;

public class MemberRegistrationAction {
    public String email;
    public String firstname;
    public String lastname;
    public String password;

    public MemberRegistrationAction(String email, String firstname, String lastname, String password) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }
}
