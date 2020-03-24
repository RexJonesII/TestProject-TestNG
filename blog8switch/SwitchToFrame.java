package testproject.blog8switch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchToFrame {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp () {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testproject.io/platform/");
	}
	
	@Test
	public void demoSwitchToFrame1 () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("intercom-launcher-frame"));
		
		driver.findElement(By.className("e2ujk8f2")).click();
	}

	@Test
	public void demoSwitchToFrame2 () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("intercom-launcher-frame")));
		
		driver.switchTo().frame("intercom-launcher-frame");
		driver.findElement(By.className("e2ujk8f2")).click();
	}
}