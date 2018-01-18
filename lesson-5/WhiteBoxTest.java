import org.junit.Test;

import static org.junit.Assert.*;

public class WhiteBoxTest {
    @Test
    public void testOne() {
        int result = WhiteBox.russianMultiplication(5, 2);
        assertEquals(10, result);
    }
}