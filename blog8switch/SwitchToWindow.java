package testproject.blog8switch;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwitchToWindow {

	WebDriver driver;
	
	@BeforeTest
	public void setUp () {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void demoSwitchToWindow () 	{
		driver.get("https://testproject.io/");
		driver.findElement(By.id("menu-item-1727")).click();
		String mainHandle = driver.getWindowHandle();
		System.out.println("Home Page Window ID: " + mainHandle + "\n");
				
		Set <String> allHandles = driver.getWindowHandles();
		System.out.println("Windows Open After Clicking The Docs Link via Home Page: " + allHandles.size() + "\n");
		
		for (String windowHandle : allHandles) {
			if(mainHandle.equals(windowHandle)) {
				System.out.println("\t Window ID 1: \t" + windowHandle +
												"\n \t URL: \t \t" + driver.getCurrentUrl() +						
												"\n \t Title: \t \t" + driver.getTitle());				
			}	
			else	{
				driver.switchTo().window(windowHandle);
				
				System.out.println("\t Window ID 2: \t" + windowHandle +
						"\n \t URL: \t \t" + driver.getCurrentUrl() +						
						"\n \t Title: \t \t" + driver.getTitle());					
			}
		}
	}
}