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

public class BubbleSortTest {
/**
*Test. Testing BubbleSort.
*/
	@Test
	public void testBubbleSort() {
		BubbleSort bubble = new BubbleSort();
		int[] arr = {5, 1, 2, 7, 2};
		int[] result = bubble.sort(arr);
		int[] expected = {1, 2, 2, 5, 7};
		assertThat(result, is(expected));
	}
}