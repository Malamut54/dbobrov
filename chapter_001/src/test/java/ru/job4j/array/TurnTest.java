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

public class TurnTest {
/**
*Test. Testing an even array.
*/
	@Test
	public void evenArray() {
		Turn turn = new Turn();
		int[] arr = {1, 2, 3, 4, 5, 6};
		int[] result = turn.back(arr);
		int[] expected = {6, 5, 4, 3, 2, 1};
		assertThat(result, is(expected));
	}

/**
*Test. Testing an odd array.
*/
	@Test
	public void evenOdd() {
		Turn turn = new Turn();
		int[] arr = {1, 2, 3, 4, 5};
		int[] result = turn.back(arr);
		int[] expected = {5, 4, 3, 2, 1};
		assertThat(result, is(expected));
	}
}