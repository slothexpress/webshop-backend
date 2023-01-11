package kodtest.omegapoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@org.springframework.stereotype.Service
public class Service {

    public Service() {
    }

    public void fetchAPI() {
        String line;
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL("https://kodtest.azurewebsites.net/api/products?code=MWZOJunmBNEPDGxldyIKSplsqq/8Sv4c6KvgZ1vyh4Z9wCaw6rqJIA==");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            if(responseCode == 200) {
                BufferedReader data = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while((line = data.readLine()) != null) {
                    content.append(line);
                }
            }
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Fetch threw exception: " + e);
        }
    }
}
