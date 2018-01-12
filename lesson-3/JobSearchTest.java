import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JobSearchTest {
    @Test
    public void testFullTime() throws IOException, ParseException {
        List<Job> jobs = JobSearch.doEverything();

        assertTrue(jobs.get(0).isFullTime() == true);
    }
}