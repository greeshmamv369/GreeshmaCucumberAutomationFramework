package automation.pages;

import automation.utils.JsonReader;
import automation.utils.SeleniumUtils;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ForgotPassWordPage {
    //private static final Logger logger=Logger.getLogger(String.valueOf(.class));
  //  ExtentTest tests=extentReports.createTest("forgotpassword");
    private final SeleniumUtils utils;
     private final ExtentTest test;
    JsonReader jsonreader=new JsonReader(new File("src/test/resources/TestData/registerData.json"));
    @FindBy(name = "email")
    private WebElement email;


    public ForgotPassWordPage(WebDriver driver, ExtentTest test) {
        this.utils = new SeleniumUtils(driver);
        this.test = test;
        PageFactory.initElements(driver, this);
    }
    public void enterEmail(String emaill)
    {
        utils.type(email,jsonreader.getString( "emaill"));
        test.info("Entered email address");
    }
}