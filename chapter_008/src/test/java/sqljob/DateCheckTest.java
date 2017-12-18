package sqljob;

import org.junit.Test;
import ru.job4j.sqljob.date.DateCheck;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class DateCheckTest {
    @Test
    public void checkConvertFromStringToCalendar() {
        DateCheck dateCheck = new DateCheck();
        String stringDate = "11 янв 17";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 0, 11);
        Date expected = calendar.getTime();
        Date result = dateCheck.convertFromString(stringDate).getTime();
        System.out.println(dateCheck.convertFromString(stringDate).getTime());
        System.out.println(calendar.getTime());
        assertThat(expected,is(result));
    }
}
