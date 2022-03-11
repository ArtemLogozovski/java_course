package ru.stqa.javacourse.sandbox;

public class DistanceCalculation {

  public static void main(String[] args) {
    Point p1 = new Point(2, 2);
    Point p2 = new Point(4, 4);
    System.out.println("Расстояние между точкой (" + p1.x + "; " + p1.y + ") и точкой (" + p2.x + "; " + p2.y + ") = " + p1.distance(p2));
  }
}
