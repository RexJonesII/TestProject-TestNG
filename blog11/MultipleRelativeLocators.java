package io.testproject.blog11;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleRelativeLocators {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.testproject.io/");		
		
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tp-title")));
	}
	
	@Test
	public void getRememberMeText () {		
		WebElement signInButton = driver.findElement(By.id("tp-sign-in"));
		WebElement rememberMeCheckbox = driver.findElement(By.id("rememberMe"));
		
		WebElement rememberMe = driver.findElement(withTagName("span")
															.above(signInButton)
															.toRightOf(rememberMeCheckbox));
		
		System.out.println("Text = " + rememberMe.getText());		
	}
}