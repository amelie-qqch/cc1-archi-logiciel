package domain.services.registration;

import domain.model.PaymentMethod;
import domain.model.SubscriptionFees;

import java.util.Date;

public class SubscriptionRequestAction {
    public int memberId;
    public int subscriptionType;
    public int subscriptionPeriodicity;

    //Dans un autre handler pour la partie paiement
    public int subscriptionRequestId;
    public SubscriptionFees subscriptionFees;
    public Date withdrawalDate;
    public PaymentMethod paymentMethod;

    //Autre action : ajout d'une méthode de paiement
//    public boolean savePaymentMethod;

}
