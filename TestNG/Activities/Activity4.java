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

public class Activity4 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

    @Test
    public void verifySecondPopularCourseTitle() {
        driver.get("https://alchemy.hguy.co/lms");
        WebElement secondPopularCourse = driver.findElement(By.xpath("(//h3)[2]"));
        String actualTitle = secondPopularCourse.getText();
        String expectedTitle = "Email Marketing Strategies";
        Assert.assertEquals(actualTitle, expectedTitle, "Second most popular course title did not match!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
