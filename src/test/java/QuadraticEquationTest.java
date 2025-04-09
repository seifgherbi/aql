import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tp2.QuadraticEquation;

public class QuadraticEquationTest {

    @Test
    public void testSolve_TwoRealRoots() {
        double a = 1, b = -3, c = 2;
        double[] result = QuadraticEquation.solve(a, b, c);
        assertNotNull(result, "The result should not be null.");
        assertEquals(2, result.length, "There should be two roots.");
        assertEquals(2, result[0], 0.001, "First root should be 2.");
        assertEquals(1, result[1], 0.001, "Second root should be 1.");
    }

    @Test
    public void testSolve_OneRealRoot() {
        double a = 1, b = -2, c = 1;
        double[] result = QuadraticEquation.solve(a, b, c);
        assertNotNull(result, "The result should not be null.");
        assertEquals(1, result.length, "There should be one root.");
        assertEquals(1, result[0], 0.001, "Root should be 1.");
    }

    @Test
    public void testSolve_NoRealRoots() {
        double a = 1, b = 2, c = 5;
        double[] result = QuadraticEquation.solve(a, b, c);
        assertNull(result, "The result should be null because there are no real roots.");
    }

    @Test
    public void testSolve_aIsZero() {
        double a = 0, b = 1, c = -4;
        assertThrows(IllegalArgumentException.class, () -> {
            QuadraticEquation.solve(a, b, c);
        }, "a must not be zero");
    }
}
