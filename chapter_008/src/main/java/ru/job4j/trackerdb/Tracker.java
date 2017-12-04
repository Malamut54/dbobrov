package ru.job4j.trackerdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Main class.
 */
public class Tracker {
    /**
     * Connect to DB.
     *
     * @return Connection.
     */
    private Connection connectToDB() {
        Connection connection = null;
        ConnectDB conn = new ConnectDB();
        try {
            return DriverManager.getConnection(conn.getUrlToDB(), conn.getUser(), conn.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Ad item to DB.
     * @param item item
     */
    public void add(Item item) {
        Statement statement = null;
        Connection connection = this.connectToDB();
        try {
            statement = connection.createStatement();
            statement.execute(String.format("INSERT INTO item(name, description) VALUES ('%s', '%s')", item.getName(), item.getDesc()));
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
     * Search for an item by ID.
     *
     * @param id input id.
     * @return Item.
     */
    public Item findById(Integer id) {
        Item result = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = this.connectToDB();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(String.format("SELECT id, name, description FROM item WHERE id = %d", id));
            while (resultSet.next()) {
                result = new Item(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"));
            }
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
        return result;
    }

    /**
     * Return all item.
     *
     * @return List containing all tickets.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<Item>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = this.connectToDB();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id, name, description FROM item");
            while (resultSet.next()) {
                result.add(new Item(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description")));
            }
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
        return result;
    }

    /**
     * Find Item by name.
     *
     * @param name input name.
     * @return Item.
     */
    public ArrayList<Item> findByName(String name) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = this.connectToDB();
        ArrayList<Item> result = new ArrayList<Item>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(String.format("SELECT id, name, description FROM item WHERE name = '%s'", name));
            while (resultSet.next()) {
                result.add(new Item(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description")));
            }
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
        return result;

    }

    /**
     * Delete item by ID.
     *
     * @param item item
     */
    public void delete(Item item) {
        Statement statement = null;
        Connection connection = this.connectToDB();

        try {
            statement = connection.createStatement();
            statement.execute(String.format("DELETE FROM item WHERE id = %d", item.getId()));
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
     * Update concrete item.
     *
     * @param item input item for update.
     */
    public void upddate(Item item) {
        Connection connection = this.connectToDB();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.execute(String.format("UPDATE item SET name = '%s', description = '%s' WHERE id = %d", item.getName(), item.getDesc(), item.getId()));
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