package ru.job4j.sort;

import java.util.*;

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

    public List<User> sortNameLength(List<User> list) {

        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().length() - o2.getName().length();
                    }
                }
        );
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {

                    }
                }
        );
        return list;
    }
}
