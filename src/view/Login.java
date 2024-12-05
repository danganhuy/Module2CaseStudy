package view;

import model.Account;
import model.AccountManager;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    public void option() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sign in ===");
        System.out.println("1. Log into your account");
        System.out.println("2. Create new account");
        System.out.println("0. Exit");

        while (true) {
            System.out.print("Your choice: ");
            switch (sc.nextLine()) {
                case "1":

                    return;
                case "2":

                    return;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("### Invalid, please try again ###");
            }
        }
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        if (AccountManager.validateAccount(username, password)) {
            System.out.println("You have successfully logged in!");
        }
        else {
            System.out.println("### Invalid username or password! ###");
            System.out.println("Do you want try again?");
            System.out.println("Y: Retry login");
            System.out.println("N: Exit login");
            while (true) {
                System.out.print("Your choice: ");
                switch (sc.nextLine()) {
                    case "Y":
                        login();
                    case "N":
                        option();
                    default:
                        System.out.println("### Invalid option! ###");
                }
            }
        }
    }

    public void register() {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]*$");
        Matcher matcher;
        String username;
        while (true) {
            System.out.println("Username should have no numbers or special characters!");
            System.out.print("Enter your username: ");
            username = sc.nextLine();
            if (pattern.matcher(username).matches()) {
                break;
            }
            else {
                System.out.println("### Invalid username! ###");
            }
            if (AccountManager.findUser(username) != null) {
                System.out.println("### Username already used! ###");
            }
        }
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        AccountManager.createAccount(new Account(username, password));

    }
}
