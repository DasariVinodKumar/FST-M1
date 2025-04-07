package Activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	// Declare request specification
	RequestSpecification requestSpec;
	// Declare response specification
	ResponseSpecification responseSpec;

	@BeforeClass
	public void setUp() {
		// Create request specification
		requestSpec = new RequestSpecBuilder()
			.addHeader("Content-Type", "application/json")
			.setBaseUri("https://petstore.swagger.io/v2/pet")
			.build();

		responseSpec = new ResponseSpecBuilder()
			// Check status code in response
			.expectStatusCode(200)
			.expectContentType(ContentType.JSON)
			.expectBody("status", equalTo("alive"))
			// Build response specification
			.build();
	}

	@DataProvider(name = "petInfo")
	public Object[][] petInfoProvider() {
		// Setting parameters to pass to test case
		Object[][] testData = new Object[][] { 
			{ 77232, "Riley", "alive" }, 
			{ 77233, "Hansel", "alive" } 
		};
		return testData;
	}

	@Test(priority = 1, dataProvider = "petInfo")
	// Test case using a DataProvider
	public void addPets(int petId, String petName, String petStatus) {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		given().spec(requestSpec) 
			.body(reqBody) 
		.when()
			.post() // Send POST request
		.then().spec(responseSpec) // Assertions using responseSpec
		.body("name", equalTo(petName)) // Additional Assertion
		.log().all(); // Log for request details
	}

	@Test(priority = 2, dataProvider = "petInfo")
	// Test case using a DataProvider
	public void getPets(int petId, String petName, String petStatus) {
		given().spec(requestSpec) // Use requestSpec
			.pathParam("petId", petId) // Add path parameter
			.log().all() // Log for request details
		.when()
			.get("/{petId}") // Send GET request
		.then().spec(responseSpec) // Assertions using responseSpec
		    .body("name", equalTo(petName)) // Additional Assertion
		    .log().all(); // Log for request details
	}

	@Test(priority = 3, dataProvider = "petInfo")
	public void deletePets(int petId, String petName, String petStatus) {
		given().spec(requestSpec) // Use requestSpec
			.pathParam("petId", petId) // Add path parameter
		.when()
			.delete("/{petId}") // Send DELETE request
		.then()
			.statusCode(200) // Expect 200 OK response
			.body("message", equalTo("" + petId)) // Check if message returns petId
			.log().all(); // Log for request details
	}
}
