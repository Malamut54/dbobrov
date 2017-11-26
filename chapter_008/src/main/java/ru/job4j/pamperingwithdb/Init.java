package ru.job4j.pamperingwithdb;

/**
 * Task XML XSLT JDBC optimization.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.11.2017
 */

public class Init {
    /**
     * Number of values.
     */
    private int number;
    /**
     * Path to sqlite database.
     */
    private String connectToDB;

    /**
     * Getter for number.
     *
     * @return int.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Setter for number.
     *
     * @param number number.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Getter for path to DB.
     * @return String.
     */
    public String getConnectToDB() {
        return connectToDB;
    }

    /**
     * Setter for path to DB.
     * @param connectToDB path.
     */
    public void setConnectToDB(String connectToDB) {
        this.connectToDB = connectToDB;
    }
}
