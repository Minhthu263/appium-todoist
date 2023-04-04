package com.kma.todoist.pageobjects;

import com.kma.todoist.common.BasePage;
import com.kma.todoist.interfaces.HomePageUI;
import io.appium.java_client.AppiumDriver;
import org.testng.asserts.SoftAssert;

public class HomePage extends BasePage {
    AppiumDriver appiumDriver;
    SoftAssert softAssert = new SoftAssert();

    public HomePage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickToMenuBar() {
        clickToElement(appiumDriver, HomePageUI.MENU_BAR_BUTTON);
    }

    public void clickToManageProjectsButton() {
        clickToElement(appiumDriver, HomePageUI.MANAGE_PROJECTS_BUTTON);
    }
}
