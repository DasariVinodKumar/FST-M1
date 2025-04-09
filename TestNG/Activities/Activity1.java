package Project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void verifyTitle() {
		driver.get("https://alchemy.hguy.co/lms");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Alchemy LMS – An LMS Application";
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not match!");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
