package ru.job4j.condition;

/**
*Triangle class of the task 3.3.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/

public class Triangle {
/**
*Class Triangle calculates area of Triangle.
*/

/**
*point A.
*/
	private Point a;
/**
*point B.
*/
	private Point b;
/**
*point C.
*/
	private Point c;

/**
*Triangle constructor.
*@param a A point
*@param b B point
*@param c C point
*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
/**
*Calculate Tiangle area.
*Check that the triangle exists.
*@param a coordinate of point a
*@param b coordinate of point b
*@param c coordinate of point c
*@return area of Triangle. If return == 0.0 traingle is not exist.
*/
	public double area(Point a, Point b, Point c) {
		double sidesAB = lengthOfSides(a, b);
		double sidesAC = lengthOfSides(a, c);
		double sidesBC = lengthOfSides(b, c);

		if (triangleIsExist(sidesAB, sidesAC, sidesBC)) {
			double semiperimetr = (sidesAB + sidesAC + sidesBC) / 2;
			double triangleArea = Math.sqrt(semiperimetr * (semiperimetr - sidesAB) * (semiperimetr - sidesAC) * (semiperimetr - sidesBC));
			return triangleArea;
		} else {
			return 0.0;
		}
	}
/**
*Check that the triangle exists.
*@param a coordinate of point a
*@param b coordinate of point b
*@param c coordinate of point c
*@return true if triangle exist and vice versa
*/

	public boolean triangleIsExist(double a, double b, double c) {
		boolean triangleExist = a < (b + c) & b < (a + c) & c < (b + c) ? true : false;
		return triangleExist;
	}
/**
*Calculate length of sides triangle.
*@param a coordinate of point a
*@param b coordinate of point b
*@return length of side.
*/

	public double lengthOfSides(Point a, Point b) {
		double length = Math.sqrt(Math.pow((double) (b.getX() - a.getX()), 2) + Math.pow((double) (b.getY() - a.getY()), 2));
		return length;
	}
}