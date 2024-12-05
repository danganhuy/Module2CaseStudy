package model;

import java.time.LocalDateTime;

public class Message {
    private int userId;
    private String message;
    private final LocalDateTime sendDate;
    private boolean deleted;

    public Message(int userId, String message) {
        this.message = message;
        this.userId = userId;
        this.sendDate = LocalDateTime.now();
        deleted = false;
    }
    public int getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    protected String printMessage(Account account) {
        return account.getName() + "[" + sendDate.toString() + "]: " +
                (deleted ? "Message deleted by user" : message);
    }
}
