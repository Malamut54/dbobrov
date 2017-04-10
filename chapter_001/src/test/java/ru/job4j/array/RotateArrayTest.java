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

public class RotateArrayTest {
/**
*Test. Rotate array 2x2.
*/
	@Test
	public void rotateArr2x2() {
		RotateArray rArr = new RotateArray();
		int[][] arr2x2 =
		{
			{1, 2},
			{3, 4},
		};
		int[][] expected =
		{
			{3, 1},
			{4, 2},			
		};
		int[][] result = rArr.rotate(arr2x2);
		assertThat(result, is(expected));
	}
/**
*Test. Rotate array 3x3.
*/
	@Test
	public void rotateArr3x3() {
		RotateArray rArr = new RotateArray();
		int[][] arr3x3 =
		{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
		};
		int[][] expected =
		{
			{7, 4, 1},
			{8, 5, 2},
			{9, 6, 3},
		};
		int result = rArr.rotate(arr3x3);
		assertThat(result, is(expected));
	}

}