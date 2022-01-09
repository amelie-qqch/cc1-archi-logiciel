package domain.services.subscriptionPayment;

import infrastructure.Action;

public class ProcessPaymentAction implements Action {

    public int pricingPlan;
    public int memberId;
    public int paymentMethod;

    public ProcessPaymentAction(
        int memberId,
        int paymentMethod,
        int pricingPlan
    ) {
        this.paymentMethod  = paymentMethod;
        this.memberId       = memberId;
        this.pricingPlan    = pricingPlan;
    }
}
