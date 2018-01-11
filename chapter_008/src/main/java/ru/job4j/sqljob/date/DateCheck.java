package ru.job4j.sqljob.date;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class DateCheck {
    /**
     * Year.
     */
    private int year;
    /**
     * Month.
     */
    private int month;
    /**
     * Date.
     */
    private int day;
    /**
     * Months.
     */
    private Map<String, Integer> months = new HashMap<String, Integer>();
    /**
     * Today.
     */
    private static final String TODAY = "сегодня";
    /**
     * Yesterday.
     */
    private static final String YESTERDAY = "вчера";
    /**
     * January.
     */
    private static final String JANUARY = "янв";
    /**
     * February.
     */
    private static final String FEBRUARY = "фев";
    /**
     * March.
     */
    private static final String MARCH = "мар";
    /**
     * April.
     */
    private static final String APRIL = "апр";
    /**
     * May.
     */
    private static final String MAY = "май";
    /**
     * June.
     */
    private static final String JUNE = "июн";
    /**
     * July.
     */
    private static final String JULY = "июл";
    /**
     * August.
     */
    private static final String AUGUST = "авг";
    /**
     * September.
     */
    private static final String SEPTEMBER = "сен";
    /**
     * October.
     */
    private static final String OCTOBER = "окт";
    /**
     * November.
     */
    private static final String NOVEMBER = "ноя";
    /**
     * December.
     */
    private static final String DECEMBER = "дек";

    /**
     * Set last start.
     *
     * @return Calendar
     */
    public Calendar lastStartDate() {
        Calendar lastStart = Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        lastStart.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        return lastStart;
    }

    /**
     * Convert from String to Calendar.
     * @param stringDate input String
     * @return Calendar
     */
    public Calendar convertFromString(String stringDate) {
        Calendar dateVacancy = Calendar.getInstance();
        dateVacancy.set(Calendar.MILLISECOND, 0); //remove milliseconds
        if (months.isEmpty()) {
            fillMap();
        }
        if (stringDate.contains(TODAY)) {
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH);
            day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            dateVacancy.set(year, month, day);
        } else if (stringDate.contains(YESTERDAY)) {
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH);
            day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            dateVacancy.set(year, month, day - 1);
        } else {
            stringDate = stringDate.substring(0, 9);
            String monthStr = stringDate.substring(stringDate.length() - 7, stringDate.length() - 3).trim();
            this.year = convertToYear(stringDate);
            this.month = months.get(monthStr);
            this.day = convertToDay(stringDate);
            dateVacancy.set(year, month, day);
        }
        return dateVacancy;
    }

    /**
     * Convert to year.
     * @param year input String
     * @return int
     */
    private int convertToYear(String year) {
        year = year.substring(year.length() - 3, year.length()).trim();
        if (year.contains(",")) {
            year = year.replaceAll("[,]", "");
        }
        Integer tmp = Integer.parseInt(year) + 2000;
        return tmp;
    }

    /**
     * Convert to day.
     * @param day input string
     * @return int
     */
    private int convertToDay(String day) {
        Integer dayOfMonth = null;
        try {
            dayOfMonth = Integer.parseInt(day.substring(0, 2).trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return dayOfMonth;
    }

    /**
     * Fill Map months.
     */
    private void fillMap() {
        //This seems strange but this is more simple than manual add String and Integer to map
        String[] monthArr = {
                JANUARY,
                FEBRUARY,
                MARCH,
                APRIL,
                MAY,
                JUNE,
                JULY,
                AUGUST,
                SEPTEMBER,
                OCTOBER,
                NOVEMBER,
                DECEMBER
        };
        for (int i = 0; i < monthArr.length; i++) {
            months.put(monthArr[i], i);
        }
    }
}
