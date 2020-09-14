package dockerDemo;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class setup_DockerGrid {
	
//	@Test(priority=1)
	@BeforeTest
	void startDockerGrid() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start F:\\WorkSpace\\com.restAssured\\Resources\\Docker_Asset\\start_dockerGrid.bat");
//		Runtime.getRuntime().exec("cmd /c start start_dockerGrid.bat"); // If bat file is present in project root location
		Thread.sleep(20000);
	}
	
	
//	@Test(priority=2)
	@AfterTest
	void stopDockerGrid() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start F:\\WorkSpace\\com.restAssured\\Resources\\Docker_Asset\\stop_dockerGrid.bat");
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe"); // to close all cmd windows
	}

	
}
