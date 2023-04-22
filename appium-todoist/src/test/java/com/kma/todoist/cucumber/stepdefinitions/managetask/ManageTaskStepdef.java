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

import java.util.Map;

public class ManageTaskStepdef extends BaseSteps {
    AppiumDriver<MobileElement> appiumDriver;
    TestContext testContext;
    ManageTaskPage manageTask;

    public ManageTaskStepdef(TestContext context) {
        super(context);
        this.appiumDriver = Hooks.openAndQuitApp();
        manageTask = PageGeneratorManager.getManageTaskPage(appiumDriver);
        testContext = context;
    }

    @Given("I click icon Add Task")
    public void i_click_icon_add_task() {
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
//            manageTask.choosePrority(priority);
            value += " !!" + priority;
//            manageTask.inputToTaskNameTextbox(value);
        }
        if(label != null){
//            manageTask.chooseLabel(label);
            value += " @" + label;
//            manageTask.inputToTaskNameTextbox(value);
        }
        if(projectName != null){
//            manageTask.chooseProjectForTask(projectName);
            value += " #" + projectName;
//            manageTask.inputToTaskNameTextbox(value);
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
        manageTask.clickToSendButton();
    }

    @Then("Verify add task")
    public void verifyAddTask() {
    }
}
