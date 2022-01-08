package app.controller;

import domain.exception.InvalidArgumentException;
import domain.exception.MemberNotFoundException;
import domain.services.registration.ProcessPaymentAction;
import domain.services.registration.ProcessPaymentHandler;
import infrastructure.exception.PaymentProcessingException;
import infrastructure.exception.UnknownPricingPlanException;
import utils.LoggerInterface;

import java.util.ArrayList;

public final class RegistrationFeePaymentController {
    private final ProcessPaymentHandler processPaymentHandler;
    private final LoggerInterface logger;

    public RegistrationFeePaymentController(
        LoggerInterface logger,
        ProcessPaymentHandler processPaymentHandler
    ) {
        this.processPaymentHandler = processPaymentHandler;
        this.logger = logger;
    }

    int paymentAction(
        int paymentMethod,
        int memberId,
        int pricingPlan
    ){
        try{
            ProcessPaymentAction action = new ProcessPaymentAction(memberId, paymentMethod, pricingPlan);
            this.processPaymentHandler.handle(action);
        } catch (PaymentProcessingException exception) {
            this.logger.error(exception.getMessage());
            //retourne 500 ou bien autre ?

            return 500;
        } catch (MemberNotFoundException | UnknownPricingPlanException | InvalidArgumentException exception) {
            this.logger.error(exception.getMessage());

            return 400;
        }

        return 204; // no content
    }


}
