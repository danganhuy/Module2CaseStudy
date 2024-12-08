package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    private String username;
    private String password;
    private FriendList friendList;
    private ConversationList conversationList;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        friendList = new FriendList();
        conversationList = new ConversationList();
    }

    public Account(String username, String password, FriendList friendList, ConversationList conversationList) {
        this.username = username;
        this.password = password;
        this.friendList = friendList;
        this.conversationList = conversationList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FriendList getFriendList() {
        return friendList;
    }

    public ConversationList getConversationList() {
        return conversationList;
    }

    @Override
    public String toString() {
        return username;
    }
}
