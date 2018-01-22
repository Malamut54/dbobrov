package ru.job4j.servlet2;

import org.apache.log4j.Logger;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Task Crud servlet.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 22.01.2018
 */


public class Init {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Init.class);
    /**
     * URL to DB.
     */
    private String urlToDB;
    /**
     * User for DB.
     */
    private String user;

    /**
     * Password to DB.
     */
    private String password;

    /**
     * Constructor.
     */
    public Init() {
        this.getCredentials();
    }

    /**
     * Getter for URL.
     *
     * @return String
     */
    public String getUrlToDB() {
        return urlToDB;
    }

    /**
     * Getter for user.
     *
     * @return String
     */
    public String getUser() {
        return user;
    }

    /**
     * Getter for password.
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get credentials from property file.
     */
    private void getCredentials() {
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("servlet.properties");

        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        urlToDB = properties.getProperty("Database.DataURL");
        user = properties.getProperty("Database.Prop.user");
        password = properties.getProperty("Database.Prop.password");
    }
}
