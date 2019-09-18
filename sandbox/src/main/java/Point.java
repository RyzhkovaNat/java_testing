import static java.lang.Math.sqrt;

public class Point {

    public double a;
    public double b;

    public Point(double a, double b) {

        this.a = a;
        this.b = b;
    }

    public double distance(Point p) {

        double dx = p.a - this.a;
        double dy = p.b - this.b;
        return sqrt(dx*dx + dy*dy);
    }
}
