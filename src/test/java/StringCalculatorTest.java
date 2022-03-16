import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StringCalculatorTest {

    Logger logg = mock(Logger.class);

    @BeforeEach
    public void testLoggerIsCalledOnAdd() {
        Logger mockLogger = mock(Logger.class);
        new StringCalculator(mockLogger).Add("2000");
        verify(mockLogger, times(1)).log(2000);
    }

    @Test
    public void testAddOnEmptyStringReturnsZero() {
        assertEquals(0, new StringCalculator(logg).Add(""));
    }

    @Test
    public void testAddOnSingleIntegerSum() {
        assertEquals(10, new StringCalculator(logg).Add("10"));
    }

    @Test
    public void testAddOnUnknownString() {
        assertEquals(70, new StringCalculator(logg).Add("10,10,50"));
    }

    @Test
    public void testAddOnNewRow() {
        assertEquals(6, new StringCalculator(logg).Add("1\n2,3"));
    }

    @Test
    public void testAddOnDifferentSeparator() {
        assertEquals(3, new StringCalculator(logg).Add("//;\\n1;2"));
    }

    @Test
    public void testAddOnNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new StringCalculator(logg).Add("-1,10"));
        assertEquals("Only postive numbers allowed", exception.getMessage());

    }

    @Test
    public void testAddOnBiggerThan1000() {
        assertEquals(5020, new StringCalculator(logg).Add("10,10,5000"));
    }

    @Test
    public void testMainReturnMessage() {
        //??
    }
}

