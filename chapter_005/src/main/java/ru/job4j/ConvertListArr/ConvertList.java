package ru.job4j.ConvertListArr;

import java.util.ArrayList;
import java.util.List;

/**
 * Task convert arr2List and vice versa
 *
 * @author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 * @since 0.1
 */
public class ConvertList {
    /**
     * Class ConvertList.
     */

    /**
     * Private variable.
     */
    private ArrayList<Integer> list = new ArrayList<Integer>();
    /**
     * Private variable
     */
    private int[][] arr;

    /**
     * Convert Array to ArrayList.
     *
     * @param array Input array.
     * @return ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                list.add(array[i][j]);
            }
        }
        return this.list;
    }

    /**
     * Convert ArrayList to Array.
     * @param list Input list.
     * @param rows Number of rows.
     * @return Array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        //Initialization array
        int iter = 0;
        if (list.size() % rows == 0) {
            this.arr = new int[rows][list.size() / rows];
        } else {
            while (list.size() % rows != 0) {
                list.add(0);
            }
            this.arr = new int[rows][list.size() / rows];
        }

        //Fill array
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr[0].length; j++) {
                this.arr[i][j] = list.get(iter++);
            }
        }
        return this.arr;
    }

}
