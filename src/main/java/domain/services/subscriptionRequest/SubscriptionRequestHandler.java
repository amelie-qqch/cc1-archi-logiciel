package domain.services.subscriptionRequest;

import utils.LoggerInterface;

public class SubscriptionRequestHandler {
    private LoggerInterface logger;

    public SubscriptionRequestHandler(LoggerInterface logger) {
        //subscriptionrepo
        this.logger = logger;
    }

    public void handle(SubscriptionRequestAction action){
        //récupère les subscription fee
        //Initialisation de la subscription request
        //Connection au système de paiement?
        //si date de paiement == aujourd'hui : processPayment sinon rien
        // ProcessPayment ?
        //Utilise le processpayment handler?
        //.???????

    }
}
