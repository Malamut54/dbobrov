package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 04.08.2017
 */

public class UserTest {
    /**
     * Test.
     */
    @Test
    public void whenCreateUserWithoutOverride() {
        User first = new User("Bob", 2);
        User second = new User("Bob", 2);

        Map<User, Object> map = new HashMap<>();

        map.put(first, "first");
        map.put(second, "second");

        System.out.println(map);
    }
}
