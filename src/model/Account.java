package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String name;
    private String password;
    private FriendList friendList;

    public Account(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        FriendList friendList = new FriendList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
