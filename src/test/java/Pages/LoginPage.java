package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new util.ElementHelper(driver);
    }

    static By UsernameLogin = By.xpath("//input[@id='userName']");
    static By PasswordLogin = By.cssSelector("#password");
    static By LoginClick = By.cssSelector("#login");
    static By LoginControl = By.cssSelector("#gotoStore");
    static By MessageControl = By.cssSelector("#name");

    public void Username() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement usernamedElement = driver.findElement(UsernameLogin);
        jse.executeScript("arguments[0].scrollIntoView(true);", usernamedElement);
        driver.findElement(UsernameLogin).click();
        elementHelper.sendKey(UsernameLogin, "Grlkrts07");
    }

    public void Password() {
        driver.findElement(PasswordLogin).click();
        elementHelper.sendKey(PasswordLogin,"Test1234!");
    }

    public void LoginButton() {
        driver.findElement(LoginClick).click();
    }

    public void LoginChecked() {
        WebElement LoginTitle = driver.findElement(LoginControl);
        String LoginTitleText =LoginTitle.getText();
        assertEquals(LoginTitleText, "Go To Book Store");


    }

    public void WarningMessage() {
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        WebElement UserNameLoginElement = driver.findElement(UsernameLogin);
        jsq.executeScript("arguments[0].scrollIntoView(true);", UserNameLoginElement);

        // Kısa bir bekleme: border-color’ın değişmesini bekle
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Border rengini al ve yazdır
        String borderColor = UserNameLoginElement.getCssValue("border-color");
        System.out.println("Border Color: " + borderColor);

        // Beklenen kırmızı renk kontrolü (rgb ya da rgba olabilir)
        Assert.assertTrue(borderColor.contains("220, 53, 69"), "FirstName alanının border rengi kırmızı değil: " + borderColor);
    }

    public void PasswordControl() {
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        WebElement PasswordLoginElement = driver.findElement(PasswordLogin);
        jsq.executeScript("arguments[0].scrollIntoView(true);", PasswordLoginElement);

        // Kısa bir bekleme: border-color’ın değişmesini bekle
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Border rengini al ve yazdır
        String borderColor = PasswordLoginElement.getCssValue("border-color");
        System.out.println("Border Color: " + borderColor);

        // Beklenen kırmızı renk kontrolü (rgb ya da rgba olabilir)
        Assert.assertTrue(borderColor.contains("220, 53, 69"), "FirstName alanının border rengi kırmızı değil: " + borderColor);

    }

    public void invalidusernme() {
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        WebElement invalidUserNameElement = driver.findElement(UsernameLogin);
        jsq.executeScript("arguments[0].scrollIntoView(true);", invalidUserNameElement);
        driver.findElement(UsernameLogin).click();
        elementHelper.sendKey(UsernameLogin, "GürolKarataş");
    }

    public void ErrorMessage() {
        elementHelper.checkVisible(MessageControl);
    }

    public void invalidpassword() {
        driver.findElement(PasswordLogin).click();
        elementHelper.sendKey(PasswordLogin, "Test12345!");
    }
}
