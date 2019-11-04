package testproject.blog2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting 
{
	WebDriver driver;
	
	@Test		
	@Parameters ( {"URL", "BrowserType"} )	
	public void accessTestProjectBlog (String url, String browserType)
	{
		if (browserType.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/Rex Allen Jones II/Downloads/Drivers/geckodriver.exe");
			driver = new FirefoxDriver ();
		}
		else if (browserType.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver ();
		}
		else
		{
			System.out.println("Not A Valid Browser");
		}
				
		driver.manage().window().maximize();
		driver.get(url);
				
		System.out.println("\n" + "Open " + browserType);
		System.out.println("   " +  driver.getTitle());
		System.out.println("   " +  driver.findElement(By.cssSelector("div.join-us h3")).getText());
		System.out.println("Close " + browserType + "\n");
			
		driver.quit();
	}
}