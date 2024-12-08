package model;

import java.util.ArrayList;
import java.util.List;

public class GroupChat extends Conversation{
    private static class Member {
        Account account;
        boolean kicked;
        boolean admin;

        public Member(Account account, boolean admin) {
            this.account = account;
            this.admin = admin;
        }
    }

    private final List<Member> members;
    private String groupName;

    public GroupChat(String groupName, List<Account> accounts, Account admin) {
        super();
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.members.add(new Member(admin, true));
        for (Account account : accounts) {
            this.members.add(new Member(account, false));
        }
    }

    public List<String> getUserList() {
        List<String> userList = new ArrayList<>();
        for (Member member : members) {
            userList.add(member.account.getUsername());
        }
        return userList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Member> getMembers() {
        return members;
    }



    public void addUser(Account account) {
        members.add(new Member(account, false));
    }

    public void removeUser(int userId) {
        members.remove(userId);
    }

    @Override
    public void sendMessage(String message, Account account) {
        try {
            Message m = new Message(account, message);
            addMessage(m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean userHere(Account account) {
        for (Member member : members) {
            if (member.account.equals(account)) {
                return true;
            }
        }
        return false;
    }
}
