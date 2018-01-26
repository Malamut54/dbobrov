package ru.job4j.servlet3.logic;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.01.2018
 */


public class UserStore {
    private static final Logger log = Logger.getLogger(UserStore.class);
    private static UserStore instance;
    private DataSource dataSource = new DataSource();

    private UserStore() {
    }

    public static synchronized UserStore getInstance() {
        if (instance == null) {
            instance = new UserStore();
        }
        return instance;
    }

    /**
     * get Datasource.
     *
     * @return Datasource
     */
    private DataSource getDatasource() {
        dataSource.setPoolProperties(new Init().getProperties());
        return dataSource;
    }

    /**
     * Add User to DB.
     *
     * @param user user
     */
    public void addUser(User user) {
        String sql = "INSERT INTO servlet2 (name, login, email, create_date) VALUES (?, ?, ?, ?)";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection cn = getDatasource().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get User from DB.
     *
     * @param searchName input name
     * @return User
     */
    public User getUser(String searchName) {
        String sql = String.format("SELECT * FROM servlet2 WHERE login = '%s'", searchName);
        User result = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection cn = getDatasource().getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)
        ) {
            while (rs.next()) {
                String name = rs.getString("name");
                String login = rs.getString("login");
                String email = rs.getString("email");
                Date date = rs.getDate("create_date");
                result = new User(name, login, email, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Update user.
     *
     * @param newName new name
     * @param login   for find
     * @param email   new email
     */
    public void updateUser(String newName, String login, String email) {
        String sql = String.format("UPDATE servlet2 SET name = ?, email = ? WHERE login = ?", login);

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection cn = getDatasource().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)
        ) {
            ps.setString(1, newName);
            ps.setString(2, email);
            ps.setString(3, login);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete user from DB.
     *
     * @param login login.
     */
    public void deleteUser(String login) {
        String sql = String.format("DELETE FROM servlet2 WHERE login = '%s'", login);

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection cn = getDatasource().getConnection();
             Statement st = cn.createStatement()
        ) {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUser() {
        List<User> allUser = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection cn = getDatasource().getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM servlet2");
        ) {
            while (rs.next()) {
                String name = rs.getString("name");
                String login = rs.getString("login");
                String email = rs.getString("email");
                Date date = rs.getDate("create_date");
                allUser.add(new User(name, login, email, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUser;
    }
}
