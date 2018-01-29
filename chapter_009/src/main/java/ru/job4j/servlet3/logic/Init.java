package ru.job4j.servlet3.logic;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Task CRUD + HTML.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.01.2018
 */


public class Init {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Init.class);
    /**
     * URL to DB.
     */
    private String urlToDB;
    /**
     * User for DB.
     */
    private String user;
    /**
     * Password to DB.
     */
    private String password;
    /**
     * Driver name.
     */
    private String drvName;

    /**
     * Constructor.
     */
    Init() {
        this.getCredentials();
    }

    /**
     * Get credentials from property file.
     */
    private void getCredentials() {
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("servlet.properties");

        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        urlToDB = properties.getProperty("Database.DataURL");
        user = properties.getProperty("Database.Prop.user");
        password = properties.getProperty("Database.Prop.password");
        drvName = properties.getProperty("Database.Driver.name");

    }

    /**
     * Get Properties for DataSource.
     *
     * @return Properties.
     */
    PoolProperties getProperties() {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setUrl(urlToDB);
        poolProperties.setDriverClassName(drvName);
        poolProperties.setUsername(user);
        poolProperties.setPassword(password);
        poolProperties.setJmxEnabled(true);
        poolProperties.setTestWhileIdle(false);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("SELECT 1");
        poolProperties.setTestOnReturn(false);
        poolProperties.setValidationInterval(30000);
        poolProperties.setTimeBetweenEvictionRunsMillis(30000);
        poolProperties.setMaxActive(100);
        poolProperties.setInitialSize(10);
        poolProperties.setMaxWait(10000);
        poolProperties.setRemoveAbandonedTimeout(60);
        poolProperties.setMinEvictableIdleTimeMillis(30000);
        poolProperties.setMinIdle(10);
        poolProperties.setLogAbandoned(true);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                        + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        return poolProperties;
    }
}
