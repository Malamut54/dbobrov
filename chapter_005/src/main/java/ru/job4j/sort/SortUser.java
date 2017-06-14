package ru.job4j.sort;

import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.Comparator;

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

    /**
     * Method sorts user by length of name.
     *
     * @param list list.
     * @return list.
     */
    public List<User> sortNameLength(final List<User> list) {
        list.sort(
                (User first, User second) -> Integer.compare(first.getName().length(), second.getName().length()));

        return list;
    }

    /**
     * Method sorts user by all fields.
     *
     * @param list list.
     * @return list.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                (User first, User second) -> {
                    if (Integer.compare(first.getName().length(), second.getName().length()) == 0) {
                        return Integer.compare(first.getAge(), second.getAge());
                    } else {
                        return Integer.compare(first.getName().length(), second.getName().length());
                    }
                }
        );
        return list;
    }
}
