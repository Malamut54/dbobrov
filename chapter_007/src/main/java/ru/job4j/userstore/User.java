package ru.job4j.userstore;

/**
 * Task User storage.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 20.10.2017
 */

public class User {
    /**
     * id User.
     */
    private int id;
    /**
     * amount user.
     */
    private int amount;

    /**
     * Constructor.
     *
     * @param id     id.
     * @param amount amount.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Getter for id.
     *
     * @return int.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for amount.
     *
     * @return int.
     */
    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
