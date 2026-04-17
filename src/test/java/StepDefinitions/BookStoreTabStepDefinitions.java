package StepDefinitions;

import Pages.BookStoreTabPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BookStoreTabStepDefinitions {
    WebDriver driver = util.DriverFactory.getDriver();
    BookStoreTabPage booktoretabpage = new BookStoreTabPage(driver);

    @When("Click on the Book Store button.")
    public void clickOnTheBookStoreButton() {
        booktoretabpage.bookstoretab();
    }

    @Then("Check that the book store screen is opened.")
    public void checkThatTheBookStoreScreenIsOpened() {
        JavascriptExecutor jsf = (JavascriptExecutor) driver;
        jsf.executeScript("window.scrollBy(0, -450)");
        booktoretabpage.BookstoretabControl();

    }

    @Then("Search Bar control")
    public void searchBarControl() {
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("window.scrollBy(0, -450)");
        booktoretabpage.SearchBarControl();
    }

    @When("Click on the search bar and enter the character.")
    public void clickOnTheSearchBarAndEnterTheCharacter() {
        booktoretabpage.characterEntry();
    }

    @Then("search result is checked")
    public void searchResultIsChecked() {
        booktoretabpage.SearchResult();
    }

    @When("Click on the search field and enter a name that does not exist")
    public void clickOnTheSearchFieldAndEnterANameThatDoesNotExist() {
        booktoretabpage.invalidcharacter();

    }

    @Then("Results are checked")
    public void resultsAreChecked() {
        booktoretabpage.invalidresult();

    }

    @When("characters are entered")
    public void charactersAreEntered() {
        booktoretabpage.Entercharacter();
    }

    @Then("the list is checked")
    public void theListIsChecked() {
        booktoretabpage.ListControl();
    }

//    @When("click on a book")
//    public void clickOnABook() {
//        JavascriptExecutor jsa = (JavascriptExecutor) driver;
//        jsa.executeScript("window.scrollBy(0,350)");
//        booktoretabpage.ClickBook();
//    }
//
//    @Then("The book detail page is examined")
//    public void theBookDetailPageIsExamined() {
//        booktoretabpage.BookDetail();
//    }

//    @When("add book to profile")
//    public void addBookToProfile() {
//        booktoretabpage.AddBook();
//    }
//
//    @Then("check if the book appears on your profile")
//    public void checkIfTheBookAppearsOnYourProfile() {
//        System.out.println("Maalesef kitap ekleme sayfası açılmamaktadır.");
//    }
}

