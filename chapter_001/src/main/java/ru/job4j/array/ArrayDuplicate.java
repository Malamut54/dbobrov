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
String tmp;
		int counter = 0;
		for (int i = 0; i < array.length - counter; i++) {
			for (int j = i + 1; j < array.length - counter; j++) {
				if (array[i].equals(array[j])) {
					for (int k = j; k < array.length - 1; k++) {
						tmp = array[k];
						array[k] = array[k + 1];
						array[k + 1] = tmp;
					}
					counter++;
					j--;
				}
			}
		}
		return Arrays.copyOf(array, array.length - counter);
	}
}