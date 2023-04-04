package com.kma.todoist.cucumber.stepdefinitions.login;

import com.kma.todoist.common.BaseSteps;
import com.kma.todoist.cucumber.Hooks;
import com.kma.todoist.helper.TestContext;
import com.kma.todoist.pageobjects.LoginPage;
import com.kma.todoist.pageobjects.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.When;

public class LoginStepdefs extends BaseSteps {
    AppiumDriver<MobileElement> appiumDriver;
    LoginPage loginPage;
    TestContext testContext;

    public LoginStepdefs(TestContext context) {
        super(context);
        this.appiumDriver = Hooks.openAndQuitApp();
        loginPage = PageGeneratorManager.getLoginPage(appiumDriver);
        testContext = context;
    }

    @When("I click Continue with Google")
    public void i_click_continue_with_google() {
        loginPage.clickToContinueWithGoogleButton();
    }

    @When("I choose account")
    public void iChooseAccount() {
        loginPage.clickToAccount();
    }
}
