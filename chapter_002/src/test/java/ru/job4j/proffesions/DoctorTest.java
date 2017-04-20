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
public class DoctorTest {
    /**
     *Test. Dcotor class.
     */
    @Test
    public void doctorTest() {
        Doctor doctor = new Doctor("Lecter", 45, true);
        Engeneer engeneer = new Engeneer("Bob", 34, true);
        String expected = "The doctor Lecter treats Bob";
        String result = doctor.cure(engeneer);
        assertThat(result, is(expected));
    }
}
