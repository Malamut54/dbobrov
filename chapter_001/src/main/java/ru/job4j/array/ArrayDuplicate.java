package ru.job4j.array;

import java.util.Arrays;

/**
*Remove duplicate in array. Task 5.3.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/
public class ArrayDuplicate {
/**
*Class ArrayDuplicate. Remove duplicate in array.
*/

/**
*inverting array.
*@param array - input array.
*@return array - return array without duplicate.
*/
	public String[] remove(String[] array) {
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[i].equals(array[j])) {
					i = j + 1;
					array[j] = null;

				}
			}
		}
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] == null) {
				array[i] = array[i + 1];
				array[i + 1] = null;
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				count++;
			}
		}
		return Arrays.copyOf(array, array.length - count);
	}
}