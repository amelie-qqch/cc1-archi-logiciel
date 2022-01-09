package app.controller;

import domain.services.subscriptionRequest.SubscriptionRequestAction;
import domain.services.subscriptionRequest.SubscriptionRequestHandler;
import infrastructure.forms.SubscriptionRequestForm;
import infrastructure.forms.Form;
import utils.HTTP;
import utils.LoggerInterface;

public class SubscriptionRequestController {
    private final SubscriptionRequestHandler handler;
    private final LoggerInterface logger;


    public SubscriptionRequestController(
        SubscriptionRequestHandler handler,
        LoggerInterface logger
    ) {
        this.handler = handler;
        this.logger  = logger;
    }

    Form subscriptionAction(){
        return new SubscriptionRequestForm();
    }

    int submitSubscriptionAction(/*Le formulaire avec les données*/SubscriptionRequestForm form ){
        if(!form.isSubmitted()){
            return HTTP.INTERNAL_SERVER_ERROR.value();
            //Erreur ce cas ne doit pas arriver
        }



        SubscriptionRequestAction action = form.getData();
        this.handler.handle(action);
        return HTTP.CREATED.value();
    }
}
