package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Test.
*
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@version $id$
*@since 0.1
*/

public class CalculatorTest {
/**
*Test.add.
*/
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 2D);
		double result = calc.getResult();
		double expected = 3D;
		assertThat(result, is(expected));
	}
/**
*Test.subtract.
*/
	public void whenSubtractOneMinusOneThenTwo() {

		Calculator calc = new Calculator();
		calc.subtract(2D, 1D);
		double result = calc.getResult();
		double expected = 1D;
		assertThat(result, is(expected));
	}
/**
*Test.division.
*/
	public void whenDivisionOneDivideOneThenTwo() {
		Calculator calc = new Calculator();
		calc.div(10D, 5D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
/**
*Test.multiple.
*/
	public void whenMultipleOnemultiplyOneThenTwo() {
		Calculator calc = new Calculator();
		calc.multiple(2D, 3D);
		double result = calc.getResult();
		double expected = 6D;
		assertThat(result, is(expected));
	}
}
