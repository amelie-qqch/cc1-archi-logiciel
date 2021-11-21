package domain.model;

import domain.exception.InvalidArgumentException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.security.auth.login.CredentialException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public final class Credentials {
    private final String HASHING_ALGORITHM = "PBKDF2WithHmacSHA1";

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
        String hashedPassword;
        try{
           hashedPassword = hashPassword(password);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException exception) {
            exception.printStackTrace();
            throw new CredentialException("Erreur lors de l'enregistrement du mot de passe");
        }
        this.password = hashedPassword;

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
        String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; // pourrait être une constante
        return emailAddress.matches(emailRegex);
    }

    private boolean passwordIsValid(String password){
        //TODO
        return true;
    }

    private String hashPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt         = new byte[16];
        random.nextBytes(salt);

        KeySpec spec             = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(HASHING_ALGORITHM);
        byte[] hash              = factory.generateSecret(spec).getEncoded();

        return new String(hash, StandardCharsets.UTF_8);
    }
}
