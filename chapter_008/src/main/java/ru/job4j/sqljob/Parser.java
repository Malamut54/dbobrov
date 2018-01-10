package ru.job4j.sqljob;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import ru.job4j.sqljob.date.DateCheck;
import ru.job4j.sqljob.db.Base;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Parser {
    private String author;
    private String title;
    private String url;
    private String description;
    private DateCheck dateCheck = new DateCheck();
    private Base base = new Base();
    private int numPage = 1;
    private Calendar borderDate = Calendar.getInstance();
    private Calendar dateVacancy = Calendar.getInstance();
    private Calendar dateVacancyOnPage = Calendar.getInstance();
    private int year = borderDate.get(Calendar.YEAR);
    private static final Logger logger = Logger.getLogger(Parser.class);

    public void grabLinkVacation() {
        BasicConfigurator.configure();
        logger.setLevel(Level.INFO);
        boolean nextPage = true;
        logger.info("Start parse sql.ru");

        while (nextPage) {
            try {
                Document document = Jsoup.connect(String.format("http://www.sql.ru/forum/job/%d", numPage++)).get();
                Elements elements = document.select("td.altcol");
                Elements tmpelements = new Elements();
                for (int i = 0; i < 6; i++) {
                    elements.remove(0);
                }
                for (Element element : elements) {
                    if (element.siblingIndex() == 11) {
                        tmpelements.add(element);
                    }
                }
                for (Element tmpelement : tmpelements) {
                    if (checkDateOnPage(tmpelement.text())) {
                        String link = tmpelement.parent().getElementsByAttributeValue("class", "postslisttopic").get(0).childNode(1).attributes().get("href");
                        if (checkDateVacancy(link)) {
                            checkOnlyJavaVacancy(link);
                        }
                    } else {
                        numPage = 1;
                        nextPage = false;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("Finish parse sql.ru");
    }

    public void checkOnlyJavaVacancy(String link) {
        link.toLowerCase();
        if (link.contains("java") && !link.contains("javascript") && !link.contains("java-script")) {
            this.url = link;
            createValidVacancy(link);
        }

    }

    public boolean checkDateVacancy(String link) {
        //first make check that this vacancy doesnt contain in db
        try {
            Document document = Jsoup.connect(link).userAgent("Mozilla").get();
            Elements elements = document.select("td.msgFooter");

            String date = elements.first().childNode(0).toString().substring(1, 10);
            dateVacancy = dateCheck.convertFromString(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateVacancy.after(borderDate);
    }

    public boolean checkDateOnPage(String str) {
        this.borderDate.set(Calendar.MILLISECOND, 0);

        if (!base.isFirstLaunch()) {
            //only for test
            this.borderDate.set(2017, 0, 1, 0, 0);
//            borderDate.set(year, 0, 1, 0, 0);
//            dateCheck.lastStartDate();
        } else {
            this.borderDate = dateCheck.lastStartDate();
        }
        dateVacancyOnPage = dateCheck.convertFromString(str);
        return dateVacancyOnPage.after(borderDate);
    }

    public void createValidVacancy(String link) {
        try {
            Document document = Jsoup.connect(link).userAgent("Mozilla").get();
            Elements nameAuthor = document.getElementsByAttributeValue("class", "msgBody");
            this.description = document.select("td.msgBody").get(1).ownText();
            this.author = nameAuthor.get(0).childNode(1).childNode(0).toString();
            this.title = parseTitle(document.select("title").get(0).ownText());
        } catch (IOException e) {
            e.printStackTrace();
        }

        base.addVacancyToDb(new Vacancy(this.dateVacancy.getTime(), this.url, this.author, this.title, this.description));
        logger.info(String.format("Add vacancy %s to DB", this.title));
    }

    private String parseTitle(String title) {
        return title.substring(0, title.length() - 18);
    }

}