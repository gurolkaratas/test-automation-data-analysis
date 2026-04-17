package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class BookStoreTabPage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;

    public BookStoreTabPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.elementHelper = new util.ElementHelper(driver);

    }

    static By Bookstore = By.xpath("//span[normalize-space()='Book Store']");
    static By BookstoreTab = By.cssSelector("a[href='/books?search=9781449325862']");
    static By Searchbar = By.xpath("//input[@id='searchBox']");
    static By BookTitle = By.xpath("//a[normalize-space()='Speaking JavaScript']");
    static By Nobook = By.xpath("//*[contains(text(),'No rows found')]");

    //    static By Clickbook = By.xpath("//a[normalize-space()='Learning JavaScript Design Patterns']");
    public void bookstoretab() {
        driver.findElement(Bookstore).click();
    }

    public void BookstoretabControl() {
        WebElement Bookstoretitle = driver.findElement(BookstoreTab);
        String BookstoreTitle = Bookstoretitle.getText();
        assertEquals(BookstoreTitle, "Git Pocket Guide");
    }

    public void SearchBarControl() {
        JavascriptExecutor jsd = (JavascriptExecutor) driver;
        WebElement SearchBarElement = driver.findElement(Searchbar);
        jsd.executeScript("arguments[0].scrollIntoView(true);", SearchBarElement);
        WebElement SearchBox = driver.findElement(Searchbar);
        Assert.assertTrue(SearchBox.isDisplayed());

    }

    public void characterEntry() {
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        WebElement SearchElement = driver.findElement(Searchbar);
        jsc.executeScript("arguments[0].scrollIntoView(true);", SearchElement);
        driver.findElement(Searchbar).click();
        elementHelper.sendKey(Searchbar, "Speaking JavaScript");
    }

    public void SearchResult() {
        WebElement book = driver.findElement(BookTitle);
        Assert.assertTrue(book.isDisplayed());

    }

    public void invalidcharacter() {
        JavascriptExecutor jsg = (JavascriptExecutor) driver;
        WebElement SearchElement = driver.findElement(Searchbar);
        jsg.executeScript("arguments[0].scrollIntoView(true);", SearchElement);
        driver.findElement(Searchbar).click();
        elementHelper.sendKey(Searchbar, "Python07");
    }

    public void invalidresult() {
        JavascriptExecutor jsb = (JavascriptExecutor) driver;
        try {
            WebElement banner = driver.findElement(By.id("fixedban"));
            jsb.executeScript("arguments[0].style.display='none'", banner);
        } catch (NoSuchElementException e) {
            // Reklam yoksa hata verme
        }
        WebElement NoBookTitle = driver.findElement(Nobook);
        Assert.assertEquals(NoBookTitle.getText(), "No rows found");
    }

    public void Entercharacter() {
        driver.findElement(Searchbar).click();
        driver.findElement(Searchbar).sendKeys("Git Pocket");
        driver.findElement(Searchbar).clear();

//        WebElement character = driver.findElement(Searchbar);
//        character.click();
//        character.sendKeys("Git Pocket");
//        character.clear();

    }

    public void ListControl() {
        List<WebElement> allBooks = driver.findElements(By.cssSelector(".action-buttons a"));
        Assert.assertTrue(allBooks.size() > 0);
    }
}