package ru.job4j.pamperingwithdb;

/**
 * Task XML XSLT JDBC optimization.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.11.2017
 */

public class Init {
    private int numberOfValues;
    private String connectToDB;

    public int getNumberOfValues() {
        return numberOfValues;
    }

    public void setNumberOfValues(int numberOfValues) {
        this.numberOfValues = numberOfValues;
    }

    public String getConnectToDB() {
        return connectToDB;
    }

    public void setConnectToDB(String connectToDB) {
        this.connectToDB = connectToDB;
    }
}
