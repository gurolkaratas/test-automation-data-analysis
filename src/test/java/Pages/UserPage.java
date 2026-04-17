package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static org.testng.AssertJUnit.assertEquals;

public class UserPage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new util.ElementHelper(driver);
    }

    static By Element = By.cssSelector("svg[stroke='currentColor'][fill='currentColor'][stroke-width='0'][viewBox='0 0 448 512']");
    static By BookStore = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > span:nth-child(1) > div:nth-child(1) > div:nth-child(1)");
    static By LoginButton = By.xpath("//span[normalize-space()='Login']");
    static By LoginTitle = By.cssSelector(".text-center");
    static By NewUserButton = By.cssSelector("#newUser");
    static By registercontrol = By.cssSelector("h1[class='text-center']");
    static By firstname = By.xpath("//input[@id='firstname']");
    static By lastname = By.xpath("//input[@id='lastname']");
    static By usurname = By.xpath("//input[@id='userName']");
    static By password = By.cssSelector("#password");
    static By register = By.cssSelector("#register");
    static By BackToLogin = By.cssSelector("#gotologin");
    static By ErrorMessage = By.cssSelector("#name");
    static By RobotMessage = By.cssSelector("#name");


    public void DemoqaOpened() {
        driver.get("https://demoqa.com/");


    }


    public void ClickElements() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.findElement(Element).click();

    }

    public void ClickBook() {
        JavascriptExecutor jsl = (JavascriptExecutor) driver;

            // Reklam banner'ı varsa gizle
        try {
                WebElement banner = driver.findElement(By.id("fixedban"));
                jsl.executeScript("arguments[0].style.display='none'", banner);
        } catch (NoSuchElementException e) {
                // Reklam yoksa hata verme
        }

        // BookStore elementine scroll yap
        WebElement bookStoreElement = driver.findElement(BookStore);
        jsl.executeScript("arguments[0].scrollIntoView(true);", bookStoreElement);
        driver.findElement(BookStore).click();


    }

    public void ClickLogin() {
        driver.findElement(LoginButton).click();

    }

    public void CheckNewUserPage() {
        WebElement title = driver.findElement(LoginTitle);
        String titleText = title.getText();
        assertEquals(titleText, "Login");
    }

    public void ClickNewUser() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,450)");
        driver.findElement(NewUserButton).click();

    }

    public void CheckRegister() {
        WebElement Title = driver.findElement(registercontrol);
        String TitleText = Title.getText();
        assertEquals(TitleText, "Register");
    }

    public void FirstName() {
        JavascriptExecutor jsu = (JavascriptExecutor) driver;

        // Reklam banner'ı varsa gizle
        try {
            WebElement banner = driver.findElement(By.id("fixedban"));
            jsu.executeScript("arguments[0].style.display='none'", banner);
        } catch (NoSuchElementException e) {
            // Reklam yoksa hata verme
        }

        // BookStore elementine scroll yap
        WebElement FirstnameElement = driver.findElement(firstname);
        jsu.executeScript("arguments[0].scrollIntoView(true);", FirstnameElement);

        //JavascriptExecutor jsu = (JavascriptExecutor) driver;
        //jsu.executeScript("window.scrollBy(0, 200)");
        driver.findElement(firstname).click();
        elementHelper.sendKey(firstname, "Gürol");
    }

    public void LastName() {
        JavascriptExecutor jsa = (JavascriptExecutor) driver;
        WebElement LastnameElement = driver.findElement(lastname);
        jsa.executeScript("arguments[0].scrollIntoView(true);", LastnameElement);

        driver.findElement(lastname).click();
        elementHelper.sendKey(lastname, "Karataş");

    }

    public void UsurName() {
        driver.findElement(usurname).click();
        elementHelper.sendKey(usurname, "Grlkrts777");
    }

    public void Password() {
        driver.findElement(password).click();
        elementHelper.sendKey(password, "Test1234!");
    }

    public void Register() {
        JavascriptExecutor jsj = (JavascriptExecutor) driver;
        jsj.executeScript("window.scrollBy(0, 350)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(register).click();

    }

    public String SuccessfulControl() {
        wait.until(ExpectedConditions.alertIsPresent());   // Alert'in gelmesini bekle
        String alertText = driver.switchTo().alert().getText();  // Alert metnini al
        driver.switchTo().alert().accept();  // Alert'i kapat (OK tuşuna bas)

        // Beklenen alert mesajı
        String expectedAlertText = "User Registered Successfully.";

        // Assert ile doğrulama (JUnit kullanıyorsan)
        Assert.assertEquals(expectedAlertText, alertText);

        return alertText;
    }


    public void BacktoLogin() {
        driver.findElement(BackToLogin).click();
        WebElement title = driver.findElement(LoginTitle);
        String titleText = title.getText();
        assertEquals(titleText, "Login");
    }

    public void FirtNameControl() {
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        WebElement firstNameElement = driver.findElement(firstname);
        jsq.executeScript("arguments[0].scrollIntoView(true);", firstNameElement);

//        // Kısa bir bekleme: border-color’ın değişmesini bekle
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        // Border rengini al ve yazdır

        String borderColor = firstNameElement.getCssValue("border-color");
        System.out.println("Border Color: " + borderColor);
        System.out.println("border-color: " + firstNameElement.getCssValue("border-color"));
        System.out.println("border-bottom-color: " + firstNameElement.getCssValue("border-bottom-color"));
        System.out.println("box-shadow: " + firstNameElement.getCssValue("box-shadow"));

        // Beklenen kırmızı renk kontrolü (rgb ya da rgba olabilir)
        Assert.assertTrue(borderColor.contains("220, 53, 69"), "FirstName alanının border rengi kırmızı değil: " + borderColor);
    }

    public void LastNameControl() {
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        WebElement lastNameElement = driver.findElement(lastname);
        jsc.executeScript("arguments[0].scrollIntoView(true);", lastNameElement);

//         Kısa bir bekleme: border-color’ın değişmesini bekle
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // Border rengini al ve yazdır
        String borderColor = lastNameElement.getCssValue("border-color");
        System.out.println("Border Color: " + borderColor);

        // Beklenen kırmızı renk kontrolü (rgb ya da rgba olabilir)
        Assert.assertTrue(borderColor.contains("220, 53, 69"), "FirstName alanının border rengi kırmızı değil: " + borderColor);
    }

    public void UserNameControl() {
        JavascriptExecutor jsd = (JavascriptExecutor) driver;
        WebElement userNameElement = driver.findElement(usurname);
        jsd.executeScript("arguments[0].scrollIntoView(true);", userNameElement);

        // Kısa bir bekleme: border-color’ın değişmesini bekle
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // Border rengini al ve yazdır
        String borderColor = userNameElement.getCssValue("border-color");
        System.out.println("Border Color: " + borderColor);
        System.out.println("Border Color: " + borderColor);
        System.out.println("border-color: " + userNameElement.getCssValue("border-color"));
        System.out.println("border-bottom-color: " + userNameElement.getCssValue("border-bottom-color"));
        System.out.println("box-shadow: " + userNameElement.getCssValue("box-shadow"));

        // Beklenen kırmızı renk kontrolü (rgb ya da rgba olabilir)
        Assert.assertTrue(borderColor.contains("220, 53, 69"), "FirstName alanının border rengi kırmızı değil: " + borderColor);

    }

    public void PasswordControl() {
        JavascriptExecutor jsh = (JavascriptExecutor) driver;
        WebElement passwordElement = driver.findElement(password);
        jsh.executeScript("arguments[0].scrollIntoView(true);", passwordElement);

        // Kısa bir bekleme: border-color’ın değişmesini bekle
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // Border rengini al ve yazdır
        String borderColor = passwordElement.getCssValue("border-color");
        System.out.println("Border Color: " + borderColor);

        // Beklenen kırmızı renk kontrolü (rgb ya da rgba olabilir)
        Assert.assertTrue(borderColor.contains("220, 53, 69"), "FirstName alanının border rengi kırmızı değil: " + borderColor);


    }

    public void PasswordCharacterLimit() {
        driver.findElement(password).click();
        elementHelper.sendKey(password,"Test1!");
    }

    public void MessageControl() {
        elementHelper.checkVisible(ErrorMessage);
    }

    public void PassworLowercase() {
        driver.findElement(password).click();
        elementHelper.sendKey(password,"test1234!");
    }

    public void PasswordUppercase() {
        driver.findElement(password).click();
        elementHelper.sendKey(password,"TEST1234!");
    }

    public void SpecialCharacters() {
        driver.findElement(password).click();
        elementHelper.sendKey(password,"Test1234");
    }

    public void NoLetters() {
        driver.findElement(password).click();
        elementHelper.sendKey(password,"123456789!");
    }

    public void NoNumbers() {
        driver.findElement(password).click();
        elementHelper.sendKey(password,"Testpassword!");
    }

    public void RobotTickMessage() {
        WebElement RobotTitle = driver.findElement(RobotMessage);
        String RobotTitleText = RobotTitle.getText();
        assertEquals(RobotTitleText, "Please verify reCaptcha to register!");
    }
}
