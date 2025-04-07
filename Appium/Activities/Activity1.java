package examples;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class Activity1 {

	//Driver declaration
	AppiumDriver driver;
	
	//set up function
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		//set desire capabilities
		UiAutomator2Options options = new UiAutomator2Options().
		setPlatformName("android").
		setAutomationName("UiAutomator2").
		setAppPackage("com.google.android.calculator").
		setAppActivity("com.android.calculator2.Calculator").
		
		noReset();
	
		//set Appium server URL
		URL serverURL = new URI("http://127.0.0.1:4723").toURL();
		
		
		//intilize driver
		driver = new AndroidDriver(serverURL,options);
		
		
	}
	@Test
	public void calculatorTest() {
		//Find and tap the  digit 8
		driver.findElement(AppiumBy.id("digit_8")).click();
		
		//Find and tap the multiply symbol
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		
		//Find and tap the  digit 3
		driver.findElement(AppiumBy.id("digit_3")).click();
		
		//Find and tap the equal symbol
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
	   //Find and get the result text
		String result = driver.findElement( AppiumBy.id("result_final")).getText();
		
	   //Asseration
		assertEquals(result,"24");
		
	}
	
	@AfterClass
	public void tearDown() {
		//close the broswer
		driver.quit();
	}
	
}
