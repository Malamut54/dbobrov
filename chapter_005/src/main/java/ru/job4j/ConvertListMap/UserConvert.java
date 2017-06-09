package ru.job4j.ConvertListMap;


import java.util.HashMap;
import java.util.List;


/**
 * Created by kvazimoda on 09.06.2017.
 */
public class UserConvert {
    HashMap<Integer, User> listUsers = new HashMap<Integer, User>();

    public HashMap<Integer, User> process(List<User> list) {
        return this.listUsers;
    }
}
