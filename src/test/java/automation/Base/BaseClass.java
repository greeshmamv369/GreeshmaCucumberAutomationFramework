package automation.base;

import automation.utils.ExtentManager;
import automation.utils.PropertyReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseClass {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    public void initialize(String scenarioName) {

        // ---------- Extent ----------
        extent = ExtentManager.getInstance();
        test = extent.createTest(scenarioName);

        // ---------- Browser ----------
        String browser = PropertyReader.get("browser");

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(PropertyReader.get("url"));
    }

    public void quit() {
        if (driver != null) driver.quit();
        if (extent != null) extent.flush();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public ExtentTest getTest() {
        return test;
    }
}
