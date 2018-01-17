import org.junit.Test;

import static org.junit.Assert.*;

public class LanguageTest {
    @Test
    public void testStringWithManyVowels() {
        String s = "Jakob";
        int result = Language.vowelCount(s);
        assertEquals(2, result);
    }

    @Test
    public void testStringWithOneVowel() {
        String s = "Hi";
        int result = Language.vowelCount(s);
        assertEquals(1, result);
    }

    @Test
    public void testNullString() {
        String s = null;
        int result = Language.vowelCount(s);
        assertEquals(0, result);
    }

    @Test
    public void testEmptyString() {
        String s = "";
        int result = Language.vowelCount(s);
        assertEquals(0, result);
    }
}