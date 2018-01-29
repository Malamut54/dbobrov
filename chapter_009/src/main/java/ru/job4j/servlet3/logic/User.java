package ru.job4j.servlet3.logic;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Task CRUD + HTML.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.01.2018
 */


public class User {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(User.class);
    /**
     * Name.
     */
    private String name;
    /**
     * Login.
     */
    private String login;
    /**
     * Email.
     */
    private String email;
    /**
     * Create date.
     */
    private Date createDate;

    /**
     * Create user.
     *
     * @param name  user name
     * @param login user login
     * @param email user email
     */
    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = new Date();
    }

    /**
     * Constructor for getUser.
     *
     * @param name       user name
     * @param login      user login
     * @param email      user email
     * @param createDate user create date
     */
    User(String name, String login, String email, Date createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    /**
     * Getter.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter.
     *
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Getter.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter.
     *
     * @return date
     */
    public Date getCreateDate() {
        return createDate;
    }
}
