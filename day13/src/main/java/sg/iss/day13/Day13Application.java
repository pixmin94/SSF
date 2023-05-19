package sg.iss.day13;

import java.io.File;
import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day13Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Day13Application.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		List<String> opsVal = appArgs.getOptionValues("dataDir");
		System.out.println(opsVal);

		if (opsVal != null){
			//create dir
			// Utility.createDir(opsVal.get(0));
			File dir = new File(opsVal.get(0));
			boolean isDirCreated = dir.mkdirs();
			System.out.println("dir created: " + isDirCreated + "\nFile path: " + opsVal.get(0));
			if (!isDirCreated && !dir.exists()) {
				System.out.println("Failed to create directory: " + dir.getAbsolutePath());
			}
			

		} else {
			System.out.println("No data dir provided...");
			System.exit(1);
		}
		app.run(args);
	}

}
