package com.appiumtest.steps;

import com.appiumtest.AppiumDemo;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertTrue;
import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class LoginSteps {
    private AppiumDriver driver;

    public LoginSteps() {
        this.driver = AppiumDemo.getDriver();
    }

    @Given("I open the login page")
    public void openLoginPage() {
        System.out.println("Open app.");
    }

    @When("I enter the username as {string}")
    public void enterUsername(String username) {
        MobileElement usernameField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']"));
        usernameField.sendKeys(username);
    }

    @When("I enter the password as {string}")
    public void enterPassword(String password) {
        MobileElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
        passwordField.sendKeys(password);
    }

    @When("I click the login button")
    public void clickLoginButton() {
        MobileElement loginButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']"));
        loginButton.click();
    }

    @Then("I should see the home page")
    public void verifyHomePage() {
        MobileElement homePage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));
        assertTrue(homePage.isDisplayed());
    }

    @Then("I should see an error message")
    public void verifyErrorMessage() {
        MobileElement errorMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]"));
        assertTrue(errorMessage.isDisplayed());
    }

    @Then("I should see an error message, for empty username")
    public void verifyErrorMessageEmptyUsername() {
        MobileElement errorMessage = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]"));
        assertTrue(errorMessage.isDisplayed());
    }

    @Then("I should see an error message, for empty password")
    public void verifyErrorMessageEmptyPassword() {
        MobileElement errorMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Password is required\"]"));
        assertTrue(errorMessage.isDisplayed());
    }
}
