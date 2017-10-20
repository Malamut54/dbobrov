package ru.job4j.userstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Task User storage.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 20.10.2017
 */

public class UserStorage {
    /**
     * Store for users.
     */
    private List<User> store = new ArrayList<>();

    /**
     * Add user to store.
     *
     * @param user user for add.
     * @return boolean.
     */
    public synchronized boolean add(User user) {
        boolean result = false;
        if (store.isEmpty()) {
            store.add(user);
            result = true;
        } else {
            if (!store.contains(user)) {
                store.add(user);
                result = true;
            }
        }
        return result;
    }

    /**
     * Delete user from store.
     *
     * @param user user for delete.
     * @return boolean.
     */

    public synchronized boolean delete(User user) {
        boolean result = false;
        for (int i = 0; i < store.size(); i++) {
            if (user.equals(store.get(i))) {
                store.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Update user from store.
     *
     * @param user   user for update.
     * @param amount sum for update.
     * @return boolean.
     */
    public synchronized boolean update(User user, int amount) {
        boolean result = false;
        for (int i = 0; i < store.size(); i++) {
            if (user.equals(store.get(i))) {
                store.set(i, new User(store.get(i).getId(), amount));
                result = true;
            }
        }
        return result;
    }

    /**
     * Transfer money from on user to another.
     *
     * @param from from whom transfer.
     * @param to   to whom transfer.
     * @param sum  amount.
     * @return boolean.
     */
    public synchronized boolean transfer(User from, User to, int sum) {
        boolean result = false;
        User fromTmp = null;
        User toTmp = null;

        for (int i = 0; i < store.size(); i++) {
            if (from.equals(store.get(i)) && store.get(i).getAmount() >= sum) {
                fromTmp = store.get(i);
            }
            if (to.equals(store.get(i))) {
                toTmp = store.get(i);
            }
        }
        if (fromTmp != null && toTmp != null) {
            update(from, from.getAmount() - sum);
            update(to, to.getAmount() + sum);
            result = true;
        }
        return result;
    }

}
