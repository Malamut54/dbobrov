package ru.job4j.sqljob;



import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.sqljob.date.DateCheck;
import ru.job4j.sqljob.db.Base;
import java.io.IOException;
import java.util.Calendar;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class Parser {
    /**
     * Border date.
     */
    private Calendar borderDate = Calendar.getInstance();
    /**
     * Vacancy date.
     */
    private Calendar dateVacancy = Calendar.getInstance();
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Parser.class);

    /**
     * Main method for grab all vacancy from sql.ru.
     */
    void grabLinkVacation() {
        BasicConfigurator.configure();
        LOGGER.setLevel(Level.INFO);
        boolean nextPage = true;
        int numPage = 1;
        LOGGER.info("Start parse sql.ru");

        while (nextPage) {
            try {
                Document document = Jsoup.connect(String.format("http://www.sql.ru/forum/job/%d", numPage++)).get();
                Elements elements = document.select("td.altcol");
                Elements tmpElements = new Elements();
                for (int i = 0; i < 6; i++) {
                    elements.remove(0);
                }
                for (Element element : elements) {
                    if (element.siblingIndex() == 11) {
                        tmpElements.add(element);
                    }
                }
                for (Element tmpelement : tmpElements) {
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
        LOGGER.info("Finish parse sql.ru");
    }

    /**
     * Checking the correctness of the name.
     *
     * @param link - vacation url.
     */
    private void checkOnlyJavaVacancy(String link) {
        if (link.contains("java") && !link.contains("javascript") && !link.contains("java-script")) {
//            this.url = link;
            createValidVacancy(link);
        }
    }

    /**
     * Checking the correctness of the vacancy date.
     *
     * @param link - vacation URL.
     * @return boolean.
     */
    private boolean checkDateVacancy(String link) {
        DateCheck dateCheck = new DateCheck();
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

    /**
     * Checking the correctness of the vacancy date on page.
     *
     * @param str vacation URL.
     * @return boolean.
     */
    private boolean checkDateOnPage(String str) {
        DateCheck dateCheck = new DateCheck();
        this.borderDate.set(Calendar.MILLISECOND, 0);


        if (!new Base().isFirstLaunch()) {
            borderDate.set(borderDate.get(Calendar.YEAR), 0, 1, 0, 0);
            dateCheck.lastStartDate();
        } else {
            this.borderDate = dateCheck.lastStartDate();
        }
        Calendar dateVacancyOnPage = dateCheck.convertFromString(str);
        return dateVacancyOnPage.after(borderDate);
    }

    /**
     * Create vacancy.
     *
     * @param link vacation URL.
     */
    private void createValidVacancy(String link) {
        String author = null;
        String title = null;
        String description = null;
        Base base = new Base();
        try {
            Document document = Jsoup.connect(link).userAgent("Mozilla").get();
            Elements nameAuthor = document.getElementsByAttributeValue("class", "msgBody");
            description = document.select("td.msgBody").get(1).ownText();
            author = nameAuthor.get(0).childNode(1).childNode(0).toString().trim();
            title = parseTitle(document.select("title").get(0).ownText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Vacancy vacancy = new Vacancy(this.dateVacancy.getTime(), link, author, title, description);
        if (base.checkDuplicate(vacancy)) {
            LOGGER.info("Duplicate Vacancy");
        } else {
            base.addVacancyToDb(vacancy);
            LOGGER.info(String.format("Add vacancy %s to DB", title));
        }

    }

    /**
     * Cutting vacancy title.
     * @param title vacancy title.
     * @return String.
     */
    private String parseTitle(String title) {
        return title.substring(0, title.length() - 18);
    }

}