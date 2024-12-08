package view;

import model.Conversation;
import model.DirectChat;

import java.util.Scanner;

public class ConversationListView extends View {
    @Override
    public View index() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("{[(  Welcome " + LoginView.getCurrentUserName() + "  )]}");
            System.out.println("=== Conversation List ===");
            System.out.println("1. Show conversation list");
            System.out.println("2. Start direct chat");
            System.out.println("3. Start a group chat");
            System.out.println("4. Chat");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            switch (sc.nextLine()) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    return null;
                default:
                    System.out.println("###### Invalid option ######");
            }
        }
    }
    public void showConversationList() {
        System.out.println("=== List of conversations ===");
        for (Conversation conversation : LoginView.getCurrentUser().getConversationList().getConversations()) {
            if (conversation instanceof DirectChat) {

            }
        }
    }
}
