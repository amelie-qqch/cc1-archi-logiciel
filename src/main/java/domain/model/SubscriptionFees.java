package domain.model;

import domain.exception.InvalidArgumentException;

public class SubscriptionFees {
    private final double amount;

    public SubscriptionFees(double amount) throws InvalidArgumentException {
        if(!amountIsValid(amount)){
            throw new InvalidArgumentException("montant invalide");
        }

        this.amount = amount;
    }

    public double getAmount(){
        return this.amount;
    }

    private boolean amountIsValid(double amount){
        return true;
    }
}
