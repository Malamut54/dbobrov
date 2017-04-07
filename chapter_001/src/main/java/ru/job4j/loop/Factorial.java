package ru.job4j.loop;

/**
*Factorial number calculation. Task 4.2.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/
public class Factorial {
/**
*Class Counter.
*/

/**
*Variable for factorial.
*/

/**
*Calculation factorial.
*@param n - input value.
*@return sum - return factorial.
*/
	public int calc(int n) {
		return (n == 0) ? 1 : n * calc(n - 1);
	}
}