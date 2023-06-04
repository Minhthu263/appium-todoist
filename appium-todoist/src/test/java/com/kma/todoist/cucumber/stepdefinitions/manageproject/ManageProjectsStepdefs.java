package com.kma.todoist.cucumber.stepdefinitions.manageproject;

import com.kma.todoist.common.BaseSteps;
import com.kma.todoist.common.GlobalVariables;
import com.kma.todoist.cucumber.Hooks;
import com.kma.todoist.helper.TestContext;
import com.kma.todoist.helper.object.Project;
import com.kma.todoist.interfaces.ManageProjectPageUI;
import com.kma.todoist.pageobjects.ManageProjectPage;
import com.kma.todoist.pageobjects.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

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
        manageProject.clickToIconAddProject();
    }

    @When("I input Project Name with {string}")
    public void i_input_project_name_with(String projectName) {
        manageProject.inputToProjectNameTextbox(projectName);
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

    @When("I click add project to Archive with project {string}")
    public void iClickAddProjectToArchiveWithProject(String projectName) {
        manageProject.clickToOption(projectName);
        manageProject.clickToArchiveOption();
        Project project = new Project(projectName, null);
        testContext.scenarioContext.setContext(GlobalVariables.CREATE_PROJECT, project);
    }

    @And("I choose cancel")
    public void iChooseCancel() {
        manageProject.clickToCancelArchiveButton();
    }

    @And("I choose archive")
    public void iChooseArchive() {
        manageProject.clickToAcceptArchiveButton();
    }

    @Then("Kill app")
    public void killApp() {
        appiumDriver.closeApp();
    }

    @When("I click project name with {string}")
    public void iClickProjectNameWith(String projectName) {
        testContext.scenarioContext.setContext(GlobalVariables.PROJECT_NAME, projectName);
        manageProject.clickToProjectName(projectName);
    }

    @And("I click edit project")
    public void iClickEditProject() {
        manageProject.clickToMoreIconInToolBar();
        manageProject.clickToEditButtonInMore();
    }

    @And("I edit project information")
    public void iEditProjectInformation(List<Map<String, String>> data) {
        String projectNameOld = data.get(0).get("projectNameOld");
        String projectName = data.get(0).get("projectName");
        String color = data.get(0).get("color");
        String parent = data.get(0).get("parent");
        String favorite = data.get(0).get("favorite");
        String view = data.get(0).get("view");

        if (projectName != null) {
            manageProject.inputToProjectNameTextbox(projectName);
            Project project = new Project(projectName, color);
            testContext.scenarioContext.setContext(GlobalVariables.CREATE_PROJECT, project);
        } else {
            Project project = new Project(projectNameOld, color);
            testContext.scenarioContext.setContext(GlobalVariables.CREATE_PROJECT, project);
        }
        if (color != null) {
            manageProject.clickToColorButton();
            manageProject.clickChooseColor(color);
        }
        if (parent != null) {
            manageProject.clickToParentButton();
            manageProject.clickChooseParent(parent);
        }
        if (favorite != null) {
            manageProject.clickChooseFavorite();
        }
        if (view != null) {
            manageProject.clickChooseViewBoard();
        }

    }

    @Then("I check edit project successful")
    public void iCheckEditProjectSuccessful() {
    }

    @Then("Verify add archive unsuccessful")
    public void verifyAddArchiveUnsuccessful() {
        Project project = testContext.scenarioContext.getContext(GlobalVariables.CREATE_PROJECT);
        manageProject.verifyProjectIsDisplay(project.getName());
    }

    @Then("Verify add archive successful")
    public void verifyAddArchiveSuccessful() {
        manageProject.clickToTabArchived();
        Project project = testContext.scenarioContext.getContext(GlobalVariables.CREATE_PROJECT);
        manageProject.verifyProjectIsDisplay(project.getName());
    }

    @And("I click tab Archived")
    public void iClickTabArchived() {
        manageProject.clickToTabArchived();
    }

    @When("I click add project to Unarchive with project {string}")
    public void iClickAddProjectToUnarchiveWithProject(String projectName) {
        manageProject.clickToOption(projectName);
        manageProject.clickToUnarchiveOption();
        Project project = new Project(projectName, null);
        testContext.scenarioContext.setContext(GlobalVariables.CREATE_PROJECT, project);
    }

    @Then("Verify add unarchive unsuccessful")
    public void verifyAddUnarchiveUnsuccessful() {
        Project project = testContext.scenarioContext.getContext(GlobalVariables.CREATE_PROJECT);
        manageProject.verifyProjectIsDisplay(project.getName());
    }

    @Then("Verify add unarchive successful")
    public void verifyAddUnarchiveSuccessful() {
        manageProject.clickToTabActive();
        Project project = testContext.scenarioContext.getContext(GlobalVariables.CREATE_PROJECT);
        manageProject.verifyProjectIsDisplay(project.getName());
    }

    @And("I choose unarchive")
    public void iChooseUnarchive() {
        manageProject.clickToAcceptUnarchiveButton();
    }

    @And("I back to home page")
    public void iBackToHomePage() {
        manageProject.clickToBackIcon();
    }

    @When("I click add project to Archive")
    public void iClickAddProjectToArchive() {
        String projectName = getTextAtribute(appiumDriver, ManageProjectPageUI.GET_NAME_PROJECT);
        manageProject.clickToOpenMenu();
        manageProject.clickToArchiveOption();
        Project project = new Project(projectName, null);
        testContext.scenarioContext.setContext(GlobalVariables.CREATE_PROJECT, project);
    }

    @When("I click add project to Unarchive")
    public void iClickAddProjectToUnarchive() {
        String projectName = getTextAtribute(appiumDriver, ManageProjectPageUI.GET_NAME_PROJECT);
        manageProject.clickToOpenMenu();
        manageProject.clickToUnarchiveOption();
        Project project = new Project(projectName, null);
        testContext.scenarioContext.setContext(GlobalVariables.CREATE_PROJECT, project);

    }

    @When("I click Comment project")
    public void iClickCommentProject() {
        manageProject.clickToOpenMenu();
        manageProject.clickToCommentOption();
    }

    @Then("Verify comment successful")
    public void verifyCommentSuccessful() {
        String comment = testContext.scenarioContext.getContext(GlobalVariables.COMMENT);
        Assert.assertEquals(getTextAtribute(appiumDriver, ManageProjectPageUI.COMMENT_LABEL), comment);
    }

    @And("I input comment with {string}")
    public void iInputCommentWith(String comment) {
        clickToElement(appiumDriver, ManageProjectPageUI.ADD_A_COMMENT_BUTTON);
        senkeysToElement(appiumDriver, ManageProjectPageUI.ADD_A_COMMENT_TEXTBOX, comment);
        clickToElement(appiumDriver, ManageProjectPageUI.SEND_COMMENT_BUTTON);
        hideKeyboard(appiumDriver);
        testContext.scenarioContext.setContext(GlobalVariables.COMMENT, comment);
    }

    @When("I click edit comment")
    public void iClickEditComment() {
        testContext.scenarioContext.setContext(GlobalVariables.COMMENT, getTextAtribute(appiumDriver, ManageProjectPageUI.COMMENT_TEXT_FOLLOW_MORE_OPTIONS));
        clickToElement(appiumDriver, ManageProjectPageUI.MORE_OPTION_COMMENT_BUTTON);
        clickToElement(appiumDriver, ManageProjectPageUI.EDIT_COMMENT_BUTTON);
    }

    @And("I input edit comment with {string}")
    public void iInputEditCommentWith(String comment) {
        testContext.scenarioContext.setContext(GlobalVariables.COMMENT_EDIT, comment);
        senkeysToElement(appiumDriver, ManageProjectPageUI.EDIT_COMMENT_TEXTBOX, comment);
    }

    @And("I click ok button")
    public void iClickOkButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.OK_BUTTON_EDIT_COMMENT);
        hideKeyboard(appiumDriver);
    }

    @And("I click cancel button")
    public void iClickCancelButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.CANCEL_BUTTON_EDIT_COMMENT);
        hideKeyboard(appiumDriver);
    }

    @Then("Verify comment unsuccessful")
    public void verifyCommentUnsuccessful() {
        String comment = testContext.scenarioContext.getContext(GlobalVariables.COMMENT);
        Assert.assertEquals(getTextAtribute(appiumDriver, ManageProjectPageUI.COMMENT_LABEL), comment);
    }

    @Then("Verify edit comment successful")
    public void verifyEditCommentSuccessful() {
        String comment = testContext.scenarioContext.getContext(GlobalVariables.COMMENT_EDIT);
        Assert.assertEquals(getTextAtribute(appiumDriver, ManageProjectPageUI.COMMENT_LABEL), comment);
    }

    @When("I click delete comment")
    public void iClickDeleteComment() {
        testContext.scenarioContext.setContext(GlobalVariables.COMMENT, getTextAtribute(appiumDriver, ManageProjectPageUI.COMMENT_TEXT_FOLLOW_MORE_OPTIONS));
        clickToElement(appiumDriver, ManageProjectPageUI.MORE_OPTION_COMMENT_BUTTON);
        clickToElement(appiumDriver, ManageProjectPageUI.DELETE_COMMENT_BUTTON);
    }

    @And("I click no button")
    public void iClickNoButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.CANCEL_BUTTON_EDIT_COMMENT);
    }

    @And("I click yes button")
    public void iClickYesButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.OK_BUTTON_EDIT_COMMENT);
    }

    @Then("Verify delete comment unsuccessful")
    public void verifyDeleteCommentUnsuccessful() {
        String comment = testContext.scenarioContext.getContext(GlobalVariables.COMMENT);
        Assert.assertEquals(getTextAtribute(appiumDriver, ManageProjectPageUI.COMMENT_LABEL), comment);
    }

    @Then("Verify delete comment successful")
    public void verifyDeleteCommentSuccessful() {
        String comment = testContext.scenarioContext.getContext(GlobalVariables.COMMENT);
        Assert.assertFalse(isElementExist(appiumDriver, ManageProjectPageUI.COMMENT_TEXT_LABEL), comment);
    }

    @And("I click delete project")
    public void iClickDeleteProject() {
        manageProject.clickToMoreIconInToolBar();
        manageProject.clickToDeleteButtonInMore();
    }

    @Then("I check delete project unsuccessful")
    public void iCheckDeleteProjectUnsuccessful() {
        manageProject.verifyCreateProjectSuccessful(testContext.scenarioContext.getContext(GlobalVariables.PROJECT_NAME));
    }

    @And("I click delete button")
    public void iClickDeleteButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.OK_BUTTON_EDIT_COMMENT);
    }

    @Then("I check delete project successful")
    public void iCheckDeleteProjectSuccessful() {
        manageProject.verifyCreateProjectSuccessful("Today");
    }
}
