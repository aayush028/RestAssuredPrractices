package utilities;

import java.util.Random;

public class JavaHelpers {

    public int getRandomNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public String getRandomAlphaString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public String generateRandomNumberString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public String getRandomEmail(int nameLength) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameLength; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "testmail.com"};
        String domain = domains[random.nextInt(domains.length)];

        return sb.toString() + "@" + domain;
    }
}
