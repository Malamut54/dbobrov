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

public class PaintTest {
/**
*Test. Draws pyramid when height == 2.
*/
	@Test
	public void drawsWhenHeightTwo() {
		Paint paint = new Paint();
		String result = paint.pyramid(2);
        String expected = String.format(" ^ \r\n^^^\r\n");
        assertThat(result, is(expected));
	}
/**
*Test. Draws pyramid when height == 3.
*/
	@Test
	public void drawsWhenHeightThree() {
		Paint paint = new Paint();
		String result = paint.pyramid(3);
        String expected = String.format("  ^  \r\n ^^^ \r\n^^^^^\r\n");
        assertThat(result, is(expected));
	}
}