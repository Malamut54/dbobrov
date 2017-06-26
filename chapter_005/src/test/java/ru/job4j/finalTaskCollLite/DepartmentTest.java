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
public class DepartmentTest {

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

        Department fill = new Department();
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

    @Test
    public void sortByAscend() {
        List<String> list = new ArrayList();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");

        Department ascend = new Department();
        List<String> result = ascend.sortByAscending(list);
        List<String> expected = new ArrayList<>();
        expected.add("K1");
        expected.add("K1\\SK1");
        expected.add("K1\\SK1\\SSK1");
        expected.add("K1\\SK1\\SSK2");
        expected.add("K1\\SK2");
        expected.add("K2");
        expected.add("K2\\SK1");
        expected.add("K2\\SK1\\SSK1");
        expected.add("K2\\SK1\\SSK2");
        System.out.println(result);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void sortBydescend() {
        List<String> list = new ArrayList();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");

        Department descend = new Department();
        List<String> result = descend.sortByDescending(list);
        List<String> expected = new ArrayList<>();
        expected.add("K2");
        expected.add("K2\\SK1");
        expected.add("K2\\SK1\\SSK2");
        expected.add("K2\\SK1\\SSK1");
        expected.add("K1");
        expected.add("K1\\SK2");
        expected.add("K1\\SK1");
        expected.add("K1\\SK1\\SSK2");
        expected.add("K1\\SK1\\SSK1");
        System.out.println(result);
        Assert.assertEquals(result, expected);
    }
}
