package sqljob;

import org.junit.Test;
import ru.job4j.sqljob.Parser;
import ru.job4j.sqljob.date.DateCheck;

import java.util.Calendar;
import java.util.Date;


import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;


public class DateCheckTest {
    @Test
    public void checkConvertFromStringToCalendarWhenTwoDigitInDay() {
        DateCheck dateCheck = new DateCheck();
        String stringDate = "20 окт 13";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);//remove milliseconds
        calendar.set(2013, 9, 20);
        Date expected = calendar.getTime();
        Date result = dateCheck.convertFromString(stringDate).getTime();
        assertThat(result, is(expected));
    }

    @Test
    public void checkConvertFromStringToCalendarWhenOneDigitInDay() {
        DateCheck dateCheck = new DateCheck();
        String stringDate = "1 янв 17";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);//remove milliseconds
        calendar.set(2017, 0, 1);
        Date expected = calendar.getTime();
        Date result = dateCheck.convertFromString(stringDate).getTime();
        assertThat(result, is(expected));
    }

    @Test
    public void sss() {
        Parser parser = new Parser();
        parser.grabLinkVacation();
    }
}
