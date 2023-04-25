package com.kma.todoist.cucumber.stepdefinitions.managetask;

import com.kma.todoist.common.BaseSteps;
import com.kma.todoist.cucumber.Hooks;
import com.kma.todoist.helper.TestContext;
import com.kma.todoist.helper.object.Task;
import com.kma.todoist.interfaces.ManageTaskUI;
import com.kma.todoist.pageobjects.ManageTaskPage;
import com.kma.todoist.pageobjects.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class ManageTaskStepdef extends BaseSteps {
    AppiumDriver<MobileElement> appiumDriver;
    TestContext testContext;
    ManageTaskPage manageTask;

    SoftAssert softAssert = new SoftAssert();

    public ManageTaskStepdef(TestContext context) {
        super(context);
        this.appiumDriver = Hooks.openAndQuitApp();
        manageTask = PageGeneratorManager.getManageTaskPage(appiumDriver);
        testContext = context;
    }

    @Given("I click icon Add Task")
    public void i_click_icon_add_task() {
        log.info("ManageTask - STEP - Click icon Add task");
        clickToElement(appiumDriver, ManageTaskUI.ADD_TASK_ICON);
    }

    @When("I input information")
    public void iInputInformation(Map<String, String> data) {
        log.info("ManageTask - STEP - Nhập thông tin");
        String taskName = data.get("taskName");
        String description = data.get("description");
        String priority = data.get("priority");
        String label = data.get("label");
        String projectName = data.get("projectName");

//        manageTask.inputToTaskNameTextbox(taskName);

        String value = taskName;
        if(priority != null){
            value += " !!" + priority;
        }
        if(label != null){
            value += " @" + label;
        }
        if(projectName != null){
            value += " #" + projectName;
        }
        manageTask.inputToTaskNameTextbox(value);
        if(description != null){
            manageTask.inputToDescriptionTextbox(description);
        }

        Task task = new Task(taskName, description, priority, label, projectName);
        testContext.scenarioContext.setContext("task", task);
    }

    @And("I click Send button")
    public void iClickSendButton() {
        log.info("ManageTask - STEP - Send button");
        manageTask.clickToSendButton();
        manageTask.closeAddTask();
    }

    @Then("Verify add task")
    public void verifyAddTask() {
        log.info("ManageTask - STEP - Verify add task");
        Task task = testContext.scenarioContext.getContext("task");
        String taskName = task.getTaskName();

        checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.TASK_NAME_LABEL, taskName), taskName);
        if (task.getPriority() != null) {
//            checkEqualsSoft(softAssert,getTextAtribute(appiumDriver, ManageTaskUI.PRIORITY_LABEL, task.getTaskName()), task.getPriority());
        }
        if (task.getLabel() != null) {
            checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.LABEL_LABEL, taskName), task.getLabel());
        }
        if (task.getProjectName() != null) {
            checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.PROJECT_LABEL, taskName), task.getProjectName());
        }

        if (task.getDescription() != null) {
            checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.DESCRIPTION_LABEL, taskName), task.getDescription());
        }
        softAssert.assertAll();
    }
}
