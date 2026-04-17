package TestRunners;
import util.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;

@CucumberOptions(
        features = {"src/test/java/Features"},
        glue = {"StepDefinitions", "util"},
        tags = "@DemoQa or @API",
        plugin = {
                "summary","pretty","html:Reports/CucumberReport/Reports.html",
                "json:target/cucumber.json"
        }
)
public class runner extends AbstractTestNGCucumberTests {
    static WebDriver driver = DriverFactory.getDriver();
}