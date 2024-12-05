package model;

import java.util.ArrayList;
import java.util.List;

public class GroupChat extends Conversation{
    private List<Integer> userIds;

    public GroupChat(int conversationId, List<Integer> userIds) {
        super(conversationId);
        this.userIds = userIds;
    }

    public List<Integer> getUserList() {
        return userIds;
    }

    public void addUser(int userId) {
        userIds.add(userId);
    }

    public void removeUser(int userId) {
        userIds.remove(userId);
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
        return userIds.contains(id);
    }
}
