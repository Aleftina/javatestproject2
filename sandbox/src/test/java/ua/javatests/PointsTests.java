package ua.javatests;

        import org.testng.Assert;
        import org.testng.annotations.Test;
//
public class PointsTests {

    @Test
    public static void pointsDistanceTest() {

        Point point1 = new Point(0, 3);
        Point point2 = new Point(4, 0);
        Point point3 = new Point(0, -3);
        Point point4 = new Point(0, 0);

        Assert.assertEquals(point1.distanceToPoint(point2), 5.0);
        Assert.assertEquals(point3.distanceToPoint(point1), 6.0);
        Assert.assertEquals(point3.distanceToPoint(point4), 3.0);
    }
}
