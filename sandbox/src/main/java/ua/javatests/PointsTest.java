package ua.javatests;

import static ua.javatests.Point.distance;

public class PointsTest {

    public static void main(String[] args) {
        Point point1 = new Point(0, 4);
        Point point2 = new Point(3, 0);

        System.out.println(distance(point1, point2));
        System.out.println(point1.distanceToPoint(point2));
    }
}
