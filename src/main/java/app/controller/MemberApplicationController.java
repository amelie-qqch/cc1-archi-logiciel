package app.controller;

import domain.exception.MemberAlreadyExistsException;
import domain.exception.MemberRegistrationException;
import domain.model.Member;
import domain.services.registration.MemberRegistrationAction;
import domain.services.registration.MemberRegistrationHandler;
import utils.LoggerInterface;

public final class MemberApplicationController {
    private final MemberRegistrationHandler handler;
    private final LoggerInterface logger;

    MemberApplicationController(
        MemberRegistrationHandler handler,
        LoggerInterface logger
    ){
        this.handler = handler;
        this.logger  = logger;
    }

    int memberApplicationAction(
            String firstname,
            String lastname,
            String password,
            String email,
            String passwordConfirmation
    ) {
        MemberRegistrationAction action = new MemberRegistrationAction(
            firstname,
            lastname,
            password,
            email
        );
//        action.passwordConfirmation = passwordConfirmation; // verif pourrait être faite côté front

        try{
            Member newMember  = this.handler.handle(action);
        } catch (MemberAlreadyExistsException | MemberRegistrationException exception) {
            this.logger.warning(exception.getMessage());

            return 400;
        }


        return 201; //et retourner le membre à la vue
    }
}
