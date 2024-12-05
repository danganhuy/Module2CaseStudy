package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Conversation implements Serializable {
    private int id;
    private List<Message> message;

    protected Conversation(int id) {
        this.id = id;
        message = new ArrayList<Message>();
    }

    public int getId() {
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
    public abstract boolean userHere(int id);
}
