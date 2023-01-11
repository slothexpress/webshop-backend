package kodtest.omegapoint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class OmegapointApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(OmegapointApplication.class, args);

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
