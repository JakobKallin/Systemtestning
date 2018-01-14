import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JobSearchTest {
    @Test
    public void testFullTime() throws IOException, ParseException {
        Http stub = (String url) -> "[" +
                "{" +
                "\"id\": \"836833fc-f721-11e7-8122-5b9680380cb1\"," +
                "\"created_at\": \"Thu Jan 11 22:49:04 UTC 2018\"," +
                "\"title\": \"Software Engineer, Protein Sciences, Genentech Research\"," +
                "\"location\": \"South San Francisco\"," +
                "\"type\": \"Full Time\"," +
                "\"description\": \"test test\"," +
                "\"url\": \"http://jobs.github.com/positions/836833fc-f721-11e7-8122-5b9680380cb1\"" +
                "}" +
                "]";
        List<Job> jobs = JobSearch.getJobs("Java", "United States", stub);

        assertTrue(jobs.get(0).isFullTime() == true);
    }

    @Test
    public void testDefaultFullTime() throws IOException, ParseException {
        Http stub = (String url) -> "[" +
                "{" +
                "\"id\": \"836833fc-f721-11e7-8122-5b9680380cb1\"," +
                "\"created_at\": \"Thu Jan 11 22:49:04 UTC 2018\"," +
                "\"title\": \"Software Engineer, Protein Sciences, Genentech Research\"," +
                "\"location\": \"South San Francisco\"," +
                "\"description\": \"test test\"," +
                "\"url\": \"http://jobs.github.com/positions/836833fc-f721-11e7-8122-5b9680380cb1\"" +
                "}" +
                "]";

        List<Job> jobs = JobSearch.getJobs("Java", "United States", stub);

        assertTrue(jobs.get(0).isFullTime() == true);
    }
}