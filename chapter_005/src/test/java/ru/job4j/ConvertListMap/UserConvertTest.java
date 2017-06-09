package ru.job4j.ConvertListMap;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Test UserConvert.
 */
public class UserConvertTest {
    /**
     * Test converting User from List to HashMap.
     */
    @Test
    public void testConvertListToHashMap() {
        User user1 = new User(1, "Dmitriy", "Saint-Petersburg");
        User user2 = new User(2, "Andrey", "Moscow");
        UserConvert convert = new UserConvert();

        HashMap expected = new HashMap();
        expected.put(1, user1);
        expected.put(2, user2);

        List<User> user = new ArrayList<User>();
        user.add(user1);
        user.add(user2);

        HashMap result = convert.process(user);
        assertThat(result, is(expected));
    }
}
