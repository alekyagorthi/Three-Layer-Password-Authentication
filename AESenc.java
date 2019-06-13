import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESenc {
  private static final String ALGO = "AES";
  private static final byte[] keyValue =
            new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     */
    public static String encrypt(String data) throws Exception 
    {
        Key key = generateKey();
        System.out.println(key);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        System.out.println(encVal);
        return Base64.getEncoder().encodeToString(encVal);
    }
    public static String decrypt1(String data)throws Exception
    {
    	Key key = generateKey();
        System.out.println(key);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        System.out.println(encVal);
        return Base64.getEncoder().encodeToString(encVal);
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param encryptedData is a string
     * @return the decrypted string
     */
    public static String decrypt(String encryptedData) throws Exception 
    {
        Key key = generateKey();
        System.out.println(key);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        System.out.println(decordedValue);
        byte[] decValue = c.doFinal(decordedValue);
        System.out.println(decValue);
        System.out.println(new String(decValue));
        return new String(decValue);
    }
    public static void main(String args[]) throws Exception
    {
    	String encrypted=encrypt("123456789");
    	System.out.println(encrypted);
    	String decrypted=decrypt(encrypted);
    	System.out.println(decrypted);
    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey() throws Exception
    {
        return new SecretKeySpec(keyValue, ALGO);
    }
}