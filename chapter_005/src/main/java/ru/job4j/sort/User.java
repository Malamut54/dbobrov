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

    @Override
    public String toString() {
        return "age: " + getAge();
    }

    @Override
    public int compareTo(User user) {
        return this.age - user.age;
    }
}
