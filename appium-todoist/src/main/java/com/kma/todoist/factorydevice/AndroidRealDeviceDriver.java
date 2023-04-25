package com.kma.todoist.factorydevice;

import com.kma.todoist.pageobjects.LoginPage;
import com.kma.todoist.pageobjects.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.kma.todoist.helper.LoadDevicesConfig.LOAD_DEVICES_CONFIG;

public class AndroidRealDeviceDriver implements DeviceFactory {
    private AppiumDriver<MobileElement> driver;
//    LoginPage loginPage;

    @Override
    public AppiumDriver<MobileElement> getMobileDriver() {
        DesiredCapabilities caps = getDesiredCapabilities();
        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            LoginPage loginPage = PageGeneratorManager.getLoginPage(driver);
            loginPage.loginApp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error create appium session");
        }
        return driver;
    }

    public AppiumDriver<MobileElement> getMobileDriverWithoutLogin() {
        DesiredCapabilities caps = getDesiredCapabilities();
        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error create appium session");
        }
        return driver;
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities flutterCapabilities = new DesiredCapabilities();
        String appPackage = LOAD_DEVICES_CONFIG.getProperty("appPackage");
        String appActivity = LOAD_DEVICES_CONFIG.getProperty("appActivity");
        String udid = LOAD_DEVICES_CONFIG.getProperty("udid");
        String platformName = LOAD_DEVICES_CONFIG.getProperty("platformName");
        flutterCapabilities.setCapability("platformName", platformName);
        flutterCapabilities.setCapability("appPackage", appPackage);
        flutterCapabilities.setCapability("appActivity", appActivity);
        flutterCapabilities.setCapability("automationName", "uiautomator2");
        flutterCapabilities.setCapability("udid", udid);
        flutterCapabilities.setCapability("newCommandTimeout", 1000);
        return flutterCapabilities;
    }

}
