package ru.job4j.pamperingwithdb;

import java.sql.Connection;
import java.sql.Driver;
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
    private int numOfValue;
    private String urlToDB;

    public void fillDataBase(Init initParametr) {
        Connection conn = null;
        urlToDB = initParametr.getConnectToDB();
        Statement stmt;
        ResultSet rs;

        try {
            conn = DriverManager.getConnection(urlToDB);
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS test(id INTEGER);");
            rs = stmt.executeQuery("SELECT * FROM test");
//            stmt.execute("INSERT INTO test (id) VALUES (1)");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }

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
