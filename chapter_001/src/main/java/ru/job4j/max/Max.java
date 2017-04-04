package ru.job4j.max;

/**
*Class Calculator, solution of the task 2.3. Elementary calculator
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/

public class Max {
/**
*Class Max calculates the maximum value.
*/

/**
*Method max return the maximum value.
*@param first **first digit**
*@param second **second digit**
*@return return maximum values.
*/
	public int max(int first, int second) {
		return first >= second ? first : second;
	}
}