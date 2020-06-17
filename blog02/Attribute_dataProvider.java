package testproject.blog02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Attribute_dataProvider
{
	WebDriver driver;
	
	@BeforeMethod ()
	public void setUp ()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();		
		driver.get("https://blog.testproject.io/");
	}
	
	@AfterMethod ()
	public void tearDown ()
	{
		driver.quit();
	}
	
	@Test (dataProvider = "provideLogInData")	
	public void logIn (String username, String password) throws Exception 
	{
		driver.findElement(By.linkText("Login")).click();		
		driver.findElement(By.id("username")).sendKeys(username);		
		driver.findElement(By.id("password")).sendKeys(password);		
		driver.findElement(By.id("tp-sign-in")).click();

		String linkLogout = driver.findElement(By.linkText("Logout?")).getText();		
		Assert.assertEquals(linkLogout, "Logout?", "LogIn Unsuccessful - Please Try Again.");
	}
	
	@DataProvider (name = "provideLogInData")
	public Object [] [] logInData ()
	{
		Object [] [] data = new Object [3] [2];
		
		data [0] [0] = "SignUpForFree@InvalidEmail.com";		data [0] [1] = "Password_ABC";		
		data [1] [0] = "Rex.Jones@Test4Success.org";				data [1] [1] = "UseMyValidPassword";
		data [2] [0] = "InvalidLogIn@Test.com";						data [2] [1] = "InvalidPassword";	
		
		return data;
	}
}