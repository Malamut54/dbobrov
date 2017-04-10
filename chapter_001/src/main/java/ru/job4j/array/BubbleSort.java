package ru.job4j.array;

/**
*Sorted an array through Bubble sort. Task 5.1.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/
public class BubbleSort {
/**
*Class BuubleSort sorted array.
*/

/**
*Method sort implements Bubble sort.
*@param array - input array.
*@return array - sorted array.
*/
	public int[] sort(int[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
		return array;
	}
}