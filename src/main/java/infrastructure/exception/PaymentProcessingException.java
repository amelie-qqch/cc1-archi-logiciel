package infrastructure.exception;

public class PaymentProcessingException extends Exception{
    public PaymentProcessingException(){
        super("Erreur lors du règlement de l'inscription.");
    }

}
