package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Conversation implements Serializable {
    private String id;
    private List<Message> message;

    protected Conversation() {
        this.id = ConversationManager.getNewId();
        message = new ArrayList<Message>();
    }

    public String getId() {
        return id;
    }

    protected List<Message> getMessage() {
        return message;
    }

    protected void addMessage(Message message) {
        this.message.add(message);
    }

    protected void deleteMessage(Message message) {
        message.setDeleted(true);
    }

    public abstract void sendMessage(String message, Account account);
    public abstract boolean userHere(Account account);
}
