package ru.job4j.ConvertListArr;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

/**
 * Test convertList.
 */
public class ConvertListTest {
    /**
     * Test converting Array to List.
     */
    @Test
    public void convertArrayToList() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        ConvertList convert = new ConvertList();
        List result = convert.toList(arr);
        List expected = new ArrayList<Integer>();
        for (int i = 1; i < 7; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }

    /**
     * Test converting List to ArrayList when size arr is even.
     */
    @Test
    public void convertListToArrayWhenSizeIsEven() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
        ConvertList convert = new ConvertList();
        int[][] excpected = convert.toArray(list, 3);
        int[][] result = {{0, 1, 2}, {3, 4, 5}, {6, 0, 0}};
        assertThat(result, is(excpected));
    }

    /**
     * Test converting List to ArrayList when size arr is odd.
     */
    @Test
    public void convertListToArrayWhenSizeIsOdd() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        ConvertList convert = new ConvertList();
        int[][] excpected = convert.toArray(list, 3);
        int[][] result = {{0, 1,}, {2, 3}, {4, 5}};
        assertThat(result, is(excpected));
    }


}
