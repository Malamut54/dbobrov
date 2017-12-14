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

import org.jsoup.select.Elements;
import ru.job4j.sqljob.db.Base;


import java.io.IOException;


public class Parser {
    private String date;
    private String author;
    private String title;
    private String url;
    private String description;

    public void grabLinkVacation() {
        //Don't forget reset when method end
        int page = 1;
        try {
            Document document = Jsoup.connect(String.format("http://www.sql.ru/forum/job/%d)", page++)).userAgent("Mozilla").get();
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
        Base base = new Base();
        Init init = new Init();
        boolean result = false;
        int depthSearch = base.isFirstLaunch() ? 365 : init.getPeriodicity();

        try {
            Document document = Jsoup.connect(link).userAgent("Mozilla").get();
            Elements elements = document.select("td.msgFooter");

            String date = elements.first().childNode(0).toString().substring(0, 10);
            this.date = date;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void createValidVacancy(String link) {

    }


}