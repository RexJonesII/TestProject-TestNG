package tutorials.testproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

  WebDriver driver;

  @Test
  @Parameters ( {"BrowserType"} )
  public void testExamplePageOnMultipleBrowsers (String browserType) {
    if (browserType.equalsIgnoreCase("Chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    }
    else if (browserType.equalsIgnoreCase("Edge")) {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    }
    else if (browserType.equalsIgnoreCase("Firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    }
    driver.manage().window().maximize();
    driver.get("https://example.testproject.io/web/index.html");
    System.out.println(browserType + ": " + driver.getTitle());
  }
}
