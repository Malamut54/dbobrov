package ru.job4j.sqljob.db;

import ru.job4j.sqljob.Init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.12.2017
 */

public class Base {
    Init init = new Init();

    public boolean isFirstLaunch() {
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String URL = init.getUrlToDB();
        String user = init.getUser();
        String password = init.getPassword();

        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id FROM sqljob WHERE id = 1");
            result = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
