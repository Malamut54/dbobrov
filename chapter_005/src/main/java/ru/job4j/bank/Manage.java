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
        if (user != null) {
            dep.put(user, new ArrayList<Account>());
        }
    }

    /**
     * Method delete user.
     *
     * @param user user.
     */
    public void deleteUser(User user) {
        if (user != null) {
            dep.remove(user);
        }
    }

    /**
     * Method add account to user.
     *
     * @param user    user.
     * @param account account.
     */
    public void addAccountToUser(User user, Account account) {
        if (user != null && account != null && dep.containsKey(user)) {
            dep.get(user).add(account);
        }
    }

    /**
     * Method delete account from user.
     *
     * @param user    user.
     * @param account account.
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (user != null && account != null && dep.containsKey(user)) {
            dep.get(user).remove(account);
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
        if (user != null && dep.containsKey(user)) {
            acc = dep.get(user);
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
        if (srcUser != null && srcAccount != null && dstUser != null && dstAccount != null) {
            tmp = dep.get(srcUser);
        } else {
            return false;
        }
        // check that all users and accounts exist.
        if (dep.get(srcUser).contains(srcAccount) && dep.get(dstUser).contains(dstAccount)) {
            for (Account account : tmp) {
                if (account.equals(srcAccount) && account.getValue() >= amount) {
                    account.setValue(account.getValue() - amount);
                    break;
                } else if (account.equals(srcAccount) && account.getValue() < amount) {
                    return false;
                }
            }
            tmp = dep.get(dstUser);
            for (Account account : tmp) {
                if (account.equals(dstAccount)) {
                    account.setValue(account.getValue() + amount);
                    break;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
