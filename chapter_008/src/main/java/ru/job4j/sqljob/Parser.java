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
    //    private Date dateVacancy = null;
    private DateCheck dateCheck = new DateCheck();
    private List<Vacancy> listVac = new ArrayList();
    private Base base = new Base();
    private int numPage = 1;
    private Calendar borderDate = Calendar.getInstance();
    private Calendar dateVacancy = Calendar.getInstance();

    public void grabLinkVacation() {
        //Don't forget reset when method end
        boolean nextPage = true;
        while (nextPage)
        try {
            Document document = Jsoup.connect(String.format("http://www.sql.ru/forum/job/%d", numPage++)).get();

            Elements elements = document.getElementsByAttributeValue("class", "postslisttopic");
            for (int i = 0; i < 3; i++) {
                elements.remove(0);
            }
            for (Element element : elements) {
                String urlVacancy = (element.child(0).attr("href"));
                if (numPage < 3) {
                    checkOnlyJavaVacancy(urlVacancy);
                } else if (checkDateVacancy(urlVacancy)) {
                    checkOnlyJavaVacancy(urlVacancy);
                } else {
                    numPage = 1;
                    nextPage = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void checkOnlyJavaVacancy(String link) {
        link.toLowerCase();
        if (link.contains("java") && !link.contains("javascript") && !link.contains("java-script")) {
            this.url = link;
            createValidVacancy(link);
        }

    }

    public boolean checkDateVacancy(String link) {
        int year = borderDate.get(Calendar.YEAR);
        int month = Calendar.MONTH;
        int day = Calendar.DAY_OF_MONTH;

        borderDate.set(Calendar.MILLISECOND, 0);

        if (!base.isFirstLaunch()) {
            borderDate.set(year, 0, 1);
        } else {
//            borderDate.set(year, month, day);
//            get last date from DB
        }
//        System.out.println(borderDate.getTime());

        try {
            Document document = Jsoup.connect(link).userAgent("Mozilla").get();
            Elements elements = document.select("td.msgFooter");

            String date = elements.first().childNode(0).toString().substring(1, 10);
            dateVacancy = dateCheck.convertFromString(date);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dateVacancy.before(borderDate) + "|||" + dateVacancy.after(borderDate));
        System.out.println(dateVacancy.getTime() + " " + borderDate.getTime());
        System.out.println(link);
        return dateVacancy.after(borderDate);
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
//        listVac.add(new Vacancy(this.dateVacancy, this.url, this.author, this.title, this.description));
    }


    private String parseTitle(String title) {
        return title.substring(0, title.indexOf('/'));
    }


}