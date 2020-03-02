package testproject.blog5webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementMethods {
	WebDriver driver;
	
	@BeforeClass 
	public void setUp () {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();		
		driver.get("https://blog.testproject.io/");	
	}
	
	@Test
	public void demoWebElementMethods () {
		 WebElement linkLogin = driver.findElement(By.id("menu-item-7501"));		 
		 linkLogin.click();
		
		 driver.findElement(By.id("username")).sendKeys("Rex.Jones@Test4Success.org");
		 driver.findElement(By.id("password")).sendKeys("FakePassword");	
		 driver.findElement(By.id("tp-sign-in")).click();
		 
		 String errorMessage = driver.findElement(By.id("tp-message-error")).getText();
		 System.out.println("What Is The Error Message? " + errorMessage);
		 
		 String holderPassword = driver.findElement(By.id("password")).getAttribute("placeholder");
		 System.out.println("Which Sign In Credential Is Incorrect? " + holderPassword);
		 
		 driver.findElement(By.id("username")).clear();
		 
		 WebElement linkSignUpForFree = driver.findElement(By.id("tp-signup-link"));
		 boolean isSignUpForFreeLinkDisplayed = linkSignUpForFree.isDisplayed();
		 System.out.println("Is The Sign Up For Free Link Displayed? " + isSignUpForFreeLinkDisplayed);
		 linkSignUpForFree.click();
		 
		 boolean isSignUpButtonEnabled = driver.findElement(By.id("tp-sign-up")).isEnabled();
		 System.out.println("Is The Sign Up Button Enabled? " + isSignUpButtonEnabled);
	}

	@AfterClass
	public void tearDown () {
		//driver.quit();
		//driver.close();
	}
}