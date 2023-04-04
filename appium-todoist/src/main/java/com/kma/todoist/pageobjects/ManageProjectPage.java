package com.kma.todoist.pageobjects;

import com.kma.todoist.common.BasePage;
import com.kma.todoist.interfaces.ManageProjectPageUI;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class ManageProjectPage extends BasePage {
    AppiumDriver appiumDriver;

    public ManageProjectPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickToIconAddProject() {
        clickToElement(appiumDriver, ManageProjectPageUI.ADD_PROJECT_ICON);
    }

    public void inputToProjectNameTextbox(String projectName) {
        senkeysToElement(appiumDriver, ManageProjectPageUI.PROJECT_NAME_TEXTBOX, projectName);
    }

    public void clickToIconCompleteProject() {
        clickToElement(appiumDriver, ManageProjectPageUI.COMPLETE_PROJECT_ICON);
    }

    public void verifyCreateProjectSuccessful(String projectName) {
//        Assert.assertEquals(getText(appiumDriver,ManageProjectPageUI.ADD_PROJECT_ICON), projectName);
    }

    public void clickToColorButton() {
//        clickToElement(appiumDriver, ManageProjectPageUI.);
    }

    public void clickChooseColor(String color) {
//        clickToElement(appiumDriver, ManageProjectPageUI.);
    }
}
