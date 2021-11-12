package domain.model;

public class Member {

    private int id;
    private EmailAddress emailAdresse; // ou credentials
    private String firstname;
    private String lastname;
    private Password password;

    public Member(
            int id,
            EmailAddress emailAddress,
            String firstname,
            String lastname,
            Password password
    ) {
        this.id           = id;
        this.emailAdresse = emailAddress;
        this.firstname    = firstname;
        this.lastname     = lastname;
        this.password     = password;
    }

    public int getId(){
        return this.id;
    }
    public EmailAddress getEmailAddress() {
        return this.emailAdresse;
    }

    public void changeEmailAddress(EmailAddress emailAddress) {
        this.emailAdresse = emailAddress;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void changeFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void changeLastname(String lastname) {
        this.lastname = lastname;
    }

    public Password getPassword() {
        return this.password;
    }

    public void changePassword(Password password){
        this.password = password;
    }


}
