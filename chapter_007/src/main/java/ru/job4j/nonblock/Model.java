package ru.job4j.nonblock;

/**
 * Task non blocking cache.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 08.11.2017
 */

public class Model {
    /**
     * Version of model.
     */
    private volatile int version;
    /**
     * Name.
     */
    private String name;

    /**
     * Constructor.
     * @param name name.
     */
    public Model(String name) {
        this.version = 0;
        this.name = name;
    }

    /**
     * Getter for version.
     *
     * @return version.
     */
    public int getVersion() {
        return version;
    }

    /**
     * Increment version.
     */
    public void increment() {
        this.version++;
    }


}
