package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTabPage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;

    public LoginTabPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.elementHelper = new util.ElementHelper(driver);
    }
    static By Logintab = By.xpath("//span[normalize-space()='Login']");
    static By Loginpage = By.cssSelector("#loading-label");

    public void LoginClick() {
        driver.findElement(Logintab).click();

    }

    public void ProfilePageControl() {
        WebElement loginpagetitle = driver.findElement(Loginpage);
        String LoginpageTitle = loginpagetitle.getText();
        assertEquals(LoginpageTitle, "You are already logged in. View your profile.");

    }
}
