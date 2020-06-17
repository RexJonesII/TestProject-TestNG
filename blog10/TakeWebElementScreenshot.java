package io.testproject.blog10;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeWebElementScreenshot {
	WebDriver driver;
	
	@BeforeClass
	public void setUp () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testproject.io/");
	}
	
	@Test 
	public void takeTestProjectBenefitsScreenshot () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		
		driver.findElement(By.id("cc-button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);		
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//div[@id='mm-0\']/div[1]/section[1]/div/div[2]")));
		
		WebElement benefitsTestProject = driver.findElement
				(By.cssSelector(".section-benefits"));		
		
		File source = benefitsTestProject.getScreenshotAs(OutputType.FILE);						
		File destination = new File(System.getProperty("user.dir") + 
				"/src/test/java/io/testproject/blog10/TestProject Benefits.png");
		
		try 
		{
			FileHandler.copy(source, destination);
		} 
		catch (IOException exc) 
		{
			exc.printStackTrace();
		}				
		System.out.println("Screenshot Located At " + destination);
		}	
	
	@AfterClass
	public void tearDown () {
		driver.quit();
	}
}
