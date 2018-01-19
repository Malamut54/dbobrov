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
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 15.01.2018
 */


public class UserStore {
    private static final Logger log = Logger.getLogger(UserStore.class);

    private static final UserStore instance = new UserStore();

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

    ;

    /**
     * Create Object.
     *
     * @return return Object
     */
    public static UserStore getInstance() {
        return instance;
    }

    public boolean addUser(User user) {
        String sql = "INSERT INTO servlet2 (name, login, email, create_date) VALUES ?, ?, ?, ?";
        boolean result = false;
        try (Connection cn = DriverManager.getConnection(url, userDB, password);
             PreparedStatement ps = cn.prepareStatement(sql);
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setDate(4, new Date(System.currentTimeMillis()));
            result = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User getUser(String searchName) {
        String sql = String.format("SELECT * FROM servlet2 WHERE name = %s", searchName);
        User result = null;
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

    public boolean updateUser(String currentName, String newName, String login, String email) {
        boolean result = false;
        String sql = String.format("UPDATE servlet2 SET name = ? , login = ?, email = ? WHERE name = %s", currentName);
        try (Connection cn = DriverManager.getConnection(url, userDB, password);
             PreparedStatement ps = cn.prepareStatement(sql);
        ) {
            ps.setString(1, newName);
            ps.setString(2, login);
            ps.setString(3, email);
            result = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteUser(String login) {
        boolean result = false;
        String sql = String.format("DELETE FROM servlet2 WHERE login = %s", login);
        try (Connection cn = DriverManager.getConnection(url, userDB, password);
             Statement st = cn.createStatement();

        ) {
            result = st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
