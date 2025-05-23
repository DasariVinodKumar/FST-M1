package Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void verifyHeading() {
		driver.get("https://alchemy.hguy.co/lms");
		WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'Learn from Industry Experts')]"));
		String actualHeading = heading.getText();
		String expectedHeading = "Learn from Industry Experts";
		Assert.assertEquals(actualHeading, expectedHeading, "Heading did not match!");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
