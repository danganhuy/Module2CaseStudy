package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
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

    @Override
    public String toString() {
        return name;
    }
}
