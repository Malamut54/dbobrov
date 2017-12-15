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
    private Map<String, Integer> month = new HashMap<String, Integer>();
    private static final String TODAY = "сегодня";
    private static final String YESTERDAY = "вчера";
    private static final String JANUARY = "янв";
    private static final String FEBRUARY = "фев";
    private static final String MARCH = "мар";
    private static final String APRIL = "апр";
    private static final String MAY = "июн";
    private static final String JUNE = "июл";
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
        Calendar dateVacancy = null;
        if (month.isEmpty()) {
            fillMap();
        }
        //check today and yesterday
        if (stringDate.contains(TODAY)) {
            dateVacancy.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        } else if (stringDate.contains(YESTERDAY)) {
            dateVacancy.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH - 1);
        } else {
            dateVacancy.set(convertToYear(stringDate), month.get(stringDate.substring(stringDate.length() - 6, stringDate.length() - 3)), convertToDay(stringDate));
        }
        return dateVacancy;
    }

    private int convertToYear(String year) {
        return Integer.parseInt(year.substring(year.length() - 1, year.length() - 2));
    }

    private int convertToDay(String day) {
        return Integer.parseInt(day.substring(0, 1));
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
