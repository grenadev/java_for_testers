package ru.stqa.geometry.Triangle;

public class Triangle {
    public static void main(String[] args) {
        printTrianglePerimeter(7.0);
        printTriangleArea(7.0, 7.0, 7.0);
    }

    public static void printTrianglePerimeter(double a) {
        System.out.println("Периметр треугольника со сторонами " + " "+ a +" " + "равен " + trianglePerimeter(a));
    }

    public static double trianglePerimeter(double a) {
        return a * 3;
    }

    private static void printTriangleArea(double a, double b, double c) {
        double p = (a*3)/2;
        System.out.println("Площадь треугольника со сторонами " + " "+ a +" " + "равен " + Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }

    public static double triangleArea(double a, double b, double c, double p) {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

