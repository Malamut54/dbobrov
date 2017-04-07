package ru.job4j.loop;

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

public class FactorialTest {
/**
*Test. Calculate factorial when input value == 0.
*/
	@Test
	public void calcFactInputZero() {
		Factorial factorial = new Factorial();
		int result = factorial.calc(0);
		int expected = 1;
		assertThat(result, is(expected));
	}

/**
*Test. Calculate factorial when input value != 0.
*/
	@Test
	public void calcFactInputNotZero() {
		Factorial factorial = new Factorial();
		int result = factorial.calc(5);
		int expected = 120;
		assertThat(result, is(expected));
	}

}