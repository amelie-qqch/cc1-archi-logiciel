package domain.services.registration;

import domain.exception.InvalidArgumentException;
import domain.exception.MemberAlreadyExistsException;
import domain.exception.MemberRegistrationException;
import domain.model.Credentials;
import domain.model.Member;
import infrastructure.PasswordHasher;
import infrastructure.repository.MemberRepository;
import utils.LoggerInterface;

import javax.security.auth.login.CredentialException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class MemberRegistrationHandler {

    private final MemberRepository memberRepository;
    private final PasswordHasher passwordHasher;
    private final LoggerInterface logger;

    public MemberRegistrationHandler(
        MemberRepository memberRepository,
        PasswordHasher passwordHasher,
        LoggerInterface logger)
    {
        this.memberRepository   = memberRepository;
        this.passwordHasher     = passwordHasher;
        this.logger             = logger;
    }

    public Member handle(MemberRegistrationAction action) throws MemberAlreadyExistsException, MemberRegistrationException {
        if(null != this.memberRepository.findByEmail(action.email)){
            throw new MemberAlreadyExistsException();
        }

        int memberId = this.memberRepository.nextIdentity();
        Credentials credentials;
        String hashedPassword;

        try{
            hashedPassword = this.passwordHasher.hash(action.password);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException exception) {
            this.logger.warning(
                String.format(
                    "%s - Erreur lors du hashage du mot de passe",
                    this.getClass().getSimpleName()
                )
            );

            throw new RuntimeException("Erreur lors du hashage du mot de passe");
        }

        try{
            credentials = new Credentials(action.email, hashedPassword);
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

        return newMember;
    }

}
