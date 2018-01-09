package ru.job4j.sqljob.db;

import ru.job4j.sqljob.Init;
import ru.job4j.sqljob.Vacancy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;


/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.12.2017
 */

public class Base {
    Init init = new Init();
    String URL = init.getUrlToDB();
    String user = init.getUser();
    String password = init.getPassword();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public boolean isFirstLaunch() {
        boolean result = false;
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id FROM sqljob WHERE id = 1");
            result = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public void addVacancyToDb(Vacancy vacancy) {
        java.sql.Date date = new java.sql.Date(vacancy.getDate().getTime());
        System.out.println(date);
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            statement.execute(String.format("INSERT INTO sqljob (author, title, description, create_date, url)" +
                    "VALUES ('%s', '%s', '%s', '%s', '%s')", vacancy.getAuthor(), vacancy.getTitle(), vacancy.getDescription(), date.toString(), vacancy.getLink()));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
