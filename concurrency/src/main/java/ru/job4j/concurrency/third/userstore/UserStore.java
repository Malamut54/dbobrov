package ru.job4j.concurrency.third.userstore;

import java.util.HashMap;
import java.util.Map;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class UserStore {

    @GuardedBy("this")
    private final Map<Integer, User> userMap = new HashMap<>();

    public synchronized boolean add(User user) {
        boolean result;

        if (userMap.containsKey(user.getId())) {
            result = false;
        } else {
            userMap.put(user.getId(), user);
            result = true;
        }

        return result;
    }

    public synchronized boolean update(User user) {
        boolean result;
        if (userMap.containsKey(user.getId())) {
            result = false;
        } else {
            userMap.replace(user.getId(), user);
            result = true;
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        boolean result;
        if (userMap.containsKey(user.getId())) {
            result = false;
        } else {
            userMap.remove(user.getId());
            result = true;
        }
        return result;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result;
        User userFrom = userMap.get(fromId);
        User userTo = userMap.get(toId);

        if (userFrom == null || userTo == null || userFrom.getAmount() < amount) {
            result = false;
        } else {
            update(new User(userFrom.getId(), userFrom.getAmount() - amount));
            update(new User(userTo.getId(), userTo.getAmount() + amount));
            result = true;
        }
        return result;
    }

}
