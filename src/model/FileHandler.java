package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static void WriteData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("data")))) {
            oos.writeObject(AccountManager.getAccounts());
            oos.writeObject(ConversationManager.getConversations());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ReadData() {
        if (!Files.exists(Paths.get("data"))) {
            try {
                (new File("data")).createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("data")))) {
            List<Account> accounts = (List<Account>) ois.readObject();
            List<Conversation> conversations = (List<Conversation>) ois.readObject();
            AccountManager.createInstance(accounts);
            ConversationManager.createInstance(conversations);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
