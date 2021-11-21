package domain.exception;

public final class MemberNotFoundException extends Exception{

    public MemberNotFoundException(String field){
        super(String.format("Utilisateur introuvable ou inexistant %s", field));
    }
}
