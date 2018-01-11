import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {
    @Test
    public void testIfStringComesBackReversed() {
        String name = "Jakob";
        String result = StringUtils.reverse(name);
        assertEquals("bokaJ", result);
    }

    @Test(expected = NullPointerException.class)
    public void testNullString() {
        String name = null;
        StringUtils.reverse(name);
    }

    @Test
    public void testEmptyString() {
        String name = "";
        String result = StringUtils.reverse(name);
        assertEquals("", result);
    }

    @Test
    public void testWhitespaceString() {
        String name = " ";
        String result = StringUtils.reverse(name);
        assertEquals(" ", result);
    }

    @Test
    public void testOddLength() {
        String name = "12345";
        String result = StringUtils.reverse(name);
        assertEquals("54321", result);
    }

    @Test
    public void testEvenLength() {
        String name = "1234";
        String result = StringUtils.reverse(name);
        assertEquals("4321", result);
    }

    @Test
    public void testTooLongEmailAddress() {
        String email = "";
        for (int i = 0; i < 400; i++) {
            email += "a";
        }
        boolean result = Email.checkIfValid(email);
        assertTrue(result);
    }
}