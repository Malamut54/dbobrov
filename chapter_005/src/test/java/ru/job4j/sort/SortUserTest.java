package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        String expected = "[Name: Sergey Age 1, Name: Dima Age 4, Name: Andrey Age 10]";
        String result = sort.sort(list).toString();
        assertThat(result, is(expected));
    }

    /**
     * Test sort name length.
     */
    @Test
    public void sortUserByNameLength() {
        SortUser sort = new SortUser();
        ArrayList<User> list = new ArrayList<User>();
        list.addAll(
                Arrays.asList(
                        new User("Dima", 14),
                        new User("Sergey", 1),
                        new User("Bob", 10)
                )
        );
        String expected = "[Name: Bob Age 10, Name: Dima Age 14, Name: Sergey Age 1]";
        String result = sort.sortNameLength(list).toString();
        assertThat(result, is(expected));
    }

    /**
     * Test sort by two fields.
     */
    @Test
    public void sortUserByNameLengthAndAge() {
        SortUser sort = new SortUser();
        ArrayList<User> list = new ArrayList<User>();
        list.addAll(
                Arrays.asList(
                        new User("Bob", 5),
                        new User("Serg", 10),
                        new User("Buch", 6),
                        new User("Pop", 6)
                )
        );
        String expected = "[Name: Bob Age 5, Name: Pop Age 6, Name: Buch Age 6, Name: Serg Age 10]";
        String result = sort.sortByAllFields(list).toString();
        assertThat(result, is(expected));
    }

}