package ru.job4j.servlet2;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 15.01.2018
 */


public class Init {
    private static final Logger log = Logger.getLogger(Init.class);
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
        try {
            File file = new File("servlet2.properties");
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlToDB = properties.getProperty("Database.DataURL");
        user = properties.getProperty("Database.Prop.user");
        password = properties.getProperty("Database.Prop.password");
    }
}
