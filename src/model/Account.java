package model;

import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private String password;
    private FriendList friendList;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        friendList = new FriendList();
    }

    public Account(String username, String password, FriendList friendList) {
        this.username = username;
        this.password = password;
        this.friendList = friendList;
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

    @Override
    public String toString() {
        return username;
    }
}
