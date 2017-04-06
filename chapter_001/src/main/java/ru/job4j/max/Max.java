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
*Method max return the maximum value from 2 digits.
*@param first **first digit**
*@param second **second digit**
*@return return maximum values.
*/
	public int max(int first, int second) {
		return first >= second ? first : second;
	}

/**
*Method max return the maximum value from 3 digits.
*@param first **first digit**
*@param second **second digit**
*@param third **second digit**
*@return return maximum values.
*/
	public int max(int first, int second, int third) {
		int firstMax = max(first, second);
		int finalMax = max(firstMax, third);
		return finalMax;
	}
}