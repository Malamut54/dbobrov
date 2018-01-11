package ru.job4j.sqljob;

import org.junit.Test;
import ru.job4j.sqljob.date.DateCheck;
import java.util.Calendar;
import java.util.Date;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class DateCheckTest {
    /**
     * Check convert date.
     */
    @Test
    public void checkConvertFromStringToCalendarWhenTwoDigitInDay() {
        DateCheck dateCheck = new DateCheck();
        String stringDate = "20 окт 13";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0); //remove milliseconds
        calendar.set(2013, 9, 20);
        Date expected = calendar.getTime();
        Date result = dateCheck.convertFromString(stringDate).getTime();
        assertThat(result, is(expected));
    }

    /**
     * Check convert date.
     */
    @Test
    public void checkConvertFromStringToCalendarWhenOneDigitInDayAndComma() {
        DateCheck dateCheck = new DateCheck();
        String stringDate = "2 окт 13,";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0); //remove milliseconds
        calendar.set(2013, 9, 2);
        Date expected = calendar.getTime();
        Date result = dateCheck.convertFromString(stringDate).getTime();
        assertThat(result, is(expected));
    }

}
