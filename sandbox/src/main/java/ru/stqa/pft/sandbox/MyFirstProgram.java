package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
//        System.out.println("Hello, world!");

        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 3);
        System.out.println("Расстояние между точками p1(" + p1.a + ";" + p1.b + ") и p2(" + p2.a + ";" + p2.b + ") равно " + p1.distance(p2));
    }
}
