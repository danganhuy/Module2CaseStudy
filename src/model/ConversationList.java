package model;

import java.util.ArrayList;
import java.util.List;

public class ConversationList {
    private List<Conversation> conversationList;
    public ConversationList() {
        conversationList = new ArrayList<Conversation>();
    }
    public List<Conversation> getConversations() {
        return conversationList;
    }
    public void addConversation(Conversation conversation) {
        conversationList.add(conversation);
    }
    public void removeConversation(Conversation conversation) {
        conversationList.remove(conversation);
    }
}
