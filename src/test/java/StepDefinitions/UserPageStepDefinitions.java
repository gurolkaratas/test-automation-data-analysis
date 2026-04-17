package StepDefinitions;

import Pages.UserPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

import static org.testng.AssertJUnit.assertEquals;

public class UserPageStepDefinitions {
    WebDriver driver = util.DriverFactory.getDriver();
    UserPage userpage = new UserPage(driver);



    @Given("Demoqa page opens")
    public void demoqaPageOpens() {
        userpage.DemoqaOpened();
    }

    @When("Click on Elements")
    public void clickOnElements() {
        userpage.ClickElements();

    }

    @When("Click on Book Store Application")
    public void clickOnBookStoreApplication() {
        userpage.ClickBook();
    }

    @When("Click on the login option")
    public void clickOnTheLoginOption() {
        userpage.ClickLogin();
    }

    @Then("Check if the new user page is opened")
    public void checkIfTheNewUserPageIsOpened() {
        userpage.CheckNewUserPage();
    }

    @When("Click on the New User button")
    public void clickOnTheNewUserButton() {
        userpage.ClickNewUser();
    }

    @Then("The Register page is checked.")
    public void theRegisterPageIsChecked() {
        userpage.CheckRegister();
    }

    @When("First Name is entered in accordance with the rules")
    public void firstNameIsEnteredInAccordanceWithTheRules() {
        userpage.FirstName();
    }

    @When("Last Name is entered in accordance with the rules")
    public void lastNameIsEnteredInAccordanceWithTheRules() {
        userpage.LastName();
    }

    @When("Usurname is entered in accordance with the rules")
    public void usurnameIsEnteredInAccordanceWithTheRules() {
        userpage.UsurName();

    }

    @When("Password is entered in accordance with the rules")
    public void passwordIsEnteredInAccordanceWithTheRules() {
        userpage.Password();
    }

    @When("Recaptcha is bypassed manually")
    public void recaptchaIsBypassedManually() {

        System.out.println("Lütfen manuel olarak reCAPTCHA'yı geçin.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


        @When("Click on the Register button")
    public void clickOnTheRegisterButton() {
        userpage.Register();
    }

    @Then("User checks successful registration message")
    public void userChecksSuccessfulRegistrationMessage() {
        userpage.SuccessfulControl();
    }

    @When("Click on the back to login button.")
    public void clickOnTheBackToLoginButton() {
        userpage.BacktoLogin();
    }

    @Then("The first name box is checked.")
    public void thefirstnameBoxIsChecked() {
        userpage.FirtNameControl();
    }

    @Then("The Last name box is checked.")
    public void theLastNameBoxIsChecked() {
        userpage.LastNameControl();
    }

    @Then("The User name box is checked.")
    public void theUserNameBoxIsChecked() {
        userpage.UserNameControl();
    }

    @Then("The Password box is checked.")
    public void thePasswordBoxIsChecked() {
        userpage.PasswordControl();
    }

    @When("Enter a password shorter than eight characters")
    public void enterAPasswordShorterThanEightCharacters() {
        userpage.PasswordCharacterLimit();
    }

    @Then("The warning that appears is checked")
    public void theWarningThatAppearsIsChecked() {
        userpage.MessageControl();
    }

    @When("Enter a password containing only lowercase letters")
    public void enterAPasswordContainingOnlyLowercaseLetters() {
        userpage.PassworLowercase();
    }

    @When("Enter a password containing only uppercase letters")
    public void enterAPasswordContainingOnlyUppercaseLetters() {
        userpage.PasswordUppercase();
    }

    @When("Enter a password that does not contain any special characters.")
    public void enterAPasswordThatDoesNotContainAnySpecialCharacters() {
        userpage.SpecialCharacters();
    }

    @When("Enter a password that does not contain letters")
    public void enterAPasswordThatDoesNotContainLetters() {
        userpage.NoLetters();

    }

    @When("Enter a password that does not contain numbers.")
    public void enterAPasswordThatDoesNotContainNumbers() {
        userpage.NoNumbers();

    }

    @Then("Robot tick warning message")
    public void robotTickWarningMessage() {
        userpage.RobotTickMessage();
    }
}
