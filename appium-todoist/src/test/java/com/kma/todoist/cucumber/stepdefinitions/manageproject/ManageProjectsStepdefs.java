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

import java.util.List;
import java.util.Map;

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
    }

    @And("I choose cancel")
    public void iChooseCancel() {
        manageProject.clickToCancelArchiveButton();
    }

    @Then("Kill app")
    public void killApp() {
        appiumDriver.closeApp();
    }

    @When("I click project name with {string}")
    public void iClickProjectNameWith(String projectName) {
        manageProject.clickToProjectName(projectName);
    }

    @And("I click edit project")
    public void iClickEditProject() {
        manageProject.clickToMoreIconInToolBar();
        manageProject.clickToEditButtonInMore();
    }

    @And("I edit project information")
    public void iEditProjectInformation(List<Map<String, String>> data) {
        log.info("ManageProject - STEP - Chỉnh sửa thông tin");
        String projectNameOld = data.get(0).get("projectNameOld");
        String projectName = data.get(0).get("projectName");
        String color = data.get(0).get("color");
        String parent = data.get(0).get("parent");
        String favorite = data.get(0).get("favorite");
        String view = data.get(0).get("view");

        if (projectName!=null){
            manageProject.inputToProjectNameTextbox(projectName);
            Project project = new Project(projectName, color);
            testContext.scenarioContext.setContext(GlobalVariables.CREATE_PROJECT, project);
        }
        else {
            Project project = new Project(projectNameOld, color);
            testContext.scenarioContext.setContext(GlobalVariables.CREATE_PROJECT, project);
        }
        if (color!=null){
            manageProject.clickToColorButton();
            manageProject.clickChooseColor(color);
        }
        if (parent!=null){
            manageProject.clickToParentButton();
            manageProject.clickChooseParent(parent);
        }
        if (favorite!=null){
            manageProject.clickChooseFavorite();
        }
        if (view!=null){
            manageProject.clickChooseViewBoard();
        }

    }

    @Then("I check edit project successful")
    public void iCheckEditProjectSuccessful() {
    }

    @Then("Verify add archive unsuccessful")
    public void verifyAddArchiveUnsuccessful() {
        Project project = testContext.scenarioContext.getContext(GlobalVariables.CREATE_PROJECT);
        manageProject.verifyCreateProjectSuccessful(project.getName());
    }
}
