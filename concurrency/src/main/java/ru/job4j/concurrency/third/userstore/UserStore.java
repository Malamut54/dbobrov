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
        return userMap.putIfAbsent(user.getId(), user) == null;
    }

    public synchronized boolean update(User user) {
        return userMap.replace(user.getId(), user) != null;
    }

    public synchronized boolean delete(User user) {
        return userMap.remove(user.getId(), user);
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        User userFrom = userMap.get(fromId);
        User userTo = userMap.get(toId);

        if (userFrom != null && userTo != null && userFrom.getAmount() >= amount) {
            result = update(new User(userFrom.getId(), userFrom.getAmount() - amount)) &&
                update(new User(userTo.getId(), userTo.getAmount() + amount));
        }
        return result;
    }

}
