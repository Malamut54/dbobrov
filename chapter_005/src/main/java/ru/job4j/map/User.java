package ru.job4j.map;

/**
 * Task Map.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 04.08.2017
 */

public class User {
    /**
     * Field name.
     */
    private String name;

    /**
     * Constrcutor.
     *
     * @param name input name.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Override equals.
     * @param o input Object User.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null;
    }

    /**
     * Override hashCode.
     * @return int hashcode.
     */
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
