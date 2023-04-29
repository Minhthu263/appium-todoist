package com.kma.todoist.cucumber.stepdefinitions.manageproject;

import com.kma.todoist.common.BaseSteps;
import com.kma.todoist.common.GlobalVariables;
import com.kma.todoist.cucumber.Hooks;
import com.kma.todoist.helper.TestContext;
import com.kma.todoist.helper.object.Project;
import com.kma.todoist.pageobjects.ManageProjectPage;
import com.kma.todoist.pageobjects.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageProjectsStepdefs extends BaseSteps {
    AppiumDriver<MobileElement> appiumDriver;
    TestContext testContext;
    ManageProjectPage manageProject;
    public ManageProjectsStepdefs(TestContext context) {
        super(context);
        this.appiumDriver = Hooks.openAndQuitApp();
        manageProject = PageGeneratorManager.getManageProjectPage(appiumDriver);
        testContext = context;
    }
    @When("I click + Add project")
    public void i_click_add_project() {
        log.info("STEP-I click + Add project");
        manageProject.clickToIconAddProject();
    }
    @When("I input Project Name with {string}")
    public void i_input_project_name_with(String projectName) {
        log.info("STEP-input Project Name");
        manageProject.inputToProjectNameTextbox(projectName);
//        testContext.scenarioContext.setContext(GlobalVariables.PROJECT_NAME, projectName);
        Project project = new Project(projectName, null);
        testContext.scenarioContext.setContext(GlobalVariables.CREATE_PROJECT, project);
    }
    @When("I click to V icon")
    public void i_click_to_v_icon() {
        manageProject.clickToIconCompleteProject();
        hideKeyboard(appiumDriver);
    }

    @Then("I check create project successful")
    public void iCheckCreateProjectSuccessful() {
        Project project = testContext.scenarioContext.getContext(GlobalVariables.CREATE_PROJECT);
        manageProject.verifyCreateProjectSuccessful(project.getName());
//        manageProject.verifyCreateProjectSuccessful(testContext.scenarioContext.getContext(GlobalVariables.PROJECT_NAME));
    }

    @And("I choose Color with {string}")
    public void iChooseColorWith(String color) {
        manageProject.clickToColorButton();
        manageProject.clickChooseColor(color);
    }

    @And("I choose Parent with {string}")
    public void iChooseParentWith(String parent) {
        manageProject.clickToParentButton();
        manageProject.clickChooseParent(parent);
    }

    @And("I choose Favorite")
    public void iChooseFavorite() {
        manageProject.clickChooseFavorite();
    }

    @And("I choose View Board")
    public void iChooseViewBoard() {
        manageProject.clickChooseViewBoard();
    }

    @Then("Verify add archive successful")
    public void verifyAddArchiveSuccessful() {
    }

    @When("I click add project to Archive with project {string}")
    public void iClickAddProjectToArchiveWithProject(String projectName) {
        manageProject.clickToOption(projectName);
        manageProject.clickToArchiveOption();
        manageProject.clickToArchiveButton();
    }

    @Then("Kill app")
    public void killApp() {
        appiumDriver.closeApp();
    }
}
