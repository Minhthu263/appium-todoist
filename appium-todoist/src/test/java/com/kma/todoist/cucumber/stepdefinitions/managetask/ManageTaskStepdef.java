package com.kma.todoist.cucumber.stepdefinitions.managetask;

import com.kma.todoist.common.BaseSteps;
import com.kma.todoist.common.GlobalVariables;
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
import org.testng.Assert;
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
//        isDisplayed(appiumDriver, ManageTaskUI.TODAY_LABEL);
//        isDisplayed(appiumDriver, ManageTaskUI.MORE_ICON_IN_HOME);
//        if (!isElementExist(appiumDriver, ManageTaskUI.ADD_TASK_ICON)){
//            manageTask.closeAddTask();
//        }
//        clickToElement(appiumDriver, ManageTaskUI.ADD_TASK_ICON);

        manageTask.clickToIconAddTask();
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
        if (priority != null) {
            value += " !!" + priority;
        }
        if (label != null) {
            value += " @" + label;
        }
        if (projectName != null) {
            value += " #" + projectName;
        }
        manageTask.inputToTaskNameTextbox(value);
        if (description != null) {
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

    @When("I view task {string}")
    public void iViewTask(String taskName) {
        isDisplayed(appiumDriver, ManageTaskUI.TODAY_LABEL);
//        scrollMobileUpToElement(appiumDriver, ManageTaskUI.TASK_NAME_BUTTON, taskName);
        clickToElement(appiumDriver, ManageTaskUI.TASK_NAME_BUTTON, taskName);
    }

    @Then("Verify add task detail")
    public void verifyAddTaskDetail(Map<String, String> data) {
        String taskName = data.get("taskName");
        String description = data.get("description");
        String priority = data.get("priority");
        String label = data.get("label");
        String projectName = data.get("projectName");

        SoftAssert softAssert = new SoftAssert();
        if (taskName != null) {
            softAssert.assertTrue(getTextAtribute(appiumDriver, ManageTaskUI.TASK_NAME_LABEL_IN_DETAIL_TASK).contains(taskName));
        }
        if (priority != null && !priority.equals("4")) {
            softAssert.assertEquals(getTextAtribute(appiumDriver, ManageTaskUI.PRIORITY_LABEL_IN_DETAIL_TASK), "Priority " + priority);
        }
        if (label != null) {
            softAssert.assertEquals(getTextAtribute(appiumDriver, ManageTaskUI.LABEL_LABEL_IN_DETAIL_TASK), label);
        }
        if (projectName != null) {
            softAssert.assertTrue(getTextAtribute(appiumDriver, ManageTaskUI.PROJECT_NAME_LABEL_IN_DETAIL_TASK).contains(projectName));
        }
        if (description != null) {
            softAssert.assertEquals(getTextAtribute(appiumDriver, ManageTaskUI.DESCRIPTION_LABEL_IN_DETAIL_TASK), description);
        }
        manageTask.closeAddTask();
        softAssert.assertAll();
    }

    @And("I click to Inbox")
    public void iClickToInbox() {
        clickToElement(appiumDriver, ManageTaskUI.INBOX_MENU_BAR);
    }

    @When("I choose Tomorrow")
    public void iChooseTomorrow() {
        manageTask.clickToDueDateButton();
        manageTask.clickToTomorrowButton();
        testContext.scenarioContext.setContext(GlobalVariables.TASK_DUE_DATE, "Tomorrow");
    }

    @When("I input to Task name")
    public void iInputToTaskName() {
        String taskName = "Task " + generateNumber();
        testContext.scenarioContext.setContext(GlobalVariables.TASK_NAME, taskName);
        manageTask.inputToTaskNameTextbox(taskName);
//        tapThenSenkeysToElement(appiumDriver, ManageTaskUI.TASK_NAME_TEXTBOX, taskName);
    }

    @Then("Verify add task tomorrow")
    public void verifyAddTaskTomorrow() {
        String taskName = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
        checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.TASK_NAME_LABEL, taskName), taskName);
        checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.DUE_DATE_LABEL, taskName), "Tomorrow");
    }

    @And("I choose This weekend")
    public void iChooseThisWeekend() {
        manageTask.clickToDueDateButton();

        if (isElementExist(appiumDriver, ManageTaskUI.THIS_WEEKEND_BUTTON)) {
            manageTask.clickToThisWeekendButton();
            testContext.scenarioContext.setContext(GlobalVariables.TASK_DUE_DATE, "Saturday");
        } else if (isElementExist(appiumDriver, ManageTaskUI.NEXT_WEEKEND_BUTTON)){
            manageTask.clickToNextWeekendButton();
            testContext.scenarioContext.setContext(GlobalVariables.TASK_DUE_DATE, "Saturday");
        } else {
            manageTask.clickToNextWeekButton();
            testContext.scenarioContext.setContext(GlobalVariables.TASK_DUE_DATE, "Monday");
        }
//        testContext.scenarioContext.setContext(GlobalVariables.TASK_DUE_DATE, "Saturday");

    }

    @Then("Verify add task this weekend")
    public void verifyAddTaskThisWeekend() {
        String taskName = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
        checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.TASK_NAME_LABEL, taskName), taskName);
        checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.DUE_DATE_LABEL, taskName), "Saturday");
    }

    @And("I choose any day")
    public void iChooseAnyDay() {
        manageTask.clickToDueDateButton();
//        manageTask.clickToAnyDayButton();
        clickToElement(appiumDriver, ManageTaskUI.ANY_DAY_BUTTON);
        String[] date = getContentdescAtribute(appiumDriver, ManageTaskUI.ANY_DAY_BUTTON).split(" ");
        int i = Integer.parseInt(date[0]);
        String day = Integer.toString(i);
        testContext.scenarioContext.setContext(GlobalVariables.TASK_DUE_DATE, date[1] + " " + day);
        manageTask.clickToScheduleButton();
    }

    @Then("Verify add task different today")
    public void verifyAddTaskDifferentToday() {
        String taskName = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
        String taskDueDate = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
        checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.TASK_NAME_LABEL, taskName), taskName);
        checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.DUE_DATE_LABEL, taskName), taskDueDate);
    }

    @And("I choose schedule")
    public void iChooseSchedule() {
        manageTask.clickToDueDateButton();
        manageTask.clickToScheduleButton();
        testContext.scenarioContext.setContext(GlobalVariables.TASK_DUE_DATE, "Today");
    }

    @Then("Verify add task no due date")
    public void verifyAddTaskNoDueDate() {
        String taskName = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
        checkEqualsSoft(softAssert, getTextAtribute(appiumDriver, ManageTaskUI.TASK_NAME_LABEL, taskName), taskName);
    }

    @When("I click complete task {string}")
    public void iClickCompleteTask(String taskName) {
        clickToElement(appiumDriver, ManageTaskUI.COMPLETE_TASK_CHECKBOX, taskName);
    }

    @Then("Verify complete")
    public void verifyComplete() {
        Assert.assertTrue(isDisplayed(appiumDriver, ManageTaskUI.COMPLETE_MSG));
    }

    @And("I click Discard task")
    public void iClickDiscardTask() {
        manageTask.closeAddTask();
        clickToElement(appiumDriver, ManageTaskUI.DISCARD_TASK_BUTTON);
    }

    @Then("Verify create task unsuccessful")
    public void verifyCreateTaskUnsuccessful() {
        String taskName = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
//        Assert.assertTrue(isNotDisplayed(appiumDriver, ManageTaskUI.TASK_NAME_LABEL, taskName));
        Assert.assertFalse(isElementExist(appiumDriver, ManageTaskUI.TASK_NAME_LABEL, taskName));
    }

    @When("I input to Task name in the past")
    public void iInputToTaskNameInThePast() {
        String taskName = "Task " + generateNumber();
        tapThenSenkeysToElement(appiumDriver, ManageTaskUI.TASK_NAME_TEXTBOX, "1 May 2020 " + taskName);
        testContext.scenarioContext.setContext(GlobalVariables.TASK_NAME, taskName);
    }

    @Then("Verify add task unccessful")
    public void verifyAddTaskUnccessful() {
    }

    @And("I click to Today")
    public void iClickToToday() {
        clickToElement(appiumDriver, ManageTaskUI.TODAY_MENU_BAR);
    }

    @And("I create task")
    public void iCreateTask() {
        String taskName = "Task " + generateNumber();
        testContext.scenarioContext.setContext(GlobalVariables.TASK_NAME, taskName);
        manageTask.clickToIconAddTask();
        manageTask.inputToTaskNameTextbox(taskName);
        manageTask.clickToSendButton();
        manageTask.closeAddTask();
    }

    @When("I click view task")
    public void iClickViewTask() {
        String taskName = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
        isDisplayed(appiumDriver, ManageTaskUI.MORE_ICON_IN_HOME);
        clickToElement(appiumDriver, ManageTaskUI.TASK_NAME_BUTTON, taskName);
    }

    @And("I click edit task")
    public void iClickEditTask() {
        manageTask.clickToOverflowMenu();
        manageTask.clickToEditTaskButton();
    }

    @And("I edit task information")
    public void iEditTaskInfomation() {
        String taskName = "Task " + generateNumber();
        testContext.scenarioContext.setContext(GlobalVariables.TASK_NAME, taskName);
        tapThenSenkeysToElement(appiumDriver, ManageTaskUI.TASK_NAME_TEXTBOX_IN_EDIT_TASK, taskName);
    }

    @Then("Verify edit task successful")
    public void verifyEditTaskSuccessful() {
        String taskName = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
        Assert.assertTrue(getTextAtribute(appiumDriver, ManageTaskUI.TASK_NAME_TEXTBOX_IN_EDIT_TASK).contains(taskName));
    }

    @When("I click delete task")
    public void iClickDeleteTask() {
        manageTask.clickToOverflowMenu();
        manageTask.clickToDeleteTaskButton();
    }

    @And("I choose No")
    public void iChooseNo() {
        clickToElement(appiumDriver, ManageTaskUI.CANCEL_BUTTON);
    }

    @Then("Verify delete task unsuccessful")
    public void verifyDeleteTaskUnsuccessful() {
        Assert.assertTrue(isElementExist(appiumDriver, ManageTaskUI.TASK_NAME_TEXTBOX_IN_EDIT_TASK));
    }

    @And("I choose Yes")
    public void iChooseYes() {
        clickToElement(appiumDriver, ManageTaskUI.ACCEPT_BUTTON);
    }

    @Then("Verify delete task successful")
    public void verifyDeleteTaskSuccessful() {
        String taskName = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
        isDisplayed(appiumDriver, ManageTaskUI.MORE_ICON_IN_HOME);
//        clickToElement(appiumDriver, ManageTaskUI.TASK_NAME_BUTTON, taskName);
        Assert.assertFalse(isElementExist(appiumDriver, ManageTaskUI.TASK_NAME_BUTTON, taskName));
    }

    @And("I edit task information with {string}")
    public void iEditTaskInfomationWith(String taskName) {
        testContext.scenarioContext.setContext(GlobalVariables.TASK_NAME, taskName);
        tapThenSenkeysToElement(appiumDriver, ManageTaskUI.TASK_NAME_TEXTBOX_IN_EDIT_TASK, taskName);
    }

    @Then("Verify edit task unsuccessful")
    public void verifyEditTaskUnsuccessful() {
        Assert.assertEquals(getAttribute(appiumDriver,ManageTaskUI.SAVE_BUTTON_IN_EDIT_TASK, "enabled"),"false");
        clickToElement(appiumDriver, ManageTaskUI.BACK_BUTTON_IN_EDIT_TASK);
        clickToElement(appiumDriver, ManageTaskUI.ACCEPT_BUTTON);
    }

    @And("I click to Save")
    public void iClickToSave() {
        clickToElement(appiumDriver, ManageTaskUI.SAVE_BUTTON_IN_EDIT_TASK);
    }

    @And("I click Back")
    public void iClickBack() {
        clickToElement(appiumDriver, ManageTaskUI.BACK_BUTTON_IN_EDIT_TASK);
        clickToElement(appiumDriver, ManageTaskUI.ACCEPT_BUTTON);
    }

    @Then("Verify edit task unsuccessful when back")
    public void verifyEditTaskUnsuccessfulWhenBack() {
        String taskName = testContext.scenarioContext.getContext(GlobalVariables.TASK_NAME);
        Assert.assertFalse(getTextAtribute(appiumDriver, ManageTaskUI.TASK_NAME_TEXTBOX_IN_EDIT_TASK).contains(taskName));
    }
}
