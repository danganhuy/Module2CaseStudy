package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Conversation implements Serializable {
    private final String id;
    private List<Message> messages;

    protected Conversation() {
        this.id = ConversationManager.getNewId();
        messages = new ArrayList<Message>();
    }

    public String getId() {
        return id;
    }

    protected List<Message> getMessages() {
        return messages;
    }

    protected void addMessage(Message message) {
        this.messages.add(message);
    }

    protected void deleteMessage(Message message) {
        message.setDeleted(true);
    }

    public abstract void sendMessage(String message, Account account);
    public abstract boolean userHere(Account account);

    public String display() {
        if (messages.isEmpty()) {
            return "*** No Messages ***";
        }

        StringBuilder sb = new StringBuilder();
        for (Message m : messages) {
            sb.append(m.printMessage()).append("\n");
        }
        return sb.toString();
    }
}
