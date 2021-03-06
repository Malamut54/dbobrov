package ru.job4j.bank;

/**
 * Final task collection.
 */
public class User {
    /**
     * Private fields.
     */
    private String name;
    /**
     * Private fields.
     */
    private String passport;

    /**
     * Constructor for user.
     *
     * @param name     name.
     * @param passport passport.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
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

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }
}
