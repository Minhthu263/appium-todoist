package com.kma.todoist.cucumber.stepdefinitions.managetask;

import com.kma.todoist.common.BaseSteps;
import com.kma.todoist.cucumber.Hooks;
import com.kma.todoist.helper.TestContext;
import com.kma.todoist.pageobjects.ManageProjectPage;
import com.kma.todoist.pageobjects.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ManageTaskStepdef1 extends BaseSteps {
    AppiumDriver<MobileElement> appiumDriver;
    TestContext testContext;
    ManageProjectPage manageProject;

    public ManageTaskStepdef1(TestContext context) {
        super(context);
        this.appiumDriver = Hooks.openAndQuitApp();
        manageProject = PageGeneratorManager.getManageProjectPage(appiumDriver);
        testContext = context;
    }
}
