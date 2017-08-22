package ru.job4j.map;

import org.junit.Test;

/**
 * Task map.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 04.08.2017
 */

public class UserTest {
    /**
     * Test.
     */
    @Test
    public void testEquals() {
        User andrey = new User("Andrey");
        User andreyDuplicate = new User("Andrey");
        System.out.println(andrey.equals(andreyDuplicate));

    }
}
