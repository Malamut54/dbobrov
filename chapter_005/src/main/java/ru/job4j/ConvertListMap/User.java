package ru.job4j.ConvertListMap;

/**
 * Task user convert.
 */

/**
 * Class User.
 */
public class User {
    /**
     * Private fields.
     */
    private Integer id;
    /**
     * Private fields.
     */
    private String name;
    /**
     * Private fields.
     */
    private String city;

    /**
     * Constructor.
     *
     * @param id   Integer.
     * @param name String.
     * @param city String
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Getter for ID.
     *
     * @return Integer ID.
     */
    public Integer getId() {
        return id;
    }
}
