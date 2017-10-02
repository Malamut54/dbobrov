package ru.job4j.finaltasklogic;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task Find the dependence.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 07.09.2017
 */

public class FindEntityTest {
    /**
     * Main test.
     */
    @Test
    public void testFindEntity() {
        FindEntity find = new FindEntity();
        List<String> input = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        input.add("12");
        input.add("47");
        input.add("31");
        input.add("45");
        input.add("74");
        input.add("47");
        input.add("13");
        input.add("63");
        input.add("36");
        expected.add("4 7 4");
        expected.add("3 1 3");
        expected.add("7 4 7");
        expected.add("6 3 6");

        result = find.parser(input);
        assertThat(result, is(expected));
    }

}