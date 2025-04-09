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

public class Activity5 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void testNavigateToMyAccountPage() {
		driver.get("https://alchemy.hguy.co/lms");
		WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
		myAccountLink.click();
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("My Account"), "Page title did not contain 'My Account'.");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
