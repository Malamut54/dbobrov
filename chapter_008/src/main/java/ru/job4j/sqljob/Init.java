package ru.job4j.sqljob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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

    public Init() {
        this.getCredentials();
    }

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
        Properties properties = new Properties();
        try {
            File file = new File("sqljob.properties");
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        periodicity = Integer.parseInt(properties.getProperty("PeriodicityValue"));
        urlToDB = properties.getProperty("Database.DataURL");
        user = properties.getProperty("Database.Prop.user");
        password = properties.getProperty("Database.Prop.password");
    }

}
