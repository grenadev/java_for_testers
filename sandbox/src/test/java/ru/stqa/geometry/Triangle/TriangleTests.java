package ru.stqa.geometry.Triangle;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TriangleTests {

    @Test
    void canCalculatePerimeter() {
        var result = Triangle.trianglePerimeter(7);
        Assertions.assertEquals(21.0, result);
    }
}
