package ru.job4j.trackerdb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * * Task Tracker DataBase.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 01.12.2017
 */

public class ConnectDB {
    /**
     * Path to DB.
     */
    private String urlToDB;
    /**
     * DB user.
     */
    private String user;
    /**
     * DB password.
     */
    private String password;

    /**
     * Default constructor.
     */
    public ConnectDB() {
        connectAndInitialDB();
    }

    /**
     * Getter for path to DB.
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
     * Get credentials for DB from config.properties.
     */
    private void getCredentials() {

        Properties properties = new Properties();
        try {
            File file = new File("config.properties");
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlToDB = properties.getProperty("Database.DataURL");
        user = properties.getProperty("Database.Prop.user");
        password = properties.getProperty("Database.Prop.password");
    }

    /**
     * Create table if it not exist.
     */
    private void connectAndInitialDB() {
        this.getCredentials();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(urlToDB, user, password);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS item(id serial primary key,"
                    + " name VARCHAR(50), description TEXT)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
