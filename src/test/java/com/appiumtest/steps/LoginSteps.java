package com.appiumtest.steps;

import com.appiumtest.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.MobileElement;


public class LoginSteps {
    private AppiumDriver<MobileElement> driver;

    public LoginSteps() {
        this.driver = AppiumDriverFactory.getDriver();
    }

    @Before
    public void resetApp() {
        driver.resetApp();
    }

    @Given("I open the login page")
    public void openLoginPage() {
        System.out.println("Open app.");
    }

    @When("I enter the username as {string}")
    public void enterUsername(String username) {
        MobileElement usernameField = driver.findElement(MobileBy.AccessibilityId("test-Username"));
        usernameField.sendKeys(username);
    }

    @When("I enter the password as {string}")
    public void enterPassword(String password) {
        MobileElement passwordField = driver.findElement(MobileBy.AccessibilityId("test-Password"));
        passwordField.sendKeys(password);
    }

    @When("I click the login button")
    public void clickLoginButton() {
        MobileElement loginButton = driver.findElement(MobileBy.AccessibilityId("test-LOGIN"));
        loginButton.click();
    }

    @Then("I should see the home page")
    public void verifyHomePage() {
        MobileElement homePage = driver.findElement(MobileBy.AccessibilityId("test-PRODUCTS"));
        assertTrue(homePage.isDisplayed());
    }

    @Then("I should see an error message")
    public void verifyErrorMessage() {
        MobileElement errorMessage = driver.findElement(MobileBy.AccessibilityId("test-Error message"));
        assertTrue(errorMessage.isDisplayed());
    }

}
