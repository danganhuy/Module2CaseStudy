package controller;

public class Validator {
    private static final String USERNAME_REGEX = "^[a-zA-Z\\s]*$";

    public static boolean isUsernameValid(String username) {
        return username.matches(USERNAME_REGEX);
    }
}
