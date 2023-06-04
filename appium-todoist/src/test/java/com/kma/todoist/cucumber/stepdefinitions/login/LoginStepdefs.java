package com.kma.todoist.cucumber.stepdefinitions.login;

import com.kma.todoist.common.BaseSteps;
import com.kma.todoist.cucumber.Hooks;
import com.kma.todoist.helper.TestContext;
import com.kma.todoist.interfaces.LoginPageUI;
import com.kma.todoist.pageobjects.LoginPage;
import com.kma.todoist.pageobjects.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;

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

    @Given("Login in app")
    public void loginInApp() {
        loginPage.loginApp();
    }

    @Then("Verify login successful")
    public void verifyLoginSuccessful() {
        Assert.assertTrue(isDisplayed(appiumDriver, LoginPageUI.TODAY_LABEL));
//        appiumDriver.closeApp();
        Hooks.close();
    }

    @And("I click Login with Email")
    public void iClickLoginWithEmail() {
        clickToElement(appiumDriver, LoginPageUI.LOGIN_WITH_EMAIL_BUTTON);
    }

    @Given("I click Continue with more options")
    @Step
    public void iClickContinueWithMoreOptions() {
        clickToElement(appiumDriver, LoginPageUI.CONTINUE_WITH_MORE_OPTIONS_BUTTON);
    }

    @And("I click to None of the above")
    public void iClickToNoneOfTheAbove() {
        clickToElement(appiumDriver, LoginPageUI.NONE_OF_THE_ABOVE_BUTTON);
    }

    @When("I input username with {string}")
    public void iInputUsernameWith(String username) {
        senkeysToElement(appiumDriver, LoginPageUI.EMAIL_TEXTBOX, username);
    }

    @And("I input password with {string}")
    public void iInputPasswordWith(String password) {
        senkeysToElement(appiumDriver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @And("I click to Login")
    public void iClickToLogin() {
        clickToElement(appiumDriver, LoginPageUI.LOGIN_BUTTON);
    }

    @Then("Verify message login unsuccessful")
    public void verifyMessageLoginUnsuccessful() {
        isDisplayed(appiumDriver, LoginPageUI.LOGIN_BUTTON);
    }

    @And("I click choose account")
    public void iClickChooseAccount() {
        clickToElement(appiumDriver, LoginPageUI.ACCOUNT_BTN);
    }

    @Then("Verify button Login is disable")
    public void verifyButtonLoginIsDisable() {
        isNotDisplayed(appiumDriver, LoginPageUI.LOGIN_BUTTON);
    }

    @And("Close app")
    public void closeApp() {
        Hooks.close();
    }
}
