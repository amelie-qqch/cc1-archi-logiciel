package domain.exception;

public class MemberRegistrationException extends Exception{
    public MemberRegistrationException(String memberId){
        super(String.format("Erreur lors de l'enregistrement de l'utilisateur : %s", memberId));
    }

}
