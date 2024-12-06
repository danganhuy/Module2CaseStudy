package view;

import sun.rmi.runtime.Log;

import java.util.Scanner;

public class Index extends View {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Main Menu ===");
        System.out.println("1. FriendsList");
        System.out.println("2. Conversations");
        System.out.println("3. Log out");
        System.out.println("4. Exit");

        while (true) {
            System.out.print("Your choice: ");
            switch (sc.nextLine()) {
                case "1":
                    return;
                case "2":
                    return;
                case "3":
                    return;
                case "4":
                    Login.login();
                default:
                    System.out.println("### Invalid option ###");
            }
        }
    }
}
