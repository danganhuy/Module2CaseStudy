package model;

public class DirectChat extends Conversation{
    private int[] userIds;

    public DirectChat(int conversationId, int user0, int user1) {
        super(conversationId);
        userIds = new int[] {user0, user1};
    }

    public int[] getUsers() {
        return userIds;
    }

    @Override
    public void sendMessage(String message, Account account) {
        try {
            Message m = new Message(account.getId(), message);
            addMessage(m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean userHere(int id) {
        return id == userIds[0] || id == userIds[1];
    }
}
