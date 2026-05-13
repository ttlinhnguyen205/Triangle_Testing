import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @Test
    public void testConstructor() {
        new Triangle();
    }

    @Test
    public void testInvalidWhenAIsZero() {
        assertEquals("Invalid", Triangle.classify(0, 3, 4));
    }

    @Test
    public void testInvalidWhenBIsZero() {
        assertEquals("Invalid", Triangle.classify(3, 0, 4));
    }

    @Test
    public void testInvalidWhenCIsZero() {
        assertEquals("Invalid", Triangle.classify(3, 4, 0));
    }

    @Test
    public void testNotTriangleWhenABLessThanOrEqualC() {
        assertEquals("Not a triangle", Triangle.classify(1, 2, 3));
    }

    @Test
    public void testNotTriangleWhenACLessThanOrEqualB() {
        assertEquals("Not a triangle", Triangle.classify(1, 3, 1));
    }

    @Test
    public void testNotTriangleWhenBCLessThanOrEqualA() {
        assertEquals("Not a triangle", Triangle.classify(3, 1, 1));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals("Equilateral", Triangle.classify(3, 3, 3));
    }

    @Test
    public void testIsoscelesWhenAEqualsB() {
        assertEquals("Isosceles", Triangle.classify(3, 3, 2));
    }

    @Test
    public void testIsoscelesWhenBEqualsC() {
        assertEquals("Isosceles", Triangle.classify(2, 3, 3));
    }

    @Test
    public void testIsoscelesWhenAEqualsC() {
        assertEquals("Isosceles", Triangle.classify(3, 2, 3));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals("Scalene", Triangle.classify(3, 4, 5));
    }
}