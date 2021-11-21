package domain.services.registration;

import domain.exception.InvalidArgumentException;
import domain.exception.MemberAlreadyExistsException;
import domain.exception.MemberRegistrationException;
import domain.model.Credentials;
import domain.model.Member;
import infrastructure.repository.MemberRepository;

import javax.security.auth.login.CredentialException;

public class MemberRegistrationHandler {

    private final MemberRepository memberRepository;

    public MemberRegistrationHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member handle(MemberRegistrationAction action) throws MemberAlreadyExistsException, MemberRegistrationException {
        if(null != this.memberRepository.findByEmail(action.email)){
            throw new MemberAlreadyExistsException();
        }

        int memberId = this.memberRepository.nextIdentity();
        Credentials credentials;

        try{
            credentials = new Credentials(action.email, action.password);
        } catch (InvalidArgumentException | CredentialException exception) {
            exception.printStackTrace();
            throw new MemberRegistrationException(Integer.toString(memberId));
        }

        Member newMember = new Member(
                memberId,
                credentials,
                action.firstname,
                action.lastname
        );

        this.memberRepository.add(newMember);
//        this.memberRepository.save();

        return newMember;
    }

}
