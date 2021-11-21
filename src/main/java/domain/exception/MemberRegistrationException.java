package domain.exception;

public class MemberRegistrationException extends Exception{
    public MemberRegistrationException(String reason){
        super(String.format("Erreur lors de l'enregistrement de l'utilisateur : %s", reason));
    }

}
