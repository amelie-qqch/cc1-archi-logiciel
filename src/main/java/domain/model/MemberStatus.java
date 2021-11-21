package domain.model;

public class MemberStatus {
    public final static int PENDING_PAYMENT = 1;
    public final static int APPROVED = 2;

    private final int status;

    public MemberStatus (int status){
        this.status = status;
    }

    public int getStatus(){
        return this.status;
    }


}
