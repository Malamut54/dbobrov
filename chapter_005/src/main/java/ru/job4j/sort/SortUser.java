package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Task sort.
 */
public class SortUser {
    /**
     * Method sorts users by age.
     *
     * @param list not sorted list.
     * @return sorts TreeSet.
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> sortUser = new TreeSet<User>();
        sortUser.addAll(list);
        return sortUser;
    }
}
