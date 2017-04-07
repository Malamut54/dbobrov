package ru.job4j.max;

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

public class MaxTest {
/**
*Test max from 2 digits.
*/
	@Test
	public void testMaxDiff() {
		Max maximum = new Max();
		int result = maximum.max(5, 2);
		int expected = 5;
		assertThat(result, is(expected));
	}

/**
*Test max from 3 digits.
*/
	@Test
	public void testMaxEq() {
		Max maximum = new Max();
		int result = maximum.max(5, 6, 7);
		int expected = 7;
		assertThat(result, is(expected));
	}
}