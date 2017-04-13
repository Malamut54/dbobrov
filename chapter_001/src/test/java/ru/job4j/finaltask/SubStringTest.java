package ru.job4j.finaltask;

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

public class SubStringTest {
/**
*Test. Testing Substring false.
*/
	@Test
	public void testSubstringFalse() {
		SubString subString	= new SubString();
		String origin = "abcdfghi jkl";
		String sub = "fdc";
		boolean result = subString.contains(origin, sub);
		boolean expected = false;
		assertThat(result, is(expected));
	}
/**
*Test. Testing Substring false.
*/
	@Test
	public void testSubstringTrue() {
		SubString subString = new SubString();
		String origin = "abcdfghi jkl";
		String sub = "cdf";
		boolean result = subString.contains(origin, sub);
		boolean expected = true;
		assertThat(result, is(expected));
	}
}


