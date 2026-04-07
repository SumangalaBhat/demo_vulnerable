import java.security.MessageDigest;

public class CryptoExample {
    public String hash(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5"); // Weak algorithm
        byte[] hash = md.digest(input.getBytes());
        return new String(hash);
    }
}
