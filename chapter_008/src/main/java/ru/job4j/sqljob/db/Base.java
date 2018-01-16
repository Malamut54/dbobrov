package ru.job4j.sqljob.db;

import ru.job4j.sqljob.Init;
import ru.job4j.sqljob.Vacancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class Base {
    /**
     * Object for get credentials.
     */
    private Init init = new Init();
    /**
     * URL to DB.
     */
    private String url = init.getUrlToDB();
    /**
     * DB user.
     */
    private String user = init.getUser();
    /**
     * DB user pass.
     */
    private String password = init.getPassword();
    /**
     * Connection.
     */
    private Connection connection = null;
    /**
     * ResultSet.
     */
    private ResultSet resultSet = null;
    /**
     * PreparedStatement.
     */
    private PreparedStatement preparedStatement = null;

    /**
     * Check first start app.
     *
     * @return boolean
     */
    public boolean isFirstLaunch() {
        boolean result = false;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT id FROM sqljob WHERE id = 1");

        ) {
            result = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Add vacancy to DB.
     *
     * @param vacancy vacancy.
     */
    public void addVacancyToDb(Vacancy vacancy) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sqljob (author, title, description, create_date, url) VALUES "
                    + "(?, ?, ?, ?, ?)");

        ) {
            preparedStatement.setString(1, vacancy.getAuthor());
            preparedStatement.setString(2, vacancy.getTitle());
            preparedStatement.setString(3, vacancy.getDescription());
            preparedStatement.setDate(4, new java.sql.Date(vacancy.getDate().getTime()));
            preparedStatement.setString(5, vacancy.getLink());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            connection = DriverManager.getConnection(url, user, password);
//            preparedStatement = connection.prepareStatement("INSERT INTO sqljob (author, title, description, create_date, url) VALUES "
//                    + "(?, ?, ?, ?, ?)");
//            preparedStatement.setString(1, vacancy.getAuthor());
//            preparedStatement.setString(2, vacancy.getTitle());
//            preparedStatement.setString(3, vacancy.getDescription());
//            preparedStatement.setDate(4, new java.sql.Date(vacancy.getDate().getTime()));
//            preparedStatement.setString(5, vacancy.getLink());
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//                preparedStatement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * Check duplicate vacancy.
     *
     * @param vacancy vacancy
     * @return boolean
     */
    public boolean checkDuplicate(Vacancy vacancy) {
        boolean result = false;
        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement("SELECT author, title FROM sqljob WHERE author = ? AND title = ?");
            preparedStatement.setString(1, vacancy.getAuthor());
            preparedStatement.setString(2, vacancy.getTitle());
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
