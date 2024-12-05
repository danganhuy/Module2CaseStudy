package model;

import java.util.List;

public class AccountManager {
    private static AccountManager instance;
    private List<Account> accounts;

    private AccountManager() {}

    public static void createInstance(List<Account> accounts) {
        instance = new AccountManager();
        instance.accounts = accounts;
    }

    public static AccountManager getInstance() {
        if(instance == null) {
            throw new RuntimeException();
        }
        return instance;
    }

    public static List<Account> getAccounts() {
        if(instance == null) {
            throw new RuntimeException();
        }
        return instance.accounts;
    }
}
