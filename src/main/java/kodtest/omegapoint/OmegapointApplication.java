package kodtest.omegapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@SpringBootApplication
public class OmegapointApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(OmegapointApplication.class, args);

		URL url = new URL("https://kodtest.azurewebsites.net/api/products?code=MWZOJunmBNEPDGxldyIKSplsqq/8Sv4c6KvgZ1vyh4Z9wCaw6rqJIA==");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		int responseCode = connection.getResponseCode();

		if(responseCode == 200) {
			BufferedReader data = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			StringBuffer content = new StringBuffer();

			while((line = data.readLine()) != null) {
				content.append(line);
			}
			System.out.println(content);
		}

	}

}
