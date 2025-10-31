package ru.stqa.geometry.triangle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TriangleTests {

    @Test
    void canCalculatePerimeter() {
        var t = new Triangle(5, 6, 7);
        int result = t.perimeter();
        Assertions.assertEquals(18.0, result);
    }

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(14, new Triangle(5, 6,7).area());
    }

    @Test
    void cannotCreateTriangleTooBigSide() {
        try {
            new Triangle(25, 6,7);
        } catch (IllegalArgumentException exception) {
            System.out.println("One of triangle side is too big");
        }
    }


    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5, 5, 6);
            Assertions.fail();
        } catch(IllegalArgumentException exception) {
            System.out.println("One of triangle side is negative");
        }
    }

}
