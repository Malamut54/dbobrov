package ru.job4j.map;

import java.util.Calendar;

/**
 * Task Map.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 04.08.2017
 */

public class User {
    /**
     * Name.
     */
    String name;
    /**
     * Number of children.
     */
    int children;
    /**
     * Date of Birthday
     */
    Calendar birthday;

    /**
     * Default constructor.
     *
     * @param name     First Name.
     * @param children Number of children
     */
    public User(String name, int children) {
        this.name = name;
        this.children = children;
    }
}
