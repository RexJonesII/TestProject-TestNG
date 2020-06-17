package io.testproject.blog11;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class DifferentImportStatements {

	WebDriver driver;
	
	@Test
	public void useRelativeLocatorInSyntax () {
		driver.findElement(RelativeLocator.withTagName(""));
	}
	
	@Test
	public void skipRelativeLocatorInSyntax () {
		driver.findElement(withTagName(""));
	}
}

