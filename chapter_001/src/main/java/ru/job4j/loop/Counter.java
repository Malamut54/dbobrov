package ru.job4j.loop;

/**
*Calculation of the sum of even numbers in given range. Task 4.1.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/
public class Counter {
/**
*Class Counter.
*/

/**
*Variable for sum.
*/
	private int sum = 0;

/**
*Calculation of the sum of even numbers in given range.
*@param start - start of range.
*@param finish - end of range.
*@return sum - return sum.
*/
	public int add(int start, int finish) {
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
