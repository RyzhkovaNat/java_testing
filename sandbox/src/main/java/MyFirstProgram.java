import static java.lang.Math.sqrt;

public class MyFirstProgram {

    public static void main(String[] args) {
//        System.out.println("Hello, world!");

        Point p1 = new Point(1, 10);
        Point p2 = new Point(2, 3);
        System.out.println("Расстояние между точками p1(" + p1.a + ";" + p1.b + ") и p2(" + p2.a + ";" + p2.b + ") равно " + distance(p1, p2));
    }

    public static double distance(Point p1, Point p2) {

        double dx = p1.a - p2.a;
        double dy = p1.b - p2.b;
        return sqrt(dx * dx + dy * dy);
    }

}
