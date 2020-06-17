package testproject.blog06navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigationMethods {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void demoNavigationMethods() {
		driver.navigate().to("https://blog.testproject.io/");
		System.out.println("To Title: " + driver.getTitle());

		driver.findElement(By.id("menu-item-7501")).click();
		driver.findElement(By.id("username")).sendKeys("Rex.Jones@Test4Success.org");
		driver.navigate().refresh();
		System.out.println("Refresh Title: " + driver.getTitle());

		driver.navigate().back();
		System.out.println("Back Title: " + driver.getTitle());

		driver.navigate().forward();
		System.out.println("Forward Title: " + driver.getTitle());
	}
}























