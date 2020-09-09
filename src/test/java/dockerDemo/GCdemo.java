package dockerDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GCdemo {
	
	@Test
	public void ChromeApp() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setBrowserName(BrowserType.FIREFOX);
		cap.setBrowserName(BrowserType.CHROME);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), cap); // instead of http://localhost:4545/grid/console
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
