package ru.job4j.calculator;

/**
*Class Calculator, solution of the task 2.3. Elementary calculator
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/

public class Calculator {
/**
*Class Calcultaor provides basic calculations.
*/
	private double result;

/**
*Performs operations of addition.
*@param first **first digit**
*@param second **second digit**
*/

	public void add(double first, double second) {
		this.result = (first + second);
	}

/**
*Performs the subtraction.
*@param first **first digit**
*@param second **second digit**
*/

	public void subtract(double first, double second) {
		this.result = (first - second);
	}

/**
*Performs the division.
*@param first **first digit**
*@param second **second digit**
*/
	public void div(double first, double second) {
		this.result = (first / second);
	}

/**
*Performs the multiplication.
*@param first **first digit**
*@param second **second digit**
*/

	public void multiple(double first, double second) {
		this.result = (first * second);
	}

/**
*returns the result of the calculation.
*@return result **result of calculations**
*/
	public double getResult() {
		return this.result;
	}

}