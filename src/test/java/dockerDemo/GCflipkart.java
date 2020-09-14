package dockerDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GCflipkart {
	
	@Test
	public void GoogleChromeCheck() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
// OR
//		DesiredCapabilities cap = DesiredCapabilities.firefox();
//		cap.setBrowserName(BrowserType.FIREFOX);

//		URL url new URL("http://localhost:4545/wd/hub");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), cap); 
		// instead of http://localhost:4545/grid/console
		// here port 4545 is the port where Selenium Hub is running (can be verified by "docker ps")
		
		driver.get("https://flipkart.com/plus");
		System.out.println(driver.getTitle());
		
		Thread.sleep(1000);
		driver.quit();
	}

}
