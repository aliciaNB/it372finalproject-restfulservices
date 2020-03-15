package com.herokuapp.it372finalproject.restfulservices.services.mailchimp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class will generate a MD5 hash. MailChimp API requires MD5 hash for an subscriber emails.
 * Code originated from Geeks for Geeks.
 *
 * @author GeeksforGeeks
 * @version 1.0
 */
public class MD5 {

    /**
     * This method converts a string to its MD5 hash.
     *
     * @param input String to MD5 hash
     * @return MD% hash of input string
     */
    public static String getMd5(String input)
    {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
