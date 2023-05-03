package com.kma.todoist.pageobjects;

import com.kma.todoist.common.BasePage;
import com.kma.todoist.interfaces.LoginPageUI;
import io.appium.java_client.AppiumDriver;
import org.testng.asserts.SoftAssert;

public class LoginPage extends BasePage {
    AppiumDriver appiumDriver;
    SoftAssert softAssert = new SoftAssert();

    public LoginPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void loginApp() {
        clickToContinueWithGoogleButton();
        clickToAccount();
    }

    public void clickToContinueWithGoogleButton() {
        clickToElement(appiumDriver, LoginPageUI.CONTINUE_WITH_GOOGLE_BTN);
    }

    public void clickToAccount() {
        clickToElement(appiumDriver, LoginPageUI.ACCOUNT_BTN);
    }
}
