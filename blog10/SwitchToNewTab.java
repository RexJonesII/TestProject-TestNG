package io.testproject.blog10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToNewTab {

WebDriver driver;
	
@BeforeClass
public void setUp () {
	WebDriverManager.chromiumdriver().setup();
	driver = new ChromeDriver ();
	driver.get("https://testproject.io/");	
	System.out.println(driver.getTitle());
}

@Test
public void openNewTabForTestProjectPlatform () {
	WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
	newTab.get("https://testproject.io/platform/");
	System.out.println(driver.getTitle());
}
	
	@AfterClass 
	public void tearDown () {
		//driver.quit();
	}
}
