package ru.job4j.array;

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

public class ArrayDuplicateTest {
/**
*Test. Testing Duplicate.
*/
	@Test
	public void testArrayDuplicate() {
		ArrayDuplicate arrayDup = new ArrayDuplicate();
		String[] array = {"Privet", "Mir", "Super", "Super", "Mir"};
		String[] result = arrayDup.remove(array);
		String[] expected = {"Privet", "Mir", "Super"};
		assertThat(result, is(expected));
	}
}