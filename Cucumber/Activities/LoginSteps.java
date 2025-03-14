package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps extends BaseClass {
	@Given("the user is on the login page")
	public void openPage() {
		// Open the login page
		driver.get("https://training-support.net/webelements/login-form");
		// Assert page title
		assertEquals("Selenium: Login Form", driver.getTitle());
	}
	@When("the user enters username and password")
	public void enterCredentials() {
		// Find username field and enter username
		driver.findElement(By.id("username")).sendKeys("admin");
		// Find password field and enter password
		driver.findElement(By.id("password")).sendKeys("password");
		// To get the entered values
		String enteredUsername = driver.findElement(By.id("username")).getAttribute("value");
		// System.out.println("Username field has " + enteredUsername);
		assertEquals(enteredUsername, "admin");
	}
	@When("the user enters {string} and {string}")
	public void enterCredentialswithparams(String username,String password) {
		// Find username field and enter username
		driver.findElement(By.id("username")).sendKeys(username);
		// Find password field and enter password
		driver.findElement(By.id("password")).sendKeys(password);
		// To get the entered values
		String enteredUsername = driver.findElement(By.id("username")).getAttribute("value");
		 System.out.println("Username field has " + enteredUsername);
		assertEquals(enteredUsername, "admin");
	}
//	}
	@And("clicks the submit button")
	public void clickSubmit() {
		// Find the submit button and click it
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	@Then("get the confirmation message and verify it")
	public void getMessage() {
		String message = driver.findElement(By.tagName("h1")).getText();
		assertEquals("Login Success!", message);
	}
	
@Then("get the confirmation text and verify message as {string}")
   public void confirmMessageAsInput(String expectedMessage) {
		// Find the confirmation message
		String message = "NOT FOUND";
		if (expectedMessage.contains("Invalid")) {
		message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2#subheading")))
				.getText();
		}
		else {
			message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5")))
					.getText();
		}
	 wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"),"Welcome"));
		String message1 = driver.findElement(By.cssSelector("h2.mt-5")).getText();
	// Assert message
	assertEquals(expectedMessage, message1);
}
}