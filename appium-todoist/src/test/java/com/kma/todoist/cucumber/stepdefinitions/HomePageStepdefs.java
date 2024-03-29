package com.kma.todoist.cucumber.stepdefinitions;

import com.kma.todoist.common.BaseSteps;
import com.kma.todoist.cucumber.Hooks;
import com.kma.todoist.helper.TestContext;
import com.kma.todoist.interfaces.HomePageUI;
import com.kma.todoist.pageobjects.HomePage;
import com.kma.todoist.pageobjects.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;

public class HomePageStepdefs extends BaseSteps {
    AppiumDriver<MobileElement> appiumDriver;
    TestContext testContext;
    HomePage homePage;

    public HomePageStepdefs(TestContext context) {
        super(context);
        this.appiumDriver = Hooks.openAndQuitApp();
//        this.appiumDriver = Hooks.getDriver();
        homePage = PageGeneratorManager.getHomePage(appiumDriver);
        testContext = context;
    }

    @Given("I click menu bar")
    public void i_click_menu_bar() {
        isDisplayed(appiumDriver, HomePageUI.MORE_OPTION);
        homePage.clickToMenuBar();
    }

    @Given("I click Manage project")
    public void i_click_manage_project() {
        homePage.clickToManageProjectsButton();
    }

}
