package infrastructure;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PasswordHasher {
    private final String HASHING_ALGORITHM = "PBKDF2WithHmacSHA1";

    public String hash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt         = new byte[16];
        random.nextBytes(salt);

        KeySpec spec             = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(HASHING_ALGORITHM);
        byte[] hash              = factory.generateSecret(spec).getEncoded();

        return new String(hash, StandardCharsets.UTF_8);
    }
}
