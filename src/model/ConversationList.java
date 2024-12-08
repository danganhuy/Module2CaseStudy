package model;

import java.util.ArrayList;
import java.util.List;

public class ConversationList {
    private List<Conversation> conversations;
    public ConversationList() {
        conversations = new ArrayList<Conversation>();
    }
    public List<Conversation> getConversations() {
        return conversations;
    }
    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }
    public void addConversation(Conversation conversation) {
        this.conversations.add(conversation);
    }
    public void removeConversation(Conversation conversation) {
        this.conversations.remove(conversation);
    }
}
