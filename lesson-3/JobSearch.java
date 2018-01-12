import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Job {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    private String title;
    private String location;
    private boolean fullTime;
}

public class JobSearch {
    public static void main(String[] args) throws IOException, ParseException {
        doEverything();
    }

    public static List<Job> doEverything() throws IOException, ParseException {
        System.out.println("Welcome to JobSearch!");

        String url = "https://jobs.github.com/positions.json?description=java&location=united+states&full_time=on";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = client.execute(request);

        List<Job> jobs = new ArrayList<Job>();
        try {
            HttpEntity entity = response.getEntity();
            String json = EntityUtils.toString(entity);
            JSONArray arr = (JSONArray)new JSONParser().parse(json);
            for(int i = 0; i < arr.size(); i++) {
                JSONObject obj = (JSONObject) arr.get(i);
                Job job = new Job();
                job.setTitle((String) obj.get("title"));
                if (obj.get("type").equals("Full Time")) {
                    job.setFullTime(true);
                }
                else {
                    job.setFullTime(false);
                }

                System.out.println(job.getTitle() + " (" + job.getLocation()+ ")");
                jobs.add(job);
                job.setLocation((String) obj.get("location"));
            }
        } finally {
            response.close();
        }

        return jobs;
    }
}
