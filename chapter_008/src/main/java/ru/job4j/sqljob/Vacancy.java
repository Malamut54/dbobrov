package ru.job4j.sqljob;

import java.util.Date;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 18.12.2017
 */

public class Vacancy {
    private Date date;
    private String link;
    private String author;
    private String title;
    private String description;

    public Vacancy(Date date, String link, String author, String title, String description) {
        this.date = date;
        this.link = link;
        this.author = author;
        this.title = title;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public String getLink() {
        return link;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "date=" + date +
                ", link='" + link + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
