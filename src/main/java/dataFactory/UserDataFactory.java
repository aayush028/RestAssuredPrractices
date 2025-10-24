package dataFactory;

import dataObject.user.User;
import utilities.JavaHelpers;

public class UserDataFactory {

    public static User getUserDetails() {
        User userData = new User();
        JavaHelpers javaHelpers = new JavaHelpers();

        userData.setId(javaHelpers.getRandomNumber(1, 100));
        userData.setUsername(javaHelpers.generateRandomNumberString(6));
        userData.setFirstName(javaHelpers.getRandomAlphaString(8));
        userData.setLastName(javaHelpers.getRandomAlphaString(8));
        userData.setEmail(javaHelpers.getRandomEmail(8));
        userData.setPassword(javaHelpers.generateRandomNumberString(8));
        userData.setPhone(javaHelpers.generateRandomNumberString(8));
        userData.setUserStatus(1);
        return userData;
    }
}
