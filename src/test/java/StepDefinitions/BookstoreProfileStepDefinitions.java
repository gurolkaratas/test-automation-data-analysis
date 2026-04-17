package StepDefinitions;

import Pages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BookstoreProfileStepDefinitions {
    WebDriver driver = util.DriverFactory.getDriver();
    ProfilePage profilepage = new ProfilePage(driver);


    @When("User selects Show {int} from the dropdown")
    public void userSelectsShowFromTheDropdown(int arg0) {
        JavascriptExecutor jsu = (JavascriptExecutor) driver;
        jsu.executeScript("window.scrollBy(0,350)");

    }

    @Then("Book list container should adjust height to fit rows")
    public void bookListContainerShouldAdjustHeightToFitRows() {
        profilepage.HeightControl();
    }

    @And("No layout issues or overlapping elements should occur")
    public void noLayoutIssuesOrOverlappingElementsShouldOccur() {
        profilepage.LayoutCheck();
    }


    @When("Click on the Go to book store button.")
    public void clickOnTheGoToBookStoreButton() {
//        JavascriptExecutor jsa = (JavascriptExecutor) driver;
//        jsa.executeScript("window.scrollBy(0,450)");
        profilepage.BookStoreClick();
    }

    @Then("Check that the book store page is opened.")
    public void checkThatTheBookStorePageIsOpened() {
        profilepage.BookStoreControl();
    }

    @When("Click on the Delete all books")
    public void clickOnTheDeleteAllBooks() {
        JavascriptExecutor jsb = (JavascriptExecutor) driver;
        jsb.executeScript("window.scrollBy(0,450)");
        profilepage.DeleteallBooks();
    }

    @Then("The pop-up that appears on the screen is verified")
    public void thePopUpThatAppearsOnTheScreenIsVerified() {
        profilepage.PopUpControl();
    }

    @When("Click on the {string} button in the pop-up.")
    public void clickOnTheButtonInThePopUp(String arg0) {
        profilepage.OkButton();
    }

    @Then("the message that pops up on the screen is checked")
    public void theMessageThatPopsUpOnTheScreenIsChecked() {
        profilepage.MessageControl();
    }

    @Then("Check that you are back to the profile screen.")
    public void checkThatYouAreBackToTheProfileScreen() {
        profilepage.CancelButtonSuccesfull();
    }

    @When("Click on the Cancel button in the pop-up.")
    public void clickOnTheCancelButtonInThePopUp() {
        profilepage.CancelButton();
    }

    @When("delete accounts button controls")
    public void deleteAccountsButtonControls() {
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("window.scrollBy(0,450)");
        profilepage.DeleteAcounts();
    }

    @Then("The pop-up that opens is checked.")
    public void thePopUpThatOpensIsChecked() {
        profilepage.PopUpChceck();
    }

    @Then("It is seen that the popup closes and you return to the profile screen.")
    public void ıtIsSeenThatThePopupClosesAndYouReturnToTheProfileScreen() {
        profilepage.CancelButtonClosed();
    }

    @Then("Check the message that appears on the screen")
    public void checkTheMessageThatAppearsOnTheScreen() {
        profilepage.SuucesfulPopUpControl();
    }

    @When("Click on the logout button.")
    public void clickOnTheLogoutButton() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, -450)");
        profilepage.LogoutButton();
    }

    @Then("It is checked that the exit is successful.")
    public void ıtIsCheckedThatTheExitIsSuccessful() {
        JavascriptExecutor jsd = (JavascriptExecutor) driver;
        jsd.executeScript("window.scrollBy(0,350)");
        profilepage.LogoutContol();
    }

    @When("add book to profile")
    public void addBookToProfile() {
        profilepage.Addbook();
    }

    @Then("check if the book appears on your profile")
    public void checkIfTheBookAppearsOnYourProfile() {
        profilepage.AddProfile();
    }
    @When("click on a book")
    public void clickOnABook() {
//        JavascriptExecutor jsa = (JavascriptExecutor) driver;
//        jsa.executeScript("window.scrollBy(0,350)");
        profilepage.ClickBook();
    }

    @Then("The book detail page is examined")
    public void theBookDetailPageIsExamined() {
        profilepage.BookDetail();
    }
}
