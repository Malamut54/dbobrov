package ru.job4j.trackerDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 01.12.2017
 */

public class ConnectDB {
    private String urlToDB;
    private String user;
    private String password;

    public ConnectDB() {
        connectAndInitialDB();
    }

    public String getUrlToDB() {
        return urlToDB;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    private void getCredentials() {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlToDB = properties.getProperty("Database.DataURL");
        user = properties.getProperty("Database.Prop.user");
        password = properties.getProperty("Database.Prop.password");
    }

    private void connectAndInitialDB() {
        this.getCredentials();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(urlToDB, user, password);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS item(id serial primary key," +
                    " name VARCHAR(50), description TEXT)");

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
