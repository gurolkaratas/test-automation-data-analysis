package StepDefinitions;

import Pages.LoginTabPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BookStoreLoginTabStepDefinitions {
        WebDriver driver = util.DriverFactory.getDriver();
        LoginTabPage logintabpage = new LoginTabPage(driver);

    @When("Click on the Login tab.")
    public void clickOnTheLoginTab() {
        JavascriptExecutor jsa = (JavascriptExecutor) driver;
        jsa.executeScript("window.scrollBy(0,350)");
        logintabpage.LoginClick();
    }

    @Then("It is checked that the login page is accessed.")
    public void ıtIsCheckedThatTheLoginPageIsAccessed() {
        JavascriptExecutor jsb = (JavascriptExecutor) driver;
        jsb.executeScript("window.scrollBy(0,350)");
        logintabpage.ProfilePageControl();
    }


}
