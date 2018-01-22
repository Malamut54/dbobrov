package ru.job4j.servlet2;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

/**
 * Task Crud servlet.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 22.01.2018
 */


public class UserStore {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(UserStore.class);
    /**
     * For single Tone.
     */
    private static final UserStore INSTANCE = new UserStore();

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
    private String userDB = init.getUser();
    /**
     * DB user pass.
     */
    private String password = init.getPassword();

    /**
     * Hide default constructor for SingleTone.
     */
    private UserStore() {
    }

    /**
     * Create Object.
     *
     * @return return Object
     */
    public static UserStore getInstance() {
        return INSTANCE;
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
        try (Connection cn = DriverManager.getConnection(url, userDB, password);
             PreparedStatement ps = cn.prepareStatement(sql);
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

        try (Connection cn = DriverManager.getConnection(url, userDB, password);
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
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

        try (Connection cn = DriverManager.getConnection(url, userDB, password);
             PreparedStatement ps = cn.prepareStatement(sql);
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

        try (Connection cn = DriverManager.getConnection(url, userDB, password);
             Statement st = cn.createStatement();

        ) {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
