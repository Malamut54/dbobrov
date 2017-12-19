package ru.job4j.sqljob;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

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
    private Date dateVacancy = null;
    private DateCheck dateCheck = new DateCheck();
    private List<Vacancy> listVac = new ArrayList();


    public void grabLinkVacation() {
        //Don't forget reset when method end
        int page = 1;
        try {
            Document document = Jsoup.connect("http://www.sql.ru/forum/job/1").get();
            Elements elements = document.getElementsByAttributeValue("class", "postslisttopic");
            for (Element element : elements) {
                String urlVacancy = (element.child(0).attr("href"));
                if (checkDateVacancy(urlVacancy)) {
                    checkOnlyJavaVacancy(urlVacancy);
                } else {
                    page = 1;
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void checkOnlyJavaVacancy(String link) {

        if (link.contains("java") && !link.contains("javascript") && !link.contains("java-script")) {
            this.url = link;
            createValidVacancy(link);
        }

    }

    public boolean checkDateVacancy(String link) {
        int year = Calendar.YEAR;
        int month = Calendar.MONTH;
        int day = Calendar.DAY_OF_MONTH;
        Base base = new Base();

        Calendar borderDate = Calendar.getInstance();
        borderDate.set(Calendar.MILLISECOND, 0);


        if (base.isFirstLaunch()) {
            borderDate.set(year, 0, 1);
        } else {
//            borderDate.set(year, month, day);
//            get last date from DB
        }
//        System.out.println(borderDate.getTime());

        try {
            Document document = Jsoup.connect(link).userAgent("Mozilla").get();
            Elements elements = document.select("td.msgFooter");

            String date = elements.first().childNode(0).toString().substring(0, 10);
            dateVacancy = dateCheck.convertFromString(date).getTime();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateVacancy.before(borderDate.getTime()) || dateVacancy.equals(borderDate.getTime());
    }

    public void createValidVacancy(String link) {
        try {
            Document document = Jsoup.connect(link).userAgent("Mozilla").get();
            Elements nameAuthor = document.getElementsByAttributeValue("class", "msgBody");
            this.description = document.select("td.msgBody").get(1).ownText();
            this.author = nameAuthor.get(0).childNode(1).childNode(0).toString();
            this.title = parseTitle(document.select("title").get(0).ownText());
            System.out.println(this.title);
        } catch (IOException e) {
            e.printStackTrace();
        }
        listVac.add(new Vacancy(this.dateVacancy, this.url, this.author, this.title, this.description));
    }


    private String parseTitle(String title) {
        return title.substring(0, title.indexOf('/'));
    }


}