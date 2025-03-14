package stepDefinitions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class FirstTest extends BaseClass {
	@Given("the user is on the TS home page")
	public void openPage() {
		// Open the TS home page
		driver.get("https://training-support.net");
		// Assertion
		assertEquals(driver.getTitle(), "Training Support");
	}
	@When("they click on the About Us link")
	public void clickLink() {
		// Find and click the About Us link
		driver.findElement(By.linkText("About Us")).click();
	}
	@Then("They are the redirected to the About page")
	public void redirectToAbout() {
		// Get the new page title and assert
		assertEquals(driver.getTitle(), "About Training Support");
	}
}