package view;

import model.Account;
import model.AccountManager;

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
            System.out.println("5. Exit");

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
                    break;
                case "5":
                    return null;
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
            } else {
                LoginView.getCurrentUser().getFriendList().addFriend(friend);
                friend.getFriendList().addFriend(LoginView.getCurrentUser());
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

            Account friend = AccountManager.findUser(friendName);
            if (friend == null) {
                System.out.println("There no one with that name in your friend list");
            } else {
                LoginView.getCurrentUser().getFriendList().removeFriend(friend);
                friend.getFriendList().removeFriend(LoginView.getCurrentUser());
                System.out.println("Remove friend successful");
            }
        }
    }
}
