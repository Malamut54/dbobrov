package ru.job4j.convertlistmap;

import java.util.HashMap;
import java.util.List;

/**
 * Task user convert.
 */
public class UserConvert {
    /**
     * Class UserConvert.
     */

    /**
     * Method covert List to HashMap.
     *
     * @param list contains User.
     * @return Hasmap User with ID.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> listUsers = new HashMap<Integer, User>();
        for (User user : list) {
            listUsers.put(user.getId(), user);
        }
        return listUsers;
    }

}
