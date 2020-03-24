package testproject.blog8switch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwitchToAlert {

	WebDriver driver;
	
	@BeforeTest
	public void setUp () {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}
	
	@Test
	public void demoSwitchToAlert () throws InterruptedException {
		driver.get("https://blog.testproject.io/");
		driver.switchTo().alert().accept();
	}
}