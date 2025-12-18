package com.automation.tests;

import automation.base.BaseClass;
import automation.pages.RegisterPage;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class RegisterSteps {

    private RegisterPage registerPage;

    // ✅ REQUIRED by Cucumber (no DI)
    public RegisterSteps() {}

    @Before
    public void setUp(Scenario scenario) {
        BaseClass.init(scenario.getName());
        registerPage = new RegisterPage(
                BaseClass.getDriver(),
                BaseClass.getTest()
        );
    }

    @Given("user enters valid registration details")
    public void user_enters_valid_registration_details() {
        registerPage.registerUser(
                "John",
                "Doe",
                "john" + System.currentTimeMillis() + "@mail.com",
                "9876543210",
                "Password123",
                "Password123"
        );
    }

    @Then("account should be created successfully")
    public void account_should_be_created_successfully() {

        boolean success = BaseClass.getDriver()
                .getPageSource()
                .contains("Your Account Has Been Created");

        Assert.assertTrue(success);
        BaseClass.getTest().pass("Account created successfully");
    }

    @After
    public void tearDown() {
        BaseClass.quit();
    }
}
