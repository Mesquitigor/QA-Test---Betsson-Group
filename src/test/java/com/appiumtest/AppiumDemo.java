package com.appiumtest;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AppiumDemo {
    
    private static AppiumDriver<MobileElement> driver;
//    private AndroidDriver<MobileElement> driver;

    public static AppiumDriver getDriver()  {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "14");
        caps.setCapability("appium:deviceName", "RXCTA0BRGRW");
        caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:app", "C:\\Users\\User\\Desktop\\app\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:fullContextList", true);

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub/");
            driver = new AndroidDriver<>(url, caps);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
