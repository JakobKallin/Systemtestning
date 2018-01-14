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
import java.util.Scanner;

public class JobSearch {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Welcome to JobSearch!");
        Scanner scan = new Scanner(System.in);

        System.out.print("Keyword: ");
        String keyword = scan.nextLine();

        System.out.print("Location: ");
        String location = scan.nextLine();

        List<Job> jobs = getJobs(keyword, location, new HttpImpl());
        for (Job job : jobs) {
            System.out.println(job.getTitle() + " (" + job.getLocation()+ ")");
        }
    }

    public static List<Job> getJobs(String keyword, String location, Http http) throws IOException, ParseException {
        String url =
                "https://jobs.github.com/positions.json?"+
                        "location=" + location.replace(' ', '+') +
                        "&description=" + keyword.replace(' ', '+') +
                        "&full_time=on";
        String json = http.get(url);

        List<Job> jobs = new ArrayList<Job>();
        JSONArray arr = (JSONArray)new JSONParser().parse(json);
        for(int i = 0; i < arr.size(); i++) {
            JSONObject obj = (JSONObject) arr.get(i);
            Job job = new Job();
            job.setTitle((String) obj.get("title"));
            if (!obj.containsKey("type")) {
                job.setFullTime(true);
            }
            else if (obj.get("type").equals("Full Time")) {
                job.setFullTime(true);
            }
            else {
                job.setFullTime(false);
            }

            jobs.add(job);
            job.setLocation((String) obj.get("location"));
        }

        return jobs;
    }
}
