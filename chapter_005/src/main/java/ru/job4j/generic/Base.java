package ru.job4j.generic;

/**
 * Task realization Store.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.07.2017
 */

public abstract class Base {
    /**
     * Private fields.
     */
    private String id;

    /**
     * Getter for Id.
     *
     * @return String.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter for Id.
     *
     * @param id String.
     */
    public void setId(String id) {
        this.id = id;
    }
}
