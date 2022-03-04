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

    @Test
    public void testAddOnUnknownString() {
        assertEquals(70, new StringCalculator().Add("10,10,50"));
    }

    @Test
    public void testAddOnNewRow() {
        assertEquals(6, new StringCalculator().Add("1\n2,3"));
    }
}
