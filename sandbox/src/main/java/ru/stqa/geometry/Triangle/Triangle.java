package ru.stqa.geometry.triangle;

public class Triangle {
    public static void main(String[] args) {
        printTrianglePerimeter(7.0);
        printTriangleArea(7.0, 7.0, 7.0);
    }

    public static void printTrianglePerimeter(double a) {
        System.out.println("Периметр треугольника со сторонами " + " "+ a +" " + "равен " + perimeter(a));
    }

    public static double perimeter(double a) {
        return a * 3;
    }

    public static void printTriangleArea(double a, double b, double c) {
        double p = (a*3)/2;
        System.out.println("Площадь треугольника со сторонами " + " "+ a +" " + "равен " + Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }

    public static double area(double a, double b, double c) {
        double p = (a*3)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

