package com.appiumtest.steps;

import com.appiumtest.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
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
        MobileElement homePage = driver.findElement(MobileBy.AccessibilityId("test-Cart drop zone"));
        assertTrue(homePage.isDisplayed());
    }

    @Then("I should see an error message")
    public void verifyErrorMessage() {
        MobileElement errorMessage = driver.findElement(MobileBy.AccessibilityId("test-Error message"));
        assertTrue(errorMessage.isDisplayed());
    }

    @Then("I click to add some item to cart")
    public void addBackPack() {
        MobileElement addToCart = driver.findElement(MobileBy.AccessibilityId("test-ADD TO CART"));
        addToCart.click();
        MobileElement removeFromCart = driver.findElement(MobileBy.AccessibilityId("test-REMOVE"));
        assertTrue(removeFromCart.isDisplayed());
    }

    @Then("I can not add another item to cart")
    public void canNotAddAnotherItem() {
        MobileElement addButton = driver.findElement(MobileBy.AccessibilityId("test-ADD TO CART"));
        addButton.click();
        MobileElement removeButton = driver.findElement(MobileBy.AccessibilityId("test-REMOVE"));
        assertTrue(removeButton.isDisplayed());
        assertTrue(addButton.isDisplayed());
    }
    @Then("I can not remove item from cart")
    public void canNotRemoveItem() {
        MobileElement addButton = driver.findElement(MobileBy.AccessibilityId("test-ADD TO CART"));
        MobileElement removeButton = driver.findElement(MobileBy.AccessibilityId("test-REMOVE"));
        removeButton.click();
        assertTrue(removeButton.isDisplayed());
        assertTrue(addButton.isDisplayed());
    }
}
