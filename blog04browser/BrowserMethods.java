package testproject.blog04browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserMethods {
	WebDriver driver;
	
	@BeforeClass 
	public void setUp () {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();		
	}
	
	@Test
	public void demoBrowserMethods () {
		driver.get("https://blog.testproject.io/");	
		
		String urlTestProject = driver.getCurrentUrl();
		System.out.println("What Is Test Project's Current URL? " + urlTestProject);
		
		String titleTestProject = driver.getTitle();
		System.out.println("What Is Test Project's Page Title? " + titleTestProject);
	}

	@AfterClass
	public void tearDown () {
		//driver.quit();
		//driver.close();
	}
}