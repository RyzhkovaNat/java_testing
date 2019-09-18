import static java.lang.Math.sqrt;

public class MyFirstProgram {

	public static void main(String[] args) {
		//System.out.println("Hello, world!");

		Point p1 = new Point();
		p1.a = 1;
		p1.b = 2;
		Point p2 = new Point();
		p2.a = 3;
		p2.b = 4;
		System.out.println("Расстояние между точками p1(" + p1.a + ";" + p1.b + ") и p2(" + p2.a + ";" + p2.b + ") равно " + distance(p1, p2));
	}

	public static double distance (Point p1, Point p2) {

		return sqrt((p1.a-p1.b)*(p2.a-p2.b));
	}
}