package Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	
	WebDriver driver;
	WebDriverWait wait;
    String username = "root";  
    String password = "pa$$w0rd";  

    @BeforeMethod
    public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

    @Test
    public void testLogin() {
        // Step a: Open the browser and navigate to the site
        driver.get("https://alchemy.hguy.co/lms");

        // Step b: Find the navigation bar and locate the "My Account" link
        WebElement myAccountLink = driver.findElement(By.linkText("My Account"));

        // Step c: Click the "My Account" link
        myAccountLink.click();

        // Step d: Read the page title and verify you're on the correct page
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("My Account"), "Page title did not contain 'My Account'.");

        // Step e: Find the "Login" button and click it
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        // Step f: Find the username field and enter the username
        WebElement usernameField = driver.findElement(By.id("user_login"));
        usernameField.sendKeys(username);

        // Step g: Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        passwordField.sendKeys(password);

        // Step h: Find the login button and click it
        WebElement submitButton = driver.findElement(By.id("wp-submit"));
        submitButton.click();

        // Step i: Verify successful login
        // Check if the user has logged in by verifying a page element after login (like a profile link or logout button)
        WebElement profileLink = driver.findElement(By.linkText("Profile"));
        Assert.assertTrue(profileLink.isDisplayed(), "Profile link not displayed, login may have failed.");

        // Optionally, you can verify the URL or title for further confirmation:
        // String currentUrl = driver.getCurrentUrl();
        // Assert.assertTrue(currentUrl.contains("dashboard"), "User not redirected to dashboard after login.");
    }

    @AfterMethod
    public void tearDown() {
        // Step j: Close the browser
        driver.quit();
    }

}
