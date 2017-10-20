package ru.job4j.userstore;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Task User storage.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 20.10.2017
 */

public class UserStorageTest {
    /**
     * Test add and true.
     */
    @Test
    public void addUserToStorageTrue() {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 100);
        User two = new User(2, 100);
        userStorage.add(one);
        boolean result = userStorage.add(two);
        assertThat(result, is(true));
    }

    /**
     * Test add and false.
     */
    @Test
    public void addUserToStorageFalse() {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 100);
        User two = new User(1, 100);
        userStorage.add(one);
        boolean result = userStorage.add(two);
        assertThat(result, is(false));
    }

    /**
     * Test delete and true.
     */
    @Test
    public void deleteUserFromStorageTrue() {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 100);
        userStorage.add(one);
        boolean result = userStorage.delete(one);
        assertThat(result, is(true));
    }

    /**
     * Test delete and false.
     */
    @Test
    public void deleteUserFromStorageFalse() {
        UserStorage userStorage = new UserStorage();
        boolean result = userStorage.delete(new User(1, 100));
        assertThat(result, is(false));
    }

    /**
     * Test update and true.
     */
    @Test
    public void updateUserFromStorageTrue() {
        UserStorage userStorage = new UserStorage();
        userStorage.add(new User(1, 100));
        Boolean result = userStorage.update(new User(1, 100), 200);
        assertThat(result, is(true));
    }

    /**
     * Test update and false.
     */
    @Test
    public void updateUserFromStorageFalse() {
        UserStorage userStorage = new UserStorage();
        userStorage.add(new User(1, 100));
        Boolean result = userStorage.update(new User(2, 100), 200);
        assertThat(result, is(false));
    }

    /**
     * Test transfer and true.
     */
    @Test
    public void transferFromOneToAnotherTrue() {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 100);
        User two = new User(2, 100);
        userStorage.add(one);
        userStorage.add(two);
        Boolean result = userStorage.transfer(one, two, 50);
        assertThat(result, is(true));
    }

    /**
     * Test transfer and false.
     */
    @Test
    public void transferFromOneToAnotherFalse() {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 100);
        User two = new User(2, 100);
        userStorage.add(one);
        userStorage.add(two);
        Boolean result = userStorage.transfer(one, two, 200);
        assertThat(result, is(false));
    }

}
