package ru.job4j.sqljob.db;

import ru.job4j.sqljob.Init;
import ru.job4j.sqljob.Vacancy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    PreparedStatement preparedStatement = null;

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
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void addVacancyToDb(Vacancy vacancy) {
        try {
            connection = DriverManager.getConnection(URL, user, password);
            preparedStatement = connection.prepareStatement("INSERT INTO sqljob (author, title, description, create_date, url) VALUES " +
                    "(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, vacancy.getAuthor());
            preparedStatement.setString(2, vacancy.getTitle());
            preparedStatement.setString(3, vacancy.getDescription());
            preparedStatement.setDate(4, new java.sql.Date(vacancy.getDate().getTime()));
            preparedStatement.setString(5, vacancy.getLink());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
