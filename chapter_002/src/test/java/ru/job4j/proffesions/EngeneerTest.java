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
public class EngeneerTest {
    /**
     * Test. Engeener class.
     */
    @Test
    public void engeneerTest() {
        Engeneer engeneer = new Engeneer("Andrey", 32, true);
        Teacher teacher = new Teacher("Kirill", 55, false);
        String expected = "The engeneer Andrey teach Kirill";
        String result = engeneer.teach(teacher);
        assertThat(result, is(expected));
    }
}
