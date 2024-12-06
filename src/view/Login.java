package view;

import controller.LoginController;
import controller.Validator;
import model.Account;
import model.AccountManager;
import model.FileHandler;
import model.FriendList;

import java.util.Scanner;

public class Login {
    private final LoginController controller;

    public Login() {
        controller = new LoginController();
    }

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
                    login();
                    return;
                case "2":
                    register();
                    return;
                case "0":
                    return;
                default:
                    System.out.println("### Invalid option ###");
            }
        }
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        String username;
        System.out.println("=== Login ===");
        System.out.println("Type ### to exit");
        System.out.print("Enter your username: ");
        username = sc.nextLine();
        if (username.equals("###")) {
            option();
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

    public void register() {
        Scanner sc = new Scanner(System.in);
        String username;
        System.out.println("===== Register =====");
        while (true) {
            System.out.println("Type ### to exit");
            System.out.println("Username should have no numbers or special characters!");
            System.out.print("Enter your username: ");
            username = sc.nextLine();
            if (username.equals("###")) {
                option();
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
        option();
    }

    public static void main(String[] args) {
        Login login = new Login();
        FileHandler.createData();
        FileHandler.loadAccounts();
        login.option();

    }
}
