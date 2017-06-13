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
    List<Account> acc = new ArrayList<Account>();

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
        dep.put(user, null);
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
        this.acc.add(account);
        for (Map.Entry<User, List<Account>> entry : dep.entrySet()) {
            if (entry.getKey().equals(user)) {
                entry.setValue(this.acc);
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
        for (Map.Entry<User, List<Account>> entry : dep.entrySet()) {
            if (entry.equals(user)) {
                this.acc = entry.getValue();
            }
        }
        for (int i = 0; i < this.acc.size(); i++) {
            if (this.acc.get(i).equals(account)) {
                this.acc.remove(i);
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
        for (Map.Entry<User, List<Account>> entry : dep.entrySet()) {
            if (entry.equals(user)) {
                this.acc = entry.getValue();
            }
        }
        return this.acc;
    }

    /**
     * Method transfer money from one account to another/
     *
     * @param srcUser    source user.
     * @param srcAccount source account.
     * @param dstUser    destination user.
     * @param dstAccount destination account.
     * @param amount     amount for transfer.
     * @return boolean.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {

        return false;
    }
}
