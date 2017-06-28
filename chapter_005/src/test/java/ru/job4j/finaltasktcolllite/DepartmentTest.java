package ru.job4j.finaltasktcolllite;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Test SortDeprt.
 */
public class DepartmentTest {

    /**
     * Fill list.
     */
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

    /**
     * Sort by ascending.
     */
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
        Assert.assertEquals(result, expected);
    }

    /**
     * Sort by descending.
     */
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
        Assert.assertEquals(result, expected);
    }
}
