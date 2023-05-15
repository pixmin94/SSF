package sg.ssf.day11;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day11Application {
	private static final Logger logger = LoggerFactory.getLogger(Day11Application.class);
	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		logger.info("main method started................");
		// SpringApplication.run(Day11Application.class, args);
		SpringApplication app = new SpringApplication(Day11Application.class);

		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		List opsValue = appArgs.getOptionValues("port");

		String portNumber = null;

		if (opsValue == null || opsValue.get(0) == null){
			portNumber = System.getenv("PORT");
			if (portNumber == null){
				portNumber = DEFAULT_PORT;
			}
		} else {
			portNumber = (String) opsValue.get(0);
		}

		if (portNumber != null) {
			app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		}

		logger.info("Port number is: " + portNumber);

		app.run(args);
	}

}
