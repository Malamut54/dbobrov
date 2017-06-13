package ru.job4j.sort;

/**
 * Task Sort.
 */
public class User implements Comparable<User> {
    /**
     * Private fields.
     */
    private String name;
    /**
     * Private fields.
     */
    private int age;

    /**
     * Constructor for users.
     *
     * @param name String.
     * @param age  int.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter for age.
     *
     * @return int age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for name.
     *
     * @return String name.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s Age %s", getName(), getAge());
    }

    @Override
    public int compareTo(User user) {
        return this.age - user.age;
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

        if (age != user.age) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
