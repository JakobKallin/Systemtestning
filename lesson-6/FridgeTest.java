import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
public class FridgeTest {
    private Fridge fridge;

    @Before
    public void setup() {
        fridge = new Fridge();
    }

    @Test
    public void testPutAndContains() {
        fridge.put("cheese");
        assertEquals(true, fridge.contains("cheese"));
    }

    @Test
    public void testPutSameTwice() {
        fridge.put("cheese");
        boolean result = fridge.put("cheese");
        assertEquals(false, result);
    }

    @Test
    public void testGetFromEmpty() {
        assertEquals(false, fridge.contains("ham"));
    }

    @Test
    public void testPutDifferentTwice() {
        fridge.put("cheese");
        fridge.put("ham");
        assertEquals(true, fridge.contains("cheese"));
        assertEquals(true, fridge.contains("ham"));
    }

    @Test
    public void testItemDoesNotExist() {
        try {
            fridge.take("sausage");
            fail("No exception was thrown");
        }
        catch (NoSuchItemException e) {
            assertTrue(e.getMessage().contains("sausage"));
        }
    }

    @Test
    public void testCanTakeItemFromFridge() throws NoSuchItemException {
        List<String> food = new ArrayList<String>();
        food.add("yogurt");
        food.add("milk");
        food.add("eggs");
        for (String item : food) {
            fridge.put(item);
            assertEquals(true, fridge.contains(item));
            fridge.take(item);
            assertEquals(false, fridge.contains(item));
        }
    }
}