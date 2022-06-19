import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encryption {
    //encrypt password with SHA-256
    public static String encrypt(String secret) {
        String encryptedPassword = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(secret.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encryptedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }
}
