package io.testproject.blog11selenium4relativelocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators_MultipleElements {

	WebDriver driver;	
	
	@BeforeClass
	public void setUp () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://addons.testproject.io/");		
	}
	
	@Test
	public void getAddOnPlatforms () {
		List <WebElement> allPlatforms = driver.findElements(withTagName("img")
																					.toRightOf(By.id("q")));
		for (WebElement platform : allPlatforms)
		{
			System.out.println(platform.getAttribute("alt"));
		}
	}
}