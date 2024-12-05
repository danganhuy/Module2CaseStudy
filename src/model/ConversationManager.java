package model;

import java.util.List;

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
}
