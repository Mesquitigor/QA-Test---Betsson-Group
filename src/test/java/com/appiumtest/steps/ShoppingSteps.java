package com.appiumtest.steps;

import com.appiumtest.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Map;

public class ShoppingSteps {
    private AppiumDriver<MobileElement> driver;

    public ShoppingSteps() {
        this.driver = AppiumDriverFactory.getDriver();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.enterUsername("standard_user");
        loginSteps.enterPassword("secret_sauce");
        loginSteps.clickLoginButton();
    }

    @When("I add one product to the cart")
    public void iAddTheProductToTheCart() {
        ((JavascriptExecutor) driver).executeScript("mobile: tap", Map.of("x", 250, "y", 1400));
    }

    @Then("the cart badge should show some item")
    public void theCartBadgeShouldShow() {
        MobileElement cartBadge = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"));
        cartBadge.click();
        MobileElement cartItem = driver.findElement(MobileBy.AccessibilityId("test-Item"));
        assertTrue(cartItem.isDisplayed());
    }

    @Given("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.enterUsername("standard_user");
        loginSteps.enterPassword("secret_sauce");
        loginSteps.clickLoginButton();
        iAddTheProductToTheCart();
        theCartBadgeShouldShow();
        MobileElement cartItem = driver.findElement(MobileBy.AccessibilityId("test-Item"));
        assertTrue(cartItem.isDisplayed());
    }

    @When("I click on the checkout button")
    public void iClickOnTheCheckoutButton() {
        MobileElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    @When("I fill the checkout information")
    public void iFillTheCheckoutInformation() {
        MobileElement firstName = driver.findElement(MobileBy.AccessibilityId("test-First Name"));
        firstName.sendKeys("Testing");
        MobileElement lastName = driver.findElement(MobileBy.AccessibilityId("test-Last Name"));
        lastName.sendKeys("SwagLabs");
        MobileElement postalCode = driver.findElement(MobileBy.AccessibilityId("test-Zip/Postal Code"));
        postalCode.sendKeys("123321");
        MobileElement continueButton = driver.findElement(MobileBy.AccessibilityId("test-CONTINUE"));
        continueButton.click();
    }

    @Then("I should see the checkout information page")
    public void iShouldSeeTheCheckoutInformationPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text=\"CHECKOUT: OVERVIEW\"]")).isDisplayed());
    }

    @Given("I am on the checkout information page")
    public void iAmOnTheCheckoutInformationPage() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.enterUsername("standard_user");
        loginSteps.enterPassword("secret_sauce");
        loginSteps.clickLoginButton();
        iAddTheProductToTheCart();
        theCartBadgeShouldShow();
        iClickOnTheCheckoutButton();
        MobileElement checkoutPage = driver.findElement(MobileBy.AccessibilityId("test-CHECKOUT: OVERVIEW"));
        checkoutPage.isDisplayed();
    }

    @When("I review that it has an item")
    public void reviewTheItem(String firstName) {
        MobileElement testItem = driver.findElement(MobileBy.AccessibilityId("test-Item"));
        testItem.isDisplayed();
    }

    @When("I click the finish button")
    public void iClickTheFinishButton() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"));
        MobileElement finishButton = driver.findElement(MobileBy.AccessibilityId("test-FINISH"));
        finishButton.click();
    }

    @Then("I should see the confirmation message")
    public void iShouldSeeTheConfirmationMessage(String expectedMessage) {
        MobileElement confirmationMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]"));
        Assert.assertEquals("Thank you for your order", expectedMessage, confirmationMessage.getText());
        driver.quit();
    }
}


