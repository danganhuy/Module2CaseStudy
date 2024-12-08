package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {
    private static final String ACCOUNT_FILE_PATH = "file\\accountData.csv";
    private static final String ACCOUNT_FILE_HEADER = "username,password,friends,conversations";
    private static final String CONVERSATION_FILE_PATH = "file\\conversationData.csv";
    private static final String CONVERSATION_FILE_HEADER = "type,id,accounts";
    private static final String VALUE_SEPARATOR = ",";
    private static final String INDEX_SEPERATOR = ";";
    private static final String EMPTY_LIST = "___";
    private static final String LINE_SEPARATOR = "\n";

    public static void saveAccounts() {
        FileWriter writer = null;
        try {
            writer = new FileWriter(ACCOUNT_FILE_PATH);
            writer.append(ACCOUNT_FILE_HEADER);
            writer.append(LINE_SEPARATOR);
            for (Account acc : AccountManager.getAccounts()) {
                writer.append(acc.getUsername()).append(VALUE_SEPARATOR);
                writer.append(acc.getPassword()).append(VALUE_SEPARATOR);
                List<Account> friends = acc.getFriendList().getFriends();
                if (!friends.isEmpty()) {
                    writer.append(EMPTY_LIST);
                }
                for (int i = 1; i < friends.size(); i++) {
                    writer.append(friends.get(i).getUsername()).append(INDEX_SEPERATOR);
                }
                writer.append(LINE_SEPARATOR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void loadData() {
        BufferedReader reader = null;
        try {
            List<Account> accounts = new ArrayList<>();
            List<String[]> friendListList = new ArrayList<>();
            Map<String, Account> accountMap = new HashMap<>();
            reader = new BufferedReader(new FileReader(ACCOUNT_FILE_PATH));
            String line;

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(VALUE_SEPARATOR);
                String username = data[0];
                String password = data[1];
                if (!data[2].equals(EMPTY_LIST)) {
                    friendListList.add(data[2].split(INDEX_SEPERATOR));
                } else {
                    friendListList.add(null);
                }
                Account temp = new Account(username, password);
                accounts.add(temp);
                accountMap.put(username, temp);
            }

            for (int i = 0; i < accounts.size(); i++) {
                if (friendListList.get(i) == null) continue;

                List<Account> friends = new ArrayList<>();
                for (String friend : friendListList.get(i)) {
                    friends.add(accountMap.get(friend));
                }
                accounts.get(i).getFriendList().setFriends(friends);
            }

            AccountManager.createInstance(accounts);
            ConversationManager.createInstance(new ArrayList<>());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
