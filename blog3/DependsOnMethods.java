package testproject.blog3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods 
{
	WebDriver driver;
	
	@Test
	public void test1_OpenBrowser ()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();		
		driver.get("https://app.testproject.io/#/home/");
	}
	
	@Test (dependsOnMethods = "test1_OpenBrowser")
	public void test2_LogInTestProject ()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("Rex.Jones@Test4Success.org");		
		driver.findElement(By.id("password")).sendKeys("InvalidPassword");		
		driver.findElement(By.id("tp-sign-in")).click();
		
		String buttonNewTest = driver.findElement(By.className("div.new-test-button")).getText();
		Assert.assertTrue(buttonNewTest.equals("New Test"), "Username and/or Password Is Incorrect");
	}
	
	@Test (dependsOnMethods = "test2_LogInTestProject")
	public void test3_CreateNewWebTest ()
	{		
		driver.findElement(By.className("div.new-test-button")).click();
		driver.findElement(By.xpath("//div[text()='Web']")).click();
	}
	
	@Test (dependsOnMethods = { "test1_OpenBrowser", "test2_LogInTestProject" } )
	public void test4_LogOutTestProject () 
	{
		Actions act = new Actions (driver);
		act.moveToElement(driver.findElement(By.className("user-default-avatar")));
		driver.findElement(By.linkText("Logout")).click();
	}
}
