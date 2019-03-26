package utils;


import java.security.SecureRandom;

public class RandomString {

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom RANDOM = new SecureRandom();

    public static String getRandomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        return sb.toString();
    }
}