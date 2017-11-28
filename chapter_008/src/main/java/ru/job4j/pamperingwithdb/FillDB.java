package ru.job4j.pamperingwithdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Task XML XSLT JDBC optimization.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.11.2017
 */

public class FillDB {
    /**
     * Number of values.
     */
    private int number;
    /**
     * Path to sqlite database.
     */
    private String urlToDB;

    /**
     * Method fill Database.
     *
     * @param initParameter number of values and path to database.
     */
    public void fillDataBase(Init initParameter) {
        Connection conn = null;
        urlToDB = initParameter.getConnectToDB();
        number = initParameter.getNumber();
        Statement stmt;
        ResultSet rs;

        try {
            conn = DriverManager.getConnection(urlToDB);
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS test(FIELD INTEGER)");
            rs = stmt.executeQuery("SELECT * FROM test");
            if (rs.next()) {
                stmt.execute("DELETE FROM test");
            }
            conn.setAutoCommit(false);

            for (int i = 1; i <= number; i++) {
                stmt.addBatch(String.format("INSERT INTO test (FIELD) VALUES (%d)", i));
            }
            stmt.executeBatch();
            conn.rollback();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
