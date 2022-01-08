package domain.model;

public class Member {

    private final int id;
    private Credentials credentials;
    private String firstname;
    private String lastname;
    private MemberStatus status;

    public Member(
            int id,
            Credentials credentials,
            String firstname,
            String lastname
    ) {
        this.id           = id;
        this.firstname    = firstname;
        this.lastname     = lastname;
        this.credentials  = credentials;
        this.status       = MemberStatus.PENDING;
    }

    public int getId(){
        return this.id;
    }

    public String getEmailAddress() {
        return this.credentials.getEmailAddress();
    }

    public void changeCredentials(Credentials credentials) {
        this.credentials = credentials;
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

    public MemberStatus getStatus(){
        return this.status;
    }

    public void changeStatus(MemberStatus status){
        this.status = status;
    }


}
