package model;

import java.util.ArrayList;
import java.util.List;

public class DirectChat extends Conversation{
    private int[] userIds;

    public DirectChat(int user0, int user1) {
        super();
        userIds = new int[] {user0, user1};
    }


}
