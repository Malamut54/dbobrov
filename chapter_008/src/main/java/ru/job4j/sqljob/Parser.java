package ru.job4j.sqljob;


import org.jsoup.Jsoup;

import java.sql.*;

public class Parser {

    public void grab() {
        Jsoup.connect("http://www.sql.ru/forum/job");
    }

    public boolean isFirstLaunch() {
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String URL = "jdbc:postgresql://127.0.0.1:5432/sqlru";
        String user = "sqlru";
        String password = "12345678";

        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id FROM sqljob WHERE id = 1");
            System.out.println(resultSet.first());
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

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.isFirstLaunch();

    }
}