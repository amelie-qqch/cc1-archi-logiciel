package app.controller;

import domain.exception.MemberNotFoundException;
import domain.services.registration.ProcessPaymentAction;
import domain.services.registration.ProcessPaymentHandler;
import infrastructure.exception.PaymentProcessingException;
import infrastructure.exception.UnknownPricingPlanException;

public class RegistrationFeePaymentController {
    private ProcessPaymentHandler processPaymentHandler;

    int paymentAction(
            int paymentMethod,
            int memberId,
            int pricingPlan
    ){

        try{
            ProcessPaymentAction action = new ProcessPaymentAction(memberId, paymentMethod, pricingPlan);
            this.processPaymentHandler.handle(action);
        } catch (PaymentProcessingException exception) {
            exception.printStackTrace();

            return 500;
        } catch (MemberNotFoundException | UnknownPricingPlanException exception) {
            exception.printStackTrace();

            return 400;
        }

        return 204; // no content
    }


}
