package domain.model;

public enum MemberStatus { // changer : et ajouter des subscriptionRequestStatus
    PENDING(1), APPROVED (2);

    private final int status;

    private static final MemberStatus[] STATUSES = MemberStatus.values();
    private static final int NBR_STATUSES = STATUSES.length;

    MemberStatus (int status){
        this.status = status;
    }

    public static MemberStatus get(int i){
        return STATUSES[i];
    }


}
