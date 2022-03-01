import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void testEmptyStringReturnsZero() {
        assertEquals(0, new StringCalculator().Add(""));
    }

    @Test
    public void testSingleIntegerSum() {
        assertEquals(10, new StringCalculator().Add("10"));
    }
}
