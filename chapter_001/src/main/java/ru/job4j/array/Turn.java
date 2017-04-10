package ru.job4j.array;

/**
*Inverting an array. Task 5.0.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/
public class Turn {
/**
*Class Turn. inverting array.
*/

/**
*inverting array.
*@param array - input array.
*@return array - return iverting array.
*/

	public int[] back(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
				int tmp = array[i];
				array[i] = array[array.length - i - 1];
				array[array.length - i - 1] = tmp;
			}
		return array;
	}
}