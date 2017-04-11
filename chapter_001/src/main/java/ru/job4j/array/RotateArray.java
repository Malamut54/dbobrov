package ru.job4j.array;

/**
*Rotate an array. Task 5.2.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/
public class RotateArray {
/**
*Class RotateArray. Rotate array.
*/

/**
*inverting array.
*@param array - input array.
*@return array - return rotate array.
*/
	public int[][] rotate(int[][] array) {
		int[][] rtArray = new int[array.length][array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				rtArray[j][array.length - i - 1] = array[i][j];
			}
		}
		return rtArray;
	}
}