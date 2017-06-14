package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Final task collection.
 */
public class Manage {

    /**
     * Private filed.
     */
    private Map<User, List<Account>> dep = new HashMap<User, List<Account>>();

    /**
     * Getter.
     *
     * @return Map.
     */
    public Map<User, List<Account>> getDep() {
        return dep;
    }

    /**
     * Method add user.
     *
     * @param user user.
     */
    public void addUser(User user) {
        dep.put(user, new ArrayList<Account>());
    }

    /**
     * Method delete user.
     *
     * @param user user.
     */
    public void deleteUser(User user) {
        dep.remove(user);
    }

    /**
     * Method add account to user.
     *
     * @param user    user.
     * @param account account.
     */
    public void addAccountToUser(User user, Account account) {
        for (Map.Entry<User, List<Account>> entry : dep.entrySet()) {
            if (entry.getKey().equals(user)) {
                entry.getValue().add(account);
            }
        }
    }

    /**
     * Method delete account from user.
     *
     * @param user    user.
     * @param account account.
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> acc = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : dep.entrySet()) {
            if (entry.getKey().equals(user)) {
                acc = entry.getValue();
            }
        }
        for (int i = 0; i < acc.size(); i++) {
            if (acc.get(i).equals(account)) {
                acc.remove(i);
            }
        }
    }

    /**
     * Method return all user accounts.
     *
     * @param user user.
     * @return List accounts.
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> acc = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : dep.entrySet()) {
            if (entry.getKey().equals(user)) {
                acc = entry.getValue();
            }
        }
        return acc;
    }

    /**
     * Method transfer money from one account to another.
     *
     * @param srcUser    source user.
     * @param srcAccount source account.
     * @param dstUser    destination user.
     * @param dstAccount destination account.
     * @param amount     amount for transfer.
     * @return boolean.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        List<Account> tmp = new ArrayList<>();
        //Withdraw money
        for (Map.Entry<User, List<Account>> entry : dep.entrySet()) {
            if (entry.getKey().equals(srcUser) && entry.getValue().contains(srcAccount)) {
                tmp = entry.getValue();
                break;
            } else {
                return false;
            }
        }
        for (Account account : tmp) {
            if (account.equals(srcAccount) && account.getValue() >= amount) {
                account.setValue(account.getValue() - amount);
                break;
            } else if (account.equals(srcAccount) && account.getValue() < amount) {
                return false;
            }
        }

        //Deposit money
        for (Map.Entry<User, List<Account>> entry : dep.entrySet()) {
            if (entry.getKey().equals(dstUser) && entry.getValue().contains(dstAccount)) {
                tmp = entry.getValue();
                break;
            }
        }
        for (Account account : tmp) {
            if (account.equals(dstAccount)) {
                account.setValue(account.getValue() + amount);
                break;
            }
        }
        return true;
    }
}
