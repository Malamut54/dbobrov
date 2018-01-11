package ru.job4j.sqljob;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class BaseTest {
    /**
     * Clean table.
     */
    @Before
    public void cleanDatabase() {

        String url = "jdbc:postgresql://127.0.0.1:5432/sqlru";
        String user = "sqlru";
        String password = "12345678";
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.execute("DELETE FROM sqljob");
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

    /**
     * Test empty DB.
     */
    @Test
    public void checkEmptyDB() {
        String url = "jdbc:postgresql://127.0.0.1:5432/sqlru";
        String user = "sqlru";
        String password = "12345678";
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sqljob");
            assertThat(resultSet.next(), is(false));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Test non empty DB.
     */
    @Test
    public void checkNoEmptyDB() {
        String url = "jdbc:postgresql://127.0.0.1:5432/sqlru";
        String user = "sqlru";
        String password = "12345678";
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.execute("INSERT INTO sqljob (author, title, description, create_date, url) VALUES ('aaa', 'aaa', 'aaa', '2017-08-04', 'aaa');");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sqljob");
            assertThat(resultSet.next(), is(true));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
