package Activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Activity2 {

    // Helper method to get base URI for API requests
    private String getBaseUri() {
        return "https://petstore.swagger.io/v2/user";
    }

    @Test(priority=1)
    public void addNewUserFromFile() throws IOException {
        // Import JSON file
        FileInputStream inputJSON = new FileInputStream("src/test/java/Activities/userInfo.json");

        given()
            .baseUri(getBaseUri()) // Use helper method for base URI
            .header("Content-Type", "application/json") // Set headers
            .body(inputJSON) // Pass request body from file
        .when()
            .post() // Send POST request
        .then()
            .body("code", equalTo(200))
            .body("message", equalTo("9807"));
        
        inputJSON.close();  // Closing file input stream
    }
    
    @Test(priority=2)
    public void getUserInfo() {
        // Import JSON file to write to
        File outputJSON = new File("src/test/java/Activities/userGETResponse.json");

        Response response = given()
            .baseUri(getBaseUri()) // Use helper method for base URI
            .header("Content-Type", "application/json") // Set headers
            .pathParam("username", "justinc") // Pass path parameter
        .when()
            .get("/{username}"); // Send GET request
        
        // Get response body
        String resBody = response.getBody().asPrettyString();

        try {
            // Create JSON file if doesn't exist
            outputJSON.createNewFile();
            // Write response body to external file
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
        
        // Assertions
        response.then().body("id", equalTo(9807));
        response.then().body("username", equalTo("justinc"));
        response.then().body("firstName", equalTo("Justin"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));
    }
    
    @Test(priority=3)
    public void deleteUser() {
        Response response = given()
            .baseUri(getBaseUri()) // Use helper method for base URI
            .header("Content-Type", "application/json") // Set headers
            .pathParam("username", "justinc") // Add path parameter
        .when()
            .delete("/{username}"); // Send DELETE request

        // Assert status code and message without expecting a body
        response.then()
            .statusCode(200) // Check if status code is 200
            .body("message", equalTo("justinc")); // Check message in the response body (if returned)
    }
    }

