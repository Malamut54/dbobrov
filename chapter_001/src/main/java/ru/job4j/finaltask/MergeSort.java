package ru.job4j.finaltask;

/**
*Implementation merge sort. Task 6 final.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/

public class MergeSort {
/**
*Class Merge sort.
*/

/**
*Implementation.
*@param arrFirst first array.
*@param arrSecond second array.
*@return Return sorted array.
*/
	public int[] sort(int[] arrFirst, int[] arrSecond) {
		int[] sortArr = new int[arrFirst.length + arrSecond.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < sortArr.length; k++) {
            if (i > arrFirst.length - 1) {
                sortArr[k] = arrSecond[j];
                j++;
            } else if (j > arrSecond.length - 1) {
                sortArr[k] = arrFirst[i];
                i++;
            } else if (arrFirst[i] < arrSecond[j]) {
                sortArr[k] = arrFirst[i];
                i++;
            } else {
                sortArr[k] = arrSecond[j];
                j++;
            }
        }
        return sortArr;
	}
}