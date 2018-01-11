package ru.job4j.sqljob;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class Init {
    /**
     * Star frequency.
     */
    private int periodicity;
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
     * Getter for startup frequency.
     *
     * @return Integer
     */
    int getPeriodicity() {
        return periodicity;
    }

    /**
     * Getter for URL.
     * @return String
     */
    public String getUrlToDB() {
        return urlToDB;
    }

    /**
     * Getter for user.
     * @return String
     */
    public String getUser() {
        return user;
    }

    /**
     * Getter for password.
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
            File file = new File("sqljob.properties");
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        periodicity = Integer.parseInt(properties.getProperty("PeriodicityValue"));
        urlToDB = properties.getProperty("Database.DataURL");
        user = properties.getProperty("Database.Prop.user");
        password = properties.getProperty("Database.Prop.password");
    }

}
