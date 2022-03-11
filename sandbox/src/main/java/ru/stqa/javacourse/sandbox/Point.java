package ru.stqa.javacourse.sandbox;

import static java.lang.Math.sqrt;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static void main(String[] args) {

    Point p1 = new Point(2, 2);
    Point p2 = new Point(2, 2);
    System.out.println("Расстояние между точкой (" + p1.x + "; " + p1.y + ") и точкой (" + p2.x + "; " + p2.y + ") = " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {
    return sqrt(sqr(p2.x - p1.x) + sqr(p2.y - p1.y));
  }

  private static double sqr(double sqr) {
    return sqr * sqr;
  }

}
