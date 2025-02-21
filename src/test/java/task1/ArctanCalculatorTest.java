package task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ArctanCalculatorTest {

    @Test
    public void testArctanZero() {
        double result = ArctanCalculator.arctan(0);
        Assertions.assertEquals(0, result, 0.01, "arctan(0) должен быть равен 0");
    }

    @Test
    public void testArctanPositiveSmallValue() {
        double x = 0.5;
        double expected = Math.atan(x);
        double result = ArctanCalculator.arctan(x);
        Assertions.assertEquals(expected, result, 0.01, "arctan(0.5) не совпадает с ожидаемым значением");
    }

    @Test
    public void testArctanNegativeSmallValue() {
        double x = -0.5;
        double expected = Math.atan(x);
        double result = ArctanCalculator.arctan(x);
        Assertions.assertEquals(expected, result, 0.01, "arctan(-0.5) не совпадает с ожидаемым значением");
    }

    @Test
    public void testArctanOne() {
        double x = 1;
        double expected = Math.PI / 4;
        double result = ArctanCalculator.arctan(x);
        Assertions.assertEquals(expected, result, 0.01, "arctan(1) должен быть равен π/4");
    }

    @Test
    public void testArctanNegativeOne() {
        double x = -1;
        double expected = -Math.PI / 4;
        double result = ArctanCalculator.arctan(x);
        Assertions.assertEquals(expected, result, 0.01, "arctan(-1) должен быть равен -π/4");
    }

    @Test
    public void testArctanOutOfRange() {
        double x = 2;
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ArctanCalculator.arctan(x);
        });
        Assertions.assertEquals("Значение x должно быть в диапазоне [-1, 1]", exception.getMessage());
    }
}
