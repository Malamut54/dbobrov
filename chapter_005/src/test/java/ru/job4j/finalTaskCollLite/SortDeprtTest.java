package ru.job4j.finalTaskCollLite;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



/**
 * Test SortDeprt.
 */
public class SortDeprtTest {

    @Test
    public void fillingMissingValues() {
        List<String> list = new ArrayList();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");

        SortDeprt fill = new SortDeprt();
        List<String> result = fill.fillDeprt(list);
        List<String> expected = new ArrayList<>();
        expected.add("K1\\SK1");
        expected.add("K1\\SK2");
        expected.add("K1\\SK1\\SSK1");
        expected.add("K1\\SK1\\SSK2");
        expected.add("K2");
        expected.add("K2\\SK1\\SSK1");
        expected.add("K2\\SK1\\SSK2");
        expected.add("K1");
        expected.add("K2\\SK1");
        Assert.assertEquals(result, expected);

    }
}
