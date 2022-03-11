package ru.stqa.javacourse.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance () {
    Point p1 = new Point(4,4);
    Point p2 = new Point(1,1);
    Assert.assertEquals(p1.distance(p2), 4.242640687119285);
  }

  @Test
  public void testDistanceZero () {
    Point p1 = new Point(0,0);
    Point p2 = new Point(0,0);
    Assert.assertEquals(p1.distance(p2), 0);
  }

  @Test
  public void testDistanceNegativeNumbers () {
    Point p1 = new Point(-5,-5);
    Point p2 = new Point(-10,-10);
    Assert.assertEquals(p1.distance(p2), 7.0710678118654755);
  }
}
