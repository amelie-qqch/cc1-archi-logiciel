package app.controller;

import domain.exception.MemberAlreadyExistsException;
import domain.exception.MemberRegistrationException;
import domain.model.Member;
import domain.services.registration.MemberRegistrationAction;
import domain.services.registration.MemberRegistrationHandler;

public class MemberApplicationController {
    private final MemberRegistrationHandler handler;

    MemberApplicationController(MemberRegistrationHandler handler){
        this.handler = handler;
    }

    int memberApplicationAction(
            String firstname,
            String lastname,
            String password,
            String email,
            String passwordConfirmation
    ) throws MemberAlreadyExistsException {
        // pourrait récupérer une requête et un formulaire (par exemple) mais je ne sais pas encore le faire en java
        // Donc renvoie un code http à la place
        MemberRegistrationAction action = new MemberRegistrationAction();

        action.firstname            = firstname;
        action.lastname             = lastname;
        action.password             = password;
        action.email                = email;
        action.passwordConfirmation = passwordConfirmation; // verif pourrait être faite côté front

        try{
            Member newMember  = this.handler.handle(action);
        } catch (MemberAlreadyExistsException | MemberRegistrationException exception) {
            exception.printStackTrace();
            return 400;
        }


        return 201; //et retourner le membre à la vue
    }
}
