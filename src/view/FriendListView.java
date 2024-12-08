package view;

import model.*;

import java.util.List;
import java.util.Scanner;

public class FriendListView extends View {
    @Override
    public View index() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("{[(  Welcome " + LoginView.getCurrentUserName() + "  )]}");
            System.out.println("=== Friend List ===");
            System.out.println("1. Show friend list");
            System.out.println("2. Add friend");
            System.out.println("3. Remove friend");
            System.out.println("4. Start conversation with a friend");
            System.out.println("5. Go Back");

            System.out.print("Your choice: ");
            switch (sc.nextLine()) {
                case "1":
                    showFriendList();
                    break;
                case "2":
                    findFriend();
                    break;
                case "3":
                    removeFriend();
                    break;
                case "4":
                    startConversation();
                    break;
                case "5":
                    return new IndexView();
                default:
                    System.out.println("###### Invalid option ######");
            }
        }
    }

    public void showFriendList() {
        System.out.println("=== " + LoginView.getCurrentUserName() + " friend list ===");
        List<Account> friends = LoginView.getCurrentUser().getFriendList().getFriends();

        if (friends.isEmpty()) {
            System.out.println("No friends found");
        }
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(i + ". " + friends.get(i));
        }
    }

    public void findFriend() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Add friend ===");
        while (true) {
            System.out.println("Type ### to exit");
            System.out.print("Enter friend name: ");
            String friendName = sc.nextLine();

            if (friendName.equals("###")) {
                return;
            }

            Account friend = AccountManager.findUser(friendName);
            if (friend == null) {
                System.out.println("There no one with that name");
            } else if (LoginView.getCurrentUser().getFriendList().getFriends().contains(friend)) {
                System.out.println("That friend is already in the list");
            } else {
                Account currentUser = LoginView.getCurrentUser();
                Conversation conversation = new DirectChat(currentUser, friend);

                currentUser.getFriendList().addFriend(friend);
                friend.getFriendList().addFriend(LoginView.getCurrentUser());

                ConversationManager.addConversation(conversation);
                currentUser.getConversationList().addConversation(conversation);
                friend.getConversationList().addConversation(conversation);

                FileHandler.saveDataDat();
                FileHandler.saveData();

                System.out.println("Add friend successful");
            }
        }
    }

    public void removeFriend() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Remove friend ===");
        while (true) {
            System.out.println("Type ### to exit");
            System.out.print("Enter friend name: ");
            String friendName = sc.nextLine();

            if (friendName.equals("###")) {
                return;
            }

            Account friend = LoginView.getCurrentUser().getFriendList().findFriend(friendName);
            if (friend == null) {
                System.out.println("There no one with that name in your friend list");
            } else {
                LoginView.getCurrentUser().getFriendList().removeFriend(friend);
                friend.getFriendList().removeFriend(LoginView.getCurrentUser());
                System.out.println("Remove friend successful");
            }
        }
    }

    public void startConversation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Start Conversation ===");
        while (true) {
            System.out.println("Type ### to exit");
            System.out.print("Enter friend name: ");
            String friendName = sc.nextLine();

            if (friendName.equals("###")) {
                return;
            }

            Account friend = LoginView.getCurrentUser().getFriendList().findFriend(friendName);
            if (friend == null) {
                System.out.println("There no one with that name in your friend list");
            } else {
                directChatWithFriend(friend);
                return;
            }
        }
    }

    public void directChatWithFriend(Account friend) {
        Scanner sc = new Scanner(System.in);
        Conversation current = LoginView.getCurrentUser().getConversationList().findDirectChat(friend);

        while (true) {
            System.out.println("=== Chat with " + friend.getUsername() + " ===");
            System.out.println("1. Show chat log");
            System.out.println("2. Chat");
            System.out.println("3. Go Back");
            System.out.print("Your choice: ");
            switch (sc.nextLine()) {
                case "1":
                    System.out.println(current.display());
                    break;
                case "2":
                    chat(current, LoginView.getCurrentUser());
                    break;
                case "3":
                    return;
                default:
                    System.out.println("###### Invalid option ######");
            }
        }
    }

    public void chat(Conversation conversation, Account currentUser) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Type ### to exit");
            System.out.print("Enter your message: ");

            String message = sc.nextLine();

            if (message.equals("###")) {
                return;
            }
            if (message.isEmpty()) {
                System.out.println("You haven't type anything");
            } else {
                conversation.sendMessage(message, currentUser);
                FileHandler.saveDataDat();
                System.out.println("Message send successfully");
            }
        }
    }
}
