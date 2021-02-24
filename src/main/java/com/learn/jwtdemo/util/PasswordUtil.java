package com.learn.jwtdemo.util;

/**
 * @author RAHUL KUMAR MAURYA
 */

import com.learn.jwtdemo.constants.APIConstants;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;


/**
 * This class is used to secure the password with the help of encryption and decryption.
 */
public class PasswordUtil {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    /**
     * @param myKey
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static void setKey(String myKey) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance(APIConstants.SHA_1);
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, APIConstants.AES);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new NoSuchAlgorithmException(APIConstants.SERVER_CONNECTION_FAILED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param strToEncrypt
     * @param secret
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     */
    public static String encrypt(String strToEncrypt, String secret) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance(APIConstants.AES_ECB_PKCS5PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (UnsupportedEncodingException e) {

            System.out.println("-----Exception------" + e.getMessage());

            throw new UnsupportedEncodingException(e.getMessage());

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
            throw new NoSuchAlgorithmException(APIConstants.SERVER_CONNECTION_FAILED);

        } catch (NoSuchPaddingException e) {

            e.printStackTrace();
            throw new NoSuchPaddingException(APIConstants.SERVER_CONNECTION_FAILED);

        } catch (BadPaddingException e) {

            e.printStackTrace();
            throw new BadPaddingException(APIConstants.SERVER_CONNECTION_FAILED);

        } catch (IllegalBlockSizeException e) {

            e.printStackTrace();
            throw new IllegalBlockSizeException(APIConstants.SERVER_CONNECTION_FAILED);

        } catch (InvalidKeyException e) {

            e.printStackTrace();
            throw new InvalidKeyException(APIConstants.SERVER_CONNECTION_FAILED);

        }

    }

    /**
     * @param strToDecrypt
     * @param secret
     * @return
     * @throws Exception
     */
    public static String decrypt(String strToDecrypt, String secret) throws Exception {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance(APIConstants.AES_ECB_PKCS5PADDING);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (UnsupportedEncodingException e) {

            System.out.println("-----Exception------" + e.getMessage());

            throw new UnsupportedEncodingException(e.getMessage());
        }
    }

}
