package ru.job4j.condition;

/**
*Point class of the task 3.2.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/

public class Point {
/**
*Class Point Describes the point.
*/

/**
*X coordinate.
*/

   private int x;
/**
*Y coordinate.
*/

   private int y;

/**
*Point constructor.
*@param x X point coordinate
*@param y Y point coordinate
*/

   public Point(int x, int y) {
      this.x = x;
      this.y = y;
  }

/**
*getter for coordinate x.
*@return value x
*/
  public int getX() {
      return this.x;
  }
 /**
*getter for coordinate y.
*@return value y
*/

  public int getY() {
     return this.y;
  }
/**
*Check is Point  exists on function (y(x) = a * x + b).
*@param a value
*@param b value
*@return true if point exists on function
*/
  public boolean is(int a, int b) {
    return this.y == a * this.x + b;
  }
}