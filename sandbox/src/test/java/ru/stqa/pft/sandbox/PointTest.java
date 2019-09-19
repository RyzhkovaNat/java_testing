package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testDistanceZero() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        assert p1.distance(p2) == 0;
    }

    @Test
    public void testDistanceIntCor() {
        Point p1 = new Point(1, 10);
        Point p2 = new Point(5, 10);
        Assert.assertEquals(p1.distance(p2), 4.0);
    }

    @Test
    public void testDistanceIntInc() {
        Point p1 = new Point(1, 10);
        Point p2 = new Point(5, 10);
        Assert.assertEquals(p1.distance(p2), 5);
    }

    @Test
    public void testDistanceIntIncType() {
        Point p1 = new Point(1, 10);
        Point p2 = new Point(5, 10);
        Assert.assertEquals(p1.distance(p2), 4);
    }

    @Test
    public void testDistanceDouble() {
        Point p1 = new Point(1, 7);
        Point p2 = new Point(4, 15);
        Assert.assertEquals(p1.distance(p2), 8.54400374531753);
    }
}
