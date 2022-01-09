package app.controller;

import domain.exception.InvalidArgumentException;
import domain.exception.MemberNotFoundException;
import domain.services.subscriptionPayment.ProcessPaymentAction;
import domain.services.subscriptionPayment.ProcessPaymentHandler;
import infrastructure.exception.PaymentProcessingException;
import infrastructure.exception.UnknownPricingPlanException;
import utils.HTTP;
import utils.LoggerInterface;

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

            return HTTP.INTERNAL_SERVER_ERROR.value();
        } catch (MemberNotFoundException | UnknownPricingPlanException | InvalidArgumentException exception) {
            this.logger.error(exception.getMessage());

            return HTTP.BAD_REQUEST.value();
        }

        return HTTP.NO_CONTENT.value();
    }


}
