package com.kma.todoist.pageobjects;

import io.appium.java_client.AppiumDriver;

public class PageGeneratorManager {
    private PageGeneratorManager() {

    }

    //    public static HomePageObject getHomePageObject(WebDriver driver){
//        return new HomePageObject(driver);
//    }
    public static LoginPage getLoginPage(AppiumDriver driver) {
        return new LoginPage(driver);
    }

//    public static PricingPageObject getPricingPageObject(WebDriver driver){
//        return new PricingPageObject(driver);
//    }
}
