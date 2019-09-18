import static java.lang.Math.sqrt;

public class Point {

    public double a;
    public double b;

    public Point(double a, double b) {

        this.a = a;
        this.b = b;
    }

    public double distance(Point p) {

        double dx = this.a - p.a;
        double dy = this.b - p.b;
        double distance = sqrt(dx*dx + dy*dy);
        return distance;
    }
}
