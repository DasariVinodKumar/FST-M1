package Activity;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
	//driver initilization
	  driver = new FirefoxDriver();
	// Initialize wait object
	  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
     //open the browser
      driver.get("https://training-support.net/webelements/login-form");
	}
	@Test(priority=1)
	public void pageTitleTest() {
		//verifying page title
		assertEquals(driver.getTitle(), "Selenium: Login Form");
	}
	@DataProvider(name="BadCredentials")
	public Object[][] creds(){
		Object[][] credentials = {
				{"admin", "wrongPassword", "Invalid credential"},
				{"wrongUser", "password","Invalid credential"},
				{"wrongUser", "WrongPassword","Invalid credential"},
				{"   ", "  ","Invalid credential"},			
		};
		
		return credentials;
	}
	
	@Test(dataProvider ="BadCredentials", priority=2)
	public void failLoginTest(String username, String password, String expectedMessage) {
		//find the form elements
		driver.navigate().refresh();
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
	
		//clear the input field
		//wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		usernameField.clear();
		passwordField.clear();
		
		//enter the value and click submit
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submitButton.click();
		
		try {
			Thread.sleep(5000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		
		//verifying the message
		String loginMessage = driver.findElement(By.id("subheading")).getText();
		Assert.assertEquals(loginMessage,expectedMessage);
		}
	}
	@AfterClass
	public void tearDown() {
		//closer the browser
		//driver.quit();
		
		
		
	
	}
}