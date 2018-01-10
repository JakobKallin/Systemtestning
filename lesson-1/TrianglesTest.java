package se.newton;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrianglesTest {
    @Test
    public void testValidIsoscelesTriangle() {
        // Arrange
        double a = 5;
        double b = 5;
        double c = 6;

        // Act
        boolean result = Triangles.isIsoscelesTriangle(a, b, c);

        // Assert
        assertTrue(result == true);
    }

    @Test
    public void testValidNonIsoscelesTriangle() {
        // Arrange
        double a = 1;
        double b = 2;
        double c = 3;

        // Act
        boolean result = Triangles.isIsoscelesTriangle(a, b, c);

        // Assert
        assertTrue(result == false);
    }

    @Test
    public void testOneOrMoreSidesZero() {
        double a = 4;
        double b = 6;
        double c = 0;

        boolean result = Triangles.isIsoscelesTriangle(a, b, c);

        assertTrue(result == false);
    }

    @Test
    public void testIsoscelesWithOneOrMoreSidesZero() {
        double a = 4;
        double b = 4;
        double c = 0;

        boolean result = Triangles.isIsoscelesTriangle(a, b, c);

        assertTrue(result == false);
    }

    @Test
    public void testIsoscelesWithNegativeSide() {
        double a = 2;
        double b = 2;
        double c = -5;

        boolean result = Triangles.isIsoscelesTriangle(a, b, c);

        assertTrue(result == false);
    }
}