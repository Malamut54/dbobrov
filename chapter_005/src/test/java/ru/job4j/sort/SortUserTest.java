package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task tracker.
 */
public class SortUserTest {
    /**
     * Test sort List.
     */
    @Test
    public void sortsUserFromListToSet() {
        SortUser sort = new SortUser();
        ArrayList<User> list = new ArrayList<User>();
        User dima = new User("Dima", 4);
        User sergey = new User("Sergey", 1);
        User andrey = new User("Andrey", 10);
        list.add(dima);
        list.add(sergey);
        list.add(andrey);
        String expected = "[age: 1, age: 4, age: 10]";
        String result = sort.sort(list).toString();
        assertThat(result, is(expected));
    }

}