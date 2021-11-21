package domain.services.registration;

import domain.exception.InvalidArgumentException;
import domain.exception.MemberAlreadyExistsException;
import domain.exception.MemberRegistrationException;
import domain.model.EmailAddress;
import domain.model.Member;
import infrastructure.repository.MemberRepository;

public class MemberRegistrationHandler {

    private MemberRepository memberRepository;

    public Member handle(MemberRegistrationAction action) throws MemberAlreadyExistsException, MemberRegistrationException {
        if(null != this.memberRepository.findByEmail(action.email)){
            throw new MemberAlreadyExistsException();
        }

        //TODO vérification du password

        int memberId = this.memberRepository.nextIdentity();
        EmailAddress email;

        try{
            email = new EmailAddress(action.email);
        } catch (InvalidArgumentException exception) {
            exception.printStackTrace();
            throw new MemberRegistrationException("email invalide");
        }
        Member newMember = new Member(
                memberId,
                email,
                action.firstname,
                action.lastname,
                action.password
        );

        this.memberRepository.add(newMember);
//        this.memberRepository.save();

        return newMember;
    }
}
