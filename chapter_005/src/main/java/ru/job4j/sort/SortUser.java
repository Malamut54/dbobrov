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

    /**
     * Method sorts user by all fields.
     *
     * @param list list.
     * @return list.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result = o1.getName().length() - o2.getName().length();
                        if (result == 0) {
                            result = o1.getAge() - o2.getAge();
                        }
                        return result;
                    }
                }
        );
        return list;
    }
}
