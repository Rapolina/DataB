package DAY9;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.stream.Collectors;

public class Generator {

    public String generateRandomLogin() {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        String randomLogin = new Random().ints(10, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(character -> character.toString())
                .collect(Collectors.joining());
        return randomLogin;
    }

    public String generateRandomPassword() {
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        int n = 20;

        String randomString = new String(array, Charset.forName("UTF-8"));
        StringBuffer randomPassword = new StringBuffer();

        String  AlphaNumericString = randomString.replaceAll("[^A-Za-z0-9]", "");

        for (int k = 0; k < AlphaNumericString.length(); k++) {
            if (Character.isLetter(AlphaNumericString.charAt(k)) && (n > 0)
                    || Character.isDigit(AlphaNumericString.charAt(k))
                    && (n > 0)) {
                randomPassword.append(AlphaNumericString.charAt(k));
                n--;
            }
        }
        return randomPassword.toString();
    }
}