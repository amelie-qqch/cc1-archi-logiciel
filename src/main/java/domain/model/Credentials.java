package domain.model;

import domain.exception.InvalidArgumentException;
import javax.security.auth.login.CredentialException;

public final class Credentials {
    private final String emailAddress;
    private final String password;

    public Credentials(String emailAddress, String password) throws InvalidArgumentException, CredentialException {

        if(!emailIsValid(emailAddress)){
            throw new InvalidArgumentException("email invalide");
        }

        this.emailAddress = emailAddress;

        if(!passwordIsValid(password)){
            throw new InvalidArgumentException("mot de passe invalide");
        }

        this.password = password;

    }

    public String getEmailAddress(){
        return this.emailAddress;
    }

    /**
     * Returns hashed password
     */
    public String getPassword(){
        return this.password;
    }

    private boolean emailIsValid(String emailAddress){
        String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return emailAddress.matches(emailRegex);
    }

    private boolean passwordIsValid(String password){
        //TODO
        return true;
    }

}
