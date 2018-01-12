import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class JobSearch {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to JobSearch!");

        String url = "https://jobs.github.com/positions.json?description=java&location=united+states&full_time=on";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = client.execute(request);
        try {
            HttpEntity entity = response.getEntity();
            String json = EntityUtils.toString(entity);
            System.out.println(json);
        } finally {
            response.close();
        }
    }
}
