package io.testproject.blog11selenium4relativelocators;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneRelativeLocator {

	WebDriver driver;
	
	@BeforeClass
	public void setUp () {
		WebDriverManager.chromedriver().setup();
		driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blog.testproject.io/");
	}

	@Test
	public void searchForBlogger () {
		WebElement searchArticles = driver.findElement(By.xpath("//section[@id='search-2']/form/label/input"));
		searchArticles.sendKeys("Rex Jones II");
		
		driver.findElement(withTagName("span")
				.toRightOf(searchArticles))
				.click();		
	}
}