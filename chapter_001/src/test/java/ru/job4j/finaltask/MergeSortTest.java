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

public class MergeSortTest {
/**
*Test. Merge sort.
*/
	@Test
	public void mergeSort() {
		MergeSort merge = new MergeSort();
		int[] arr1 = {1, 3, 5};
		int[] arr2 = {2, 4, 5, 7};
		int[] expected = {1, 2, 3, 4, 5, 5, 7};
		int[] result = merge.sort(arr1, arr2);
		assertThat(result, is(expected));
	}
}