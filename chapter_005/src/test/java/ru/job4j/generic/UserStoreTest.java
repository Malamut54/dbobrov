package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Task realization Store.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.07.2017
 */

public class UserStoreTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddUserToUserStore() {
        User user = new User();
        user.setId("11");
        UserStore store = new UserStore();
        store.add(user);
        User result = (User) store.get("11");
        assertThat(result, is(user));
    }

    /**
     * Test update.
     */
    @Test
    public void whenUpdateExistValueUser() {
        User exist = new User();
        exist.setId("1");
        User expected = new User();
        expected.setId("2");
        UserStore store = new UserStore();
        store.add(exist);
        store.update(exist, expected);
        User result = (User) store.get("2");
        assertThat(result, is(expected));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteUserFromStore() {
        User user = new User();
        user.setId("1");
        UserStore store = new UserStore();
        store.add(user);
        store.delete(user);
        assertNull(store.get("1"));
    }


}
