package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConversationList implements Serializable {
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
    public Conversation findDirectChat(Account account) {
        for (Conversation conversation : conversations) {
            if (conversation instanceof DirectChat && conversation.userHere(account)) {
                return conversation;
            }
        }
        return null;
    }
}
