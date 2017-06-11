package ru.job4j.ConvertListArr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Task convert arr2List and vice versa
 *
 * @author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 * @since 0.1
 */

/**
 * Class ConvertList.
 */
public class ConvertList {
    /**
     * Convert Array to List.
     *
     * @param array Input array.
     * @return ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    /**
     * Convert List to Array.
     *
     * @param list Input list.
     * @param rows Number of rows.
     * @return Array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        //Initialization array
        int[][] arr;
        int listSize = list.size();
        if (list.size() % rows == 0) {
            arr = new int[rows][listSize / rows];
        } else {
            while (listSize % rows != 0) {
                listSize++;
            }
            arr = new int[rows][listSize / rows];
        }

        //Fill array
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (iterator.hasNext()) {
                    arr[i][j] = iterator.next();
                }
            }
        }
        return arr;
    }

    /**
     * Convert List<int[]> to List<Integer>
     *
     * @param list Input List.
     * @return List<Integer>.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> listArr = new ArrayList<Integer>();
        for (int[] ints : list) {
            for (int i : ints) {
                listArr.add(i);
            }
        }
        return listArr;
    }
}
