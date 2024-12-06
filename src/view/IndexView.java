package view;

import java.util.Scanner;

public class IndexView extends View {
    @Override
    public View index() {
        Scanner sc = new Scanner(System.in);

        System.out.println("{[(  Welcome " + "  )]}");
        System.out.println("=== Main Menu ===");
        System.out.println("1. FriendsList");
        System.out.println("2. Conversations");
        System.out.println("3. Log out");
        System.out.println("4. Exit");

        while (true) {
            System.out.print("Your choice: ");
            switch (sc.nextLine()) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    return new LoginView();
                case "4":
                    return null;
                default:
                    System.out.println("### Invalid option ###");
            }
        }
    }
}
