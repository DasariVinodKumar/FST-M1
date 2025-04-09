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

public class Activity3 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void verifyFirstInfoBoxTitle() {
		driver.get("https://alchemy.hguy.co/lms");
		WebElement firstInfoBoxTitle = driver.findElement(By.xpath("(//h3)[1]"));
		String actualTitle = firstInfoBoxTitle.getText();
		String expectedTitle = "Actionable Training";
		Assert.assertEquals(actualTitle, expectedTitle, "First info box title did not match!");

	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
