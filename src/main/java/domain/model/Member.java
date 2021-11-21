package domain.model;

public class Member {

    private final int id;
    private EmailAddress emailAdresse;
    private String firstname;
    private String lastname;
    private String password;
    private MemberStatus status;

    public Member(
            int id, //Faire une classe ?
            EmailAddress emailAddress,
            String firstname,
            String lastname,
            String password
    ) {
        this.id           = id;
        this.emailAdresse = emailAddress;
        this.firstname    = firstname;
        this.lastname     = lastname;
        this.password     = password;
        this.status       = new MemberStatus(MemberStatus.PENDING_PAYMENT);
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

    public String getPassword() {
        return this.password;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public MemberStatus getStatus(){
        return this.status;
    }

    public void changeStatus(MemberStatus status){
        this.status = status;
    }


}
