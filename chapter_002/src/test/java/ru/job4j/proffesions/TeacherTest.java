package ru.job4j.proffesions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test.
 *
 *@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 *@version $id$
 *@since 0.1
 */
public class TeacherTest {
    /**
     *Test. Teacher class.
     */
    @Test
    public void doctorTest() {
        Engeneer engeneer = new Engeneer("Fedor", 32, true);
        Teacher teacher = new Teacher("Rudolf", 55, false);
        String expected = "The teacher Rudolf teach Fedor";
        String result = teacher.teach(engeneer);
        assertThat(result, is(expected));
    }
}
