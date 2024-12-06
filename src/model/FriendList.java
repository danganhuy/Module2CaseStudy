package model;

import java.util.ArrayList;
import java.util.List;

public class FriendList {
    private List<Account> friends;
    public FriendList() {
        friends = new ArrayList<>();
    }
    public List<Account> getFriends() {
        return friends;
    }
    public void setFriends(List<Account> friends) {
        this.friends = friends;
    }
    public void addFriend(Account friend) {
        friends.add(friend);
    }
    public void removeFriend(Account friend) {
        friends.remove(friend);
    }
}
