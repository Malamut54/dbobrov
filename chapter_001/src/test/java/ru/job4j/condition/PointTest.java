package ru.job4j.condition;

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

public class PointTest {
/**
*Test.Is Point  exists on function (y(x) = a * x + b).
*/
	@Test
	public void existOnFunction() {
		Point point = new Point(2, 3);
		boolean result = point.is(1, 1);
		boolean expected = true;
		assertThat(result, is(expected));
	}

}