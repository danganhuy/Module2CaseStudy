package model;

import java.util.ArrayList;
import java.util.List;

public class FriendList {
    private List<Integer> friendIds;
    public FriendList() {
        friendIds = new ArrayList<Integer>();
    }
    public List<Integer> getFriends() {
        return friendIds;
    }
    public void addFriend(Integer friendId) {
        friendIds.add(friendId);
    }
    public void removeFriend(Integer friendId) {
        friendIds.remove(friendId);
    }
}
