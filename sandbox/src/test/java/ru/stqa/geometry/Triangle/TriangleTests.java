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
}
