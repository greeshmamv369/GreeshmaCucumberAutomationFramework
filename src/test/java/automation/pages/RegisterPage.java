package automation.pages;

import automation.utils.SeleniumUtils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private final SeleniumUtils utils;
    private final ExtentTest test;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "telephone")
    private WebElement telephone;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;

    public RegisterPage(WebDriver driver, ExtentTest test) {
        this.utils = new SeleniumUtils(driver);
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    public void registerUser(String fn, String ln, String mail,
                             String phone, String pwd, String confirmPwd) {

        utils.type(firstName, fn);
        test.info("First name entered");

        utils.type(lastName, ln);
        test.info("Last name entered");

        utils.type(email, mail);
        test.info("Email entered");

        utils.type(telephone, phone);
        test.info("Phone entered");

        utils.type(password, pwd);
        test.info("Password entered");

        utils.type(confirmPassword, confirmPwd);
        test.info("Confirm password entered");

        utils.click(continueBtn);
        test.info("Clicked Continue");
    }
}
