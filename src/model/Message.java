package model;

import java.time.LocalDateTime;

public class Message {
    private Account account;
    private String message;
    private final LocalDateTime sendDate;
    private boolean deleted;

    public Message(Account account, String message) {
        this.message = message;
        this.account = account;
        this.sendDate = LocalDateTime.now();
        deleted = false;
    }
    public Account getUser() {
        return account;
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
        return account.getUsername() + "[" + sendDate.toString() + "]: " +
                (deleted ? "Message deleted by user" : message);
    }
}
