package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
*Test.
*
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@version $id$
*@since 0.1
*/

public class TriangleTest {
/**
*Test.Getting the length of the sides.
*/
	@Test
	public void checkLengthSide() {
		Point a = new Point(1, 1);
		Point b = new Point(1, 3);
		Point c = new Point(4, 2);
		Triangle triangle = new Triangle(a, b, c);
		double result = triangle.lengthOfSides(a, b);
		double expected = 2.0;
		assertThat(result, closeTo(expected, 0.01));
	}

/**
*Test.Does there exist a triangle(true).
*/
	@Test
	public void checkTriangleIsExistTrue() {
		Point a = new Point(1, 1);
		Point b = new Point(1, 3);
		Point c = new Point(4, 2);
		Triangle triangle = new Triangle(a, b, c);
		boolean result = triangle.triangleIsExist(20.0, 15.0, 16.0);
		boolean expected = true;
		assertThat(result, is(expected));
	}

/**
*Test.Does there exist a triangle(false).
*/
	@Test
	public void checkTriangleIsExistFalse() {
		Point a = new Point(1, 1);
		Point b = new Point(1, 1);
		Point c = new Point(4, 2);
		Triangle triangle = new Triangle(a, b, c);
		boolean result = triangle.triangleIsExist(15.0, 1.0, 1.0);
		boolean expected = false;
		assertThat(result, is(expected));
	}

/**
*Test.Calculating area of triangle.
*/
	@Test
	public void checkTriangleArea() {
		Point a = new Point(1, 1);
		Point b = new Point(1, 3);
		Point c = new Point(4, 2);
		Triangle triangle = new Triangle(a, b, c);
		double result = triangle.area(a, b, c);
		double expected = 3.0;
		assertThat(result, closeTo(expected, 0.01));
	}

}