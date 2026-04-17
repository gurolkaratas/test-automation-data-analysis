
package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.Properties;

public class Hooks {
    WebDriver driver;
    Properties properties;

    @Before
    public void before() {
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        if (browser == null) {
            browser = "Chrome";
        }

        properties = util.ConfigReader.initialize_Properties();
        driver = util.DriverFactory.initialize_Driver(browser);
    }


    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }

}
