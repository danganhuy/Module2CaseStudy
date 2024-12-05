package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conversation {
    private List<Message> message;

    public Conversation() {
        message = new ArrayList<Message>();
    }

    public List<Message> getMessage() {
        return message;
    }

    public void addMessage(Message message) {
        this.message.add(message);
    }

    public void deleteMessage(Message message) {
        message.setDeleted(true);
    }
}
