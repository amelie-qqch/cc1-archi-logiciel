package domain.exception;

public class MemberAlreadyExistsException extends Exception{
    public MemberAlreadyExistsException(){
        super("Cet utilisateur existe déjà");
    }

}
