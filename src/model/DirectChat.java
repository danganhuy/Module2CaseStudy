package model;

public class DirectChat extends Conversation {
    private final Account[] accounts;

    public DirectChat(Account user0, Account user1) {
        super();
        accounts = new Account[] {user0, user1};
    }

    public Account[] getUsers() {
        return accounts;
    }

    @Override
    public void sendMessage(String message, Account account) {
        try {
            Message m = new Message(account, message);
            addMessage(m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean userHere(Account account) {
        return account == accounts[0] || account == accounts[1];
    }
}
