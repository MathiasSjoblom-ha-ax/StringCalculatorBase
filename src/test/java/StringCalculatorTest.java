import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void testAddOnEmptyStringReturnsZero() {
        assertEquals(0, new StringCalculator().Add(""));
    }

    @Test
    public void testAddOnSingleIntegerSum() {
        assertEquals(10, new StringCalculator().Add("10"));
    }
}
