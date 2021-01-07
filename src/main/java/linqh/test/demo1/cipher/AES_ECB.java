package linqh.test.demo1.cipher;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;

public class AES_ECB {
    private static Key secretKey = new SecretKeySpec("password12345678".getBytes(),"AES");

    public static void main(String[] main) throws Exception {
        byte[] original = "original text 12".getBytes();
        System.out.println("original:" + Arrays.toString(original));

        byte[] encrypt = encrypt(original);
        System.out.println("encrypt:" + Arrays.toString(encrypt));

        byte[] recover = decrypt(encrypt);
        System.out.println("decrypt:" + Arrays.toString(recover));
    }

    public static final byte[] encrypt(byte[] originalBytes) throws Exception  {
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(originalBytes);
    }

    public static final byte[] decrypt(byte[] encryptedBytes) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedBytes);
    }
}
