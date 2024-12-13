package org.kure.example11.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Encryption {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException {
        String password = "encryptionPassword";
        String salt = "12345678";
        IvParameterSpec ivParameterSpec = generateIv();
        SecretKey key = getKeyFromPassword(password,salt);
        final Cipher aesEncrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
        final Cipher aesDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesEncrypt.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
        aesDecrypt.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
        String secret = "This is a secret message";
        String encrypted = encrypt(secret, aesEncrypt);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypt(encrypted, aesDecrypt));

    }

    private static String encrypt(String secret, Cipher aes) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        return Base64.getEncoder().encodeToString(aes.doFinal(secret.getBytes(StandardCharsets.UTF_8)));
    }

    private static String decrypt(String encrypted, Cipher aes) throws IllegalBlockSizeException, BadPaddingException {
        return new String(aes.doFinal(Base64.getDecoder().decode(encrypted)), StandardCharsets.UTF_8);
    }

    public static SecretKey getKeyFromPassword(String password, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
        return new SecretKeySpec(factory.generateSecret(spec)
                .getEncoded(), "AES");
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }
}
