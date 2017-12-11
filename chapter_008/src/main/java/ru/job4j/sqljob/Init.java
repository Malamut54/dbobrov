package ru.job4j.sqljob;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class Init {
    private int periodicity;
    private String urlToDB;
    private String user;
    private String password;

    public int getPeriodicity() {
        return periodicity;
    }

    public String getUrlToDB() {
        return urlToDB;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void getCredentials() {
        FileReader reader = null;
        try {
            reader = new FileReader("sqljob.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        periodicity = Integer.parseInt(properties.getProperty("PeriodicityValue"));
        urlToDB = properties.getProperty("Database.DataURL");
        user = properties.getProperty("Database.Prop.user");
        password = properties.getProperty("Database.Prop.password");
    }

}
