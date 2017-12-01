package ru.job4j.trackerDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class Tracker {


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
     * Add Item to array.
     *
     * @return Item.
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
     * Search for an ticket by ID.
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
            resultSet = statement.executeQuery(String.format("SELECT name, description FROM item WHERE id = %d", id));
            while (resultSet.next()) {
                result = new Item(resultSet.getString("name"), resultSet.getString("description"));
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
     * Return all tickets.
     *
     * @return array conaining all tickets.
     */
    public List<Item> findAll() {
        ArrayList<Item> result = new ArrayList<Item>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = this.connectToDB();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT name, description FROM item");
            while (resultSet.next()) {
                result.add(new Item(resultSet.getString("name"), resultSet.getString("description")));
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

//    /**
//     * Find Item by name.
//     *
//     * @param name input name.
//     * @return Item.
//     */
//    public ArrayList<Item> findByName(String name) {
//        ArrayList<Item> result = new ArrayList<Item>();
//        for (Item item : this.items) {
//            if (name.equals(item.getName())) {
//                result.add(item);
//            }
//        }
//        return result;
//
//    }

//    /**
//     * Delete Item from array.
//     *
//     * @param item input item for delete.
//     */
//    public void delete(Item item) {
//        for (int i = 0; i < this.items.size(); i++) {
//            if (this.items.get(i).getId().equals(item.getId())) {
//                this.items.remove(i);
//                break;
//            }
//            }
//        }
//
//
//    /**
//     * Update concrete item.
//     *
//     * @param item input item for update.
//     */
//    public void upddate(Item item) {
//        for (int i = 0; i < this.items.size(); i++) {
//            if (this.items.get(i).getId().equals(item.getId())) {
//                this.items.set(i, item);
//                break;
//            }
//        }
//    }

//    /**
//     * Generate unique id for each Item.
//     *
//     * @return generate id.
//     */
//    String generateId() {
//        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
//    }
}