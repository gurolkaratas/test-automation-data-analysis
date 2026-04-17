package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Pages.LoginPage.PasswordLogin;
import static Pages.LoginPage.UsernameLogin;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ProfilePage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.elementHelper = new util.ElementHelper(driver);
    }
    static By GoBookStore = By.cssSelector("#gotoStore");
    static By BookStoreControl = By.cssSelector("a[href='/books?search=9781449325862']");
    static By Clickbook = By.xpath("//a[normalize-space()='Learning JavaScript Design Patterns']");
    static By DeleteAllBook = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > button:nth-child(1)");
    static By DeleteAllBooksPopUp = By.cssSelector("#example-modal-sizes-title-sm");
    static By OkButtonPopUp = By.cssSelector("#closeSmallModal-ok");
    static By CancelButtonPopUp = By.cssSelector("#closeSmallModal-cancel");
    static By DeleteAccountBook = By.xpath("//div[@class='text-center button']//button[@id='submit']");
    static By DeleteAccountPopUp = By.cssSelector(".modal-body");
    static By LogOut = By.xpath("//div[@class='ms-auto text-end col-md-4 col-sm-12']//button[@id='submit']");
    static By SuccesfulLogout = By.cssSelector("form[id='userForm'] div h2");
    static By AddCollection = By.xpath("//div[@class='text-right fullButton']//button[@id='addNewRecordButton']");
    static By Profile = By.xpath("//span[normalize-space()='Profile']");
    static By ProileAddBook = By.xpath("//a[normalize-space()='Learning JavaScript Design Patterns']");
    public void HeightControl() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

// dropdown değişmeden önce
        Long scrollBefore = (Long) js.executeScript("return document.body.scrollHeight;");
        System.out.println("Scroll Before = " + scrollBefore);

// --- burada ben manuel dropdown’dan 10 seçiyorum ---

        System.out.println("Lütfen dropdown’dan 10 sn içinde seçim yapın...");
        try {
            Thread.sleep(10000); // manuel bekleme
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

// dropdown sonrası
        Long scrollAfter = (Long) js.executeScript("return document.body.scrollHeight;");
        System.out.println("Scroll After = " + scrollAfter);

// Kontrol
        assertTrue(scrollAfter > scrollBefore,
                "Sayfa scroll yüksekliği artmadı! before=" + scrollBefore + ", after=" + scrollAfter);

    }

    public void LayoutCheck() {

        List<WebElement> elements = driver.findElements(By.tagName("*")); // selector'ı kendine göre değiştir

        boolean overlapFound = false;

        for (int i = 0; i < elements.size(); i++) {
            WebElement e1 = elements.get(i);
            // Element görünür değilse scroll ile görünür yap
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);

            int x1 = e1.getLocation().getX();
            int y1 = e1.getLocation().getY();
            int w1 = e1.getSize().getWidth();
            int h1 = e1.getSize().getHeight();

            for (int j = i + 1; j < elements.size(); j++) {
                WebElement e2 = elements.get(j);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e2);

                int x2 = e2.getLocation().getX();
                int y2 = e2.getLocation().getY();
                int w2 = e2.getSize().getWidth();
                int h2 = e2.getSize().getHeight();

                // Overlap kontrolü
                boolean overlap = x1 < x2 + w2 &&
                        x1 + w1 > x2 &&
                        y1 < y2 + h2 &&
                        y1 + h1 > y2;

                if (overlap) {
                    overlapFound = true;
                    System.out.println("Overlap bulundu: Element " + i + " ve Element " + j);
                }
            }
        }

        // Test sonucu
        Assert.assertFalse(overlapFound, "Sayfada overlap (çakışma) var!");
    }

    public void BookStoreClick() {
        JavascriptExecutor jsb = (JavascriptExecutor) driver;
        try {
            WebElement banner = driver.findElement(By.id("fixedban"));
            jsb.executeScript("arguments[0].style.display='none'", banner);
        } catch (NoSuchElementException e) {
            // Reklam yoksa hata verme
        }
        WebElement BookstoreElement = driver.findElement(GoBookStore);
        jsb.executeScript("arguments[0].scrollIntoView(true);", BookstoreElement);
        driver.findElement(GoBookStore).click();

    }

    public void BookStoreControl() {
//        JavascriptExecutor jsc = (JavascriptExecutor) driver;
//        WebElement BookElement = driver.findElement(BookStoreControl);
//        jsc.executeScript("arguments[0].scrollIntoView(true);", BookElement);
        //SAYFA YUKARI NASIL SCROLL EDİLİR ÖĞREN.

        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("window.scrollBy(0, -450)");
        WebElement title = driver.findElement(BookStoreControl);
        String titleText = title.getText();
        assertEquals(titleText, "Git Pocket Guide");

    }
    public void ClickBook() {
        driver.findElement(Clickbook).click();


    }

    public void BookDetail() {
        String pagesource = driver.getPageSource();

        Assert.assertTrue(pagesource.contains("Title")
                        ||pagesource.contains("ISBN")
                        ||pagesource.contains("Puplisher"),
                "Book detail page opened but expected content is missing!"       );

    }


    public void DeleteallBooks() {
        driver.findElement(DeleteAllBook).click();

    }

    public void PopUpControl() {
        WebElement Title = driver.findElement(DeleteAllBooksPopUp);
        String TitleText = Title.getText();
        assertEquals(TitleText, "Delete All Books");

    }

    public void OkButton() {
        driver.findElement(OkButtonPopUp).click();



    }

    public String MessageControl() {
        wait.until(ExpectedConditions.alertIsPresent());   // Alert'in gelmesini bekle
        String alertText = driver.switchTo().alert().getText();  // Alert metnini al
        driver.switchTo().alert().accept();  // Alert'i kapat (OK tuşuna bas)

        // Beklenen alert mesajı
        String expectedAlertText = "No books available in your's collection!";

        // Assert ile doğrulama (JUnit kullanıyorsan)
        Assert.assertEquals(expectedAlertText, alertText);

        return alertText;
    }
    public void CancelButton() {
        driver.findElement(CancelButtonPopUp).click();
    }

    public void CancelButtonSuccesfull() {
        WebElement TitleProfile = driver.findElement(DeleteAllBooksPopUp);
        String TitleTextProfile = TitleProfile.getText();
        assertEquals(TitleTextProfile, "Delete All Books");
    }

    public void DeleteAcounts() {
        driver.findElement(DeleteAccountBook).click();

    }

    public void PopUpChceck() {
        WebElement Delete = driver.findElement(DeleteAccountPopUp);
        String TitleDelete = Delete.getText();
        assertEquals(TitleDelete, "Do you want to delete your account?");

    }

    public void CancelButtonClosed() {
        WebElement Canceltitle = driver.findElement(DeleteAccountBook);
        String CancelTitle = Canceltitle.getText();
        assertEquals(CancelTitle, "Delete Account");
    }

    public String SuucesfulPopUpControl() {
        wait.until(ExpectedConditions.alertIsPresent());   // Alert'in gelmesini bekle
        String alertText = driver.switchTo().alert().getText();  // Alert metnini al
        driver.switchTo().alert().accept();  // Alert'i kapat (OK tuşuna bas)

        // Beklenen alert mesajı
        String expectedAlertText = "User Deleted.";

        // Assert ile doğrulama (JUnit kullanıyorsan)
        Assert.assertEquals(expectedAlertText, alertText);

        return alertText;

    }

    public void LogoutButton() {
        driver.findElement(LogOut).click();



    }

    public void LogoutContol() {
        WebElement Logoutitle = driver.findElement(SuccesfulLogout);
        String LogouTitle = Logoutitle.getText();
        assertEquals(LogouTitle, "Welcome,");

    }

    public void Addbook() {
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        WebElement AddBookElement = driver.findElement(AddCollection);
        jsq.executeScript("arguments[0].scrollIntoView(true);", AddBookElement);
//        JavascriptExecutor jsq = (JavascriptExecutor) driver;
//        jsq.executeScript("window.scrollBy(0,300)");

        driver.findElement(AddCollection).click();
        

        wait.until(ExpectedConditions.alertIsPresent());   // Alert'in gelmesini bekle
        String alertText = driver.switchTo().alert().getText();  // Alert metnini al
        driver.switchTo().alert().accept();  // Alert'i kapat (OK tuşuna bas)

        // Beklenen alert mesajı
        String expectedAlertText = "Book added to your collection.";

        // Assert ile doğrulama (JUnit kullanıyorsan)
        Assert.assertEquals(expectedAlertText, alertText);

//              return alertText;
    }

    public void AddProfile() {
        driver.findElement(Profile).click();

        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("window.scrollBy(0, -350)");
        WebElement titlee = driver.findElement(ProileAddBook);
        String titleTextt = titlee.getText();
        assertEquals(titleTextt, "Learning JavaScript Design Patterns");
    }
}
