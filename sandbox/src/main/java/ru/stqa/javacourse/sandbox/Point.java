package ru.stqa.javacourse.sandbox;
import static java.lang.Math.sqrt;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double distance(Point p2) {
    return sqrt(sqr(this.x - p2.x) + sqr(this.y - p2.y));
  }

  private static double sqr(double sqr) {
    return sqr * sqr;
  }

}
