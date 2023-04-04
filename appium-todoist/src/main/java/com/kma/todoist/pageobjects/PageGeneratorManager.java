package com.kma.todoist.pageobjects;

import io.appium.java_client.AppiumDriver;

public class PageGeneratorManager {
    private PageGeneratorManager() {

    }

    public static LoginPage getLoginPage(AppiumDriver driver) {
        return new LoginPage(driver);
    }

    public static HomePage getHomePage(AppiumDriver driver) {
        return new HomePage(driver);
    }

    public static ManageProjectPage getManageProjectPage(AppiumDriver driver) {
        return new ManageProjectPage(driver);
    }
}
