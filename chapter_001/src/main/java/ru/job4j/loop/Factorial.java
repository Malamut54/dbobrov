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
*Calculation factorial.
*@param n - input value.
*@return sum - return factorial.
*/
	// public int calc(int n) {
	// 	return (n == 0) ? 1 : n * calc(n - 1);
	// }
	public int calc(int n) {
		int sum = 1;
		for (int i = 2; i <= n; i++) {
			if (n == 0) {
				return sum;
			} else {
				sum = sum * i;
			}
		}
		return sum;
	}
}