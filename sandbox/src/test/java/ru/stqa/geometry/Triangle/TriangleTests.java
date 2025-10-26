package ru.stqa.geometry.triangle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TriangleTests {

    @Test
    void canCalculatePerimeter() {
        var result = Triangle.perimeter(7);
        Assertions.assertEquals(21.0, result);
    }

    @Test
    void canCalculateArea() {
        var result = Triangle.area(7.0,7.0, 7.0, 10.5);
        Assertions.assertEquals(21.21762239271875, result);
    }
}
