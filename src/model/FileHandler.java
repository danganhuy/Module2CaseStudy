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
    private static final String FILE_PATH_DAT = "file\\data.dat";
    private static final String VALUE_SEPARATOR = ",";
    private static final String INDEX_SEPERATOR = ";";
    private static final String EMPTY_LIST = "___";
    private static final String LINE_SEPARATOR = "\n";

    public static void saveData() {
        FileWriter writerAccount = null;
        FileWriter writerConversation = null;
        try {
            writerAccount = new FileWriter(ACCOUNT_FILE_PATH);
            writerConversation = new FileWriter(CONVERSATION_FILE_PATH);

            writerAccount.append(ACCOUNT_FILE_HEADER);
            writerAccount.append(LINE_SEPARATOR);
            for (Account acc : AccountManager.getAccounts()) {
                writerAccount.append(acc.getUsername()).append(VALUE_SEPARATOR);
                writerAccount.append(acc.getPassword()).append(VALUE_SEPARATOR);

                List<Account> friends = acc.getFriendList().getFriends();
                if (friends.isEmpty()) {
                    writerAccount.append(EMPTY_LIST);
                }
                else {
                    writerAccount.append(friends.get(0).getUsername());
                    for (int i = 1; i < friends.size(); i++) {
                        writerAccount.append(INDEX_SEPERATOR).append(friends.get(i).getUsername());
                    }
                }

                writerAccount.append(VALUE_SEPARATOR);

                List<Conversation> conversations = acc.getConversationList().getConversations();
                if (conversations.isEmpty()) {
                    writerAccount.append(EMPTY_LIST);
                }
                else {
                    writerAccount.append(conversations.get(0).getId());
                    for (int i = 1; i < conversations.size(); i++) {
                        writerAccount.append(INDEX_SEPERATOR).append(conversations.get(i).getId());
                    }
                }

                writerAccount.append(LINE_SEPARATOR);
            }

            writerConversation.append(ACCOUNT_FILE_HEADER);
            writerConversation.append(LINE_SEPARATOR);
            for (Conversation conversation : ConversationManager.getConversations()) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writerAccount.flush();
                writerConversation.flush();
                writerAccount.close();
                writerConversation.close();
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

    public static void saveDataDat() {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH_DAT));

            oos.writeObject(ConversationManager.getConversations());
            oos.writeObject(AccountManager.getAccounts());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void loadDataDat() {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(FILE_PATH_DAT));

            ConversationManager.createInstance((List<Conversation>) ois.readObject());
            AccountManager.createInstance((List<Account>) ois.readObject());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileHandler.loadData();
        FileHandler.saveDataDat();
    }
}
