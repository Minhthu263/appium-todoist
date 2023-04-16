package com.kma.todoist.pageobjects;

import com.kma.todoist.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class ManageTaskPage extends BasePage {
    AppiumDriver appiumDriver;

    public ManageTaskPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
}
