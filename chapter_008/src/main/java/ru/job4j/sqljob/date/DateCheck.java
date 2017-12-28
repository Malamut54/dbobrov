package ru.job4j.sqljob.date;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.12.2017
 */

public class DateCheck {
    int year;
    int monthTmp;
    int day;
    private Map<String, Integer> month = new HashMap<String, Integer>();
    private static final String TODAY = "сегодня";
    private static final String YESTERDAY = "вчера";
    private static final String JANUARY = "янв";
    private static final String FEBRUARY = "фев";
    private static final String MARCH = "мар";
    private static final String APRIL = "апр";
    private static final String MAY = "май";
    private static final String JUNE = "июн";
    private static final String JULY = "июл";
    private static final String AUGUST = "авг";
    private static final String SEPTEMBER = "сен";
    private static final String OCTOBER = "окт";
    private static final String NOVEMBER = "ноя";
    private static final String DECEMBER = "дек";


    public Calendar lastStartDate() {
        Calendar lastStart = Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        lastStart.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        return lastStart;
    }

    public Calendar convertFromString(String stringDate) {
        Calendar dateVacancy = Calendar.getInstance();
        dateVacancy.set(Calendar.MILLISECOND, 0);//remove milliseconds
        if (month.isEmpty()) {
            fillMap();
        }
        //check today and yesterday
        if (stringDate.contains(TODAY)) {
            dateVacancy.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        } else if (stringDate.contains(YESTERDAY)) {
            dateVacancy.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH - 1);
        } else {
            stringDate = stringDate.substring(0, 9);
            String monthStr = stringDate.substring(stringDate.length() - 7, stringDate.length() - 3).trim();
            try {
                this.year = convertToYear(stringDate);
                this.monthTmp = month.get(monthStr);
                this.day = convertToDay(stringDate);
                dateVacancy.set(year, monthTmp, day);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dateVacancy;
    }

    private int convertToYear(String year) {
        year = year.substring(year.length() - 3, year.length()).trim();
        if (year.contains(",")) {
            year = year.replaceAll("[,]", "");
        }
        Integer tmp = Integer.parseInt(year) + 2000;
        return tmp;
    }

    private int convertToDay(String day) {
        Integer dayOfMonth = null;
        try {
            dayOfMonth = Integer.parseInt(day.substring(0, 2).trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return dayOfMonth;
    }

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
            month.put(monthArr[i], i);
        }
    }
}
