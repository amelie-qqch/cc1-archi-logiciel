package infrastructure.exception;

public class UnknownPricingPlanException extends Exception{
    public UnknownPricingPlanException(){
        super("Plan tarifaire inconnu.");
    }

}
