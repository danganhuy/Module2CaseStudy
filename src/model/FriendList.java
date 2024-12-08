package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FriendList implements Serializable {
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
    public Account findFriend(String username) {
        for(Account friend : friends) {
            if(friend.getUsername().equals(username)) {
                return friend;
            }
        }
        return null;
    }
}
