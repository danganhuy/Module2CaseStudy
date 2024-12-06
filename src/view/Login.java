package view;

import controller.Validator;
import model.Account;
import model.AccountManager;
import model.FileHandler;
import model.FriendList;

import java.util.Scanner;

public class Login extends View {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sign in ===");
        System.out.println("1. Log into your account");
        System.out.println("2. Create new account");
        System.out.println("3. Exit");

        while (true) {
            System.out.print("Your choice: ");
            switch (sc.nextLine()) {
                case "1":
                    login();
                case "2":
                    register();
                case "3":
                    return;
                default:
                    System.out.println("### Invalid option ###");
            }
        }
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        String username;
        System.out.println("=== Login ===");
        System.out.println("Type ### to exit");
        System.out.print("Enter your username: ");
        username = sc.nextLine();
        if (username.equals("###")) {
            mainMenu();
        }
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        if (AccountManager.validateAccount(username, password)) {
            System.out.println("You have successfully logged in!");
        }
        else {
            System.out.println("### Wrong username or password ###");
        }
        login();
    }

    public static void register() {
        Scanner sc = new Scanner(System.in);
        String username;
        System.out.println("===== Register =====");
        while (true) {
            System.out.println("Type ### to exit");
            System.out.println("Username should have no numbers or special characters!");
            System.out.print("Enter your username: ");
            username = sc.nextLine();
            if (username.equals("###")) {
                mainMenu();
            }
            if (!Validator.isUsernameValid(username)) {
                System.out.println("### Invalid username! ###");
                continue;
            }
            if (AccountManager.findUser(username) != null) {
                System.out.println("### Username already used! ###");
                continue;
            }
            break;
        }
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        AccountManager.createAccount(new Account(username, password, new FriendList()));
        FileHandler.saveAccounts();
        System.out.println("Account created successfully!");
        mainMenu();
    }

    public static void main(String[] args) {
        FileHandler.createData();
        FileHandler.loadAccounts();
        Login.mainMenu();
    }
}
