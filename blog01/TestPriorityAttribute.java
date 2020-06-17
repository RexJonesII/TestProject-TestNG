package testproject.blog01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPriorityAttribute 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setUp ()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();		
		driver.get("https://testproject.io/");
	}
	
	@AfterMethod
	public void tearUp ()
	{
		driver.quit ();
	}
	
	@Test (priority = 1)
	public void readTestProjectBlog ()
	{
		driver.findElement(By.linkText("Blog")).click();
	}
	
	@Test (priority = 2)
	public void freeTestProjectSignUp ()
	{
		driver.findElement(By.linkText("Free Sign Up")).click();
	}
	
	@Test (priority = 3)
	public void logIntoTestProject ()
	{
		driver.findElement(By.linkText("Login")).click();
	}
}
