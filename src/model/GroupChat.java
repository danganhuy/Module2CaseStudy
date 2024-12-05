package model;

import java.util.ArrayList;
import java.util.List;

public class GroupChat extends Conversation{
    private List<Integer> userIds;

    public GroupChat(List<Integer> userIds) {
        super();
        this.userIds = userIds;
    }


}
