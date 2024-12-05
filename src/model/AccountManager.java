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

    public static void createAccount(Account account) {
        instance.accounts.add(account);
    }

    public static Account findUser(String username) {
        for(Account account : instance.accounts) {
            if(account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public static boolean validateAccount(String username, String password) {
        Account account = findUser(username);
        if (account != null) {
            return account.getPassword().equals(password);
        }
        return false;
    }
}
