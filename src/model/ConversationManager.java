package model;

import java.util.List;
import java.util.Random;

public class ConversationManager {
    private static ConversationManager instance;
    private List<Conversation> conversations;

    private ConversationManager() {}

    public static void createInstance(List<Conversation> conversations) {
        instance = new ConversationManager();
        instance.conversations = conversations;
    }

    public static ConversationManager getInstance() {
        if(instance == null) {
            throw new RuntimeException();
        }
        return instance;
    }

    public static List<Conversation> getConversations() {
        if(instance == null) {
            throw new RuntimeException();
        }
        return instance.conversations;
    }

    public static void addConversation(Conversation conversation) {
        instance.conversations.add(conversation);
    }

    public static String getNewId() {
        String newId = generateId();
        for (Conversation conversation : instance.conversations) {
            if(conversation.getId().equals(newId)) {
                return getNewId();
            }
        }
        return newId;
    }

    public static String generateId() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < 5) {
            int index = (int) (rnd.nextFloat() * chars.length());
            builder.append(chars.charAt(index));
        }
        return builder.toString();

    }
}
