package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDefinitions {
    WebDriver driver = util.DriverFactory.getDriver();
    LoginPage loginpage = new LoginPage(driver);

    @When("Username entry is successful.")
    public void usernameEntryIsSuccessful() {
        loginpage.Username();
    }

    @When("Password entry is successful.")
    public void passwordEntryIsSuccessful() {
//        JavascriptExecutor jsb = (JavascriptExecutor) driver;
//        jsb.executeScript("window.scrollBy(0,150)");
        loginpage.Password();
    }

    @When("Click on the Login button.")
    public void clickOnTheLoginButton() {
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("window.scrollBy(0,250)");
        loginpage.LoginButton();
    }

    @Then("Successful login is checked")
    public void successfulLoginIsChecked() {
        loginpage.LoginChecked();
    }

    @Then("the warning message is checked.")
    public void theWarningMessageIsChecked() {
        loginpage.WarningMessage();
    }

    @Then("The password warning message is checked.")
    public void thePasswordWarningMessageIsChecked() {
        loginpage.PasswordControl();
    }

    @When("Invalid username entered")
    public void ınvalidUsernameEntered() {
        JavascriptExecutor jsd = (JavascriptExecutor) driver;
        jsd.executeScript("window.scrollBy(0,250)");
        loginpage.invalidusernme();
    }

    @Then("The error message is checked.")
    public void theErrorMessageIsChecked() {
        loginpage.ErrorMessage();
    }

    @When("Invalid Password entered")
    public void ınvalidPasswordEntered() {
        loginpage.invalidpassword();
    }
}
