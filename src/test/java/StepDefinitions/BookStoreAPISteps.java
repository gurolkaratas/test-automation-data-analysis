package StepDefinitions;

import api.ApiBase;
import api.BookStoreAPI;
import api.UserAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.List;
import static StepDefinitions.UserAPISteps.password;
import static StepDefinitions.UserAPISteps.username;
import static StepDefinitions.UserAPISteps.userId;

public class BookStoreAPISteps {
    Response response;
    String token;

    UserAPI userAPI = new UserAPI();

    @Given("BookStore API is ready.")
    public void bookstoreAPIIsReady() {
        ApiBase.setup();
    }

    @When("A request is sent to receive the books.")
    public void aRequestIsSentToReceiveTheBooks() {
        response = new BookStoreAPI().getBooks();
    }

    @Then("The response status code should be {int}.")
    public void theResponseStatusCodeShouldBe(int arg0) {
        Assert.assertEquals(200,response.statusCode());
    }

    @Then("The book list should not be empty")
    public void theBookListShouldNotBeEmpty() {

        System.out.println(response.asString());

        List<String> books = response.jsonPath().getList("books.title");

        Assert.assertTrue(books.size() > 0);

    }

    @And("the response time should be less than {int} seconds.")
    public void theResponseTimeShouldBeLessThanSeconds(int arg0) {

        Assert.assertTrue(response.getTime() < 3000);
    }

    @When("A request is sent to add books to the user account.")
    public void aRequestIsSentToAddBooksToTheUserAccount() {
        token = userAPI.generateToken(username,password)
                .jsonPath()
                .getString("token");

        response = new BookStoreAPI()
                .addBook(userId, token, "9781449325862");

    }

    @Then("response status add book code should be {int}")
    public void responseStatusAddBookCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.statusCode(),statusCode);
    }

    @And("A request is sent to delete the book from user account")
    public void aRequestIsSentToDeleteTheBookFromUserAccount() {

        token = userAPI.generateToken(username, password)
                .jsonPath()
                .getString("token");


        response = new BookStoreAPI()
                .deleteBook(userId, "9781449325862",token);

        System.out.println(response.asString());
    }

    @Then("response status delete book code should be {int}")
    public void responseStatusDeleteBookCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }
}
