package StepDefinitions;

import api.UserAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertNotNull;

public class UserAPISteps {
    UserAPI userAPI = new UserAPI();
    Response response;
    static String userId;

    static String username = "user" + System.currentTimeMillis();
    static String password = "Test123!";

    @When("A new user is created.")
    public void aNewUserIsCreated() {
        username = "user" + System.currentTimeMillis();
        password = "Test123!";

        response = userAPI.createUser(username, password);
        userId = response.jsonPath().getString("userID");

        System.out.println(response.asString());
    }
     @Then("The response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int arg0) {
         Assert.assertEquals(201,response.statusCode());

    }

    @And("The user should be created successfully.")
    public void theUserShouldBeCreatedSuccessfully() {
        Assert.assertTrue(response.asString().contains("userID"));
    }

    @When("A request is sent to generate token")
    public void aRequestIsSentToGenerateToken() {
        response = userAPI.generateToken(username, password);

        System.out.println(response.asString());
    }

    @Then("The response status token code should be {int}.")
    public void theResponseStatusTokenCodeShouldBe(int arg0) {
        Assert.assertEquals(200,response.statusCode());


    }

    @And("The token should be generated.")
    public void theTokenShouldBeGenerated() {
        String token = response.jsonPath().getString("token");
        assertNotNull(token);

    }
}
