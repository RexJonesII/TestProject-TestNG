package tutorials.testproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class IndividualBrowserTesting {

  WebDriver driver;

  @Test
  public void testExamplePageOnMultipleBrowsersOnChrome () {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://example.testproject.io/web/index.html");
    System.out.println("Chrome: " + driver.getTitle());
  }

  @Test
  public void testExamplePageOnMultipleBrowsersOnFirefox () {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://example.testproject.io/web/index.html");
    System.out.println("Chrome: " + driver.getTitle());
  }

  @Test
  public void testExamplePageOnMultipleBrowsersOnEdge () {
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.get("https://example.testproject.io/web/index.html");
    System.out.println("Chrome: " + driver.getTitle());
  }

}
