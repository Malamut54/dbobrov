package ru.job4j.sqljob;
import java.util.Date;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class Vacancy {
    /**
     * Vacancy date.
     */
    private Date date;
    /**
     * Vacancy URL.
     */
    private String link;
    /**
     * Vacancy author.
     */
    private String author;
    /**
     * Vacancy title.
     */
    private String title;
    /**
     * Vacancy Description.
     */
    private String description;

    /**
     * Constructor.
     *
     * @param date        Vacancy
     * @param link        Vacancy
     * @param author      Vacancy
     * @param title       Vacancy
     * @param description Vacancy
     */
    Vacancy(Date date, String link, String author, String title, String description) {
        this.date = date;
        this.link = link;
        this.author = author;
        this.title = title;
        this.description = description;
    }

    /**
     * Getter for date.
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Getter for URL.
     * @return String
     */
    public String getLink() {
        return link;
    }

    /**
     * Getter for Author.
     * @return String
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Getter for Title.
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for description.
     * @return String
     */
    public String getDescription() {
        return description;
    }
}
