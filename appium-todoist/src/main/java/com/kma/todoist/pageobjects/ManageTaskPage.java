package com.kma.todoist.pageobjects;

import com.kma.todoist.common.BasePage;
import com.kma.todoist.interfaces.ManageTaskUI;
import io.appium.java_client.AppiumDriver;

public class ManageTaskPage extends BasePage {
    AppiumDriver appiumDriver;

    public ManageTaskPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputToTaskNameTextbox(String taskName) {
        tapThenSenkeysToElement(appiumDriver, ManageTaskUI.TASK_NAME_TEXTBOX, taskName);
    }

    public void inputToDescriptionTextbox(String description) {
        senkeysToElement(appiumDriver, ManageTaskUI.DESCRIPTION_TEXTBOX, description);
    }

    public void clickToSendButton() {
        clickToElement(appiumDriver, ManageTaskUI.SEND_TASK_BUTTON);
    }

    public void closeAddTask() {
        tapToPosition(appiumDriver);
    }

    public void clickToDueDateButton() {
        clickToElement(appiumDriver, ManageTaskUI.SCHEDULE_BUTTON_IN_CREATE_TASK);
    }

    public void clickToTomorrowButton() {
        clickToElement(appiumDriver, ManageTaskUI.TOMORROW_BUTTON);
    }

    public void clickToThisWeekendButton() {
        clickToElement(appiumDriver, ManageTaskUI.THIS_WEEKEND_BUTTON);
    }

    public void clickToNextWeekendButton() {
        clickToElement(appiumDriver, ManageTaskUI.NEXT_WEEKEND_BUTTON);
    }
    public void clickToNextWeekButton() {
        clickToElement(appiumDriver, ManageTaskUI.NEXT_WEEK_BUTTON);
    }

    public void clickToScheduleButton() {
        clickToElement(appiumDriver, ManageTaskUI.SCHEDULE_BUTTON_IN_DUEDATE);
    }

    public void clickToIconAddTask() {
        isDisplayed(appiumDriver, ManageTaskUI.MORE_ICON_IN_HOME);
        clickToElement(appiumDriver, ManageTaskUI.ADD_TASK_ICON);
    }

    public void clickToOverflowMenu() {
        clickToElement(appiumDriver, ManageTaskUI.OVERFLOW_MENU_ICON);
    }

    public void clickToEditTaskButton() {
        clickToElement(appiumDriver, ManageTaskUI.EDIT_TASK_BUTTON);
    }

    public void clickToDeleteTaskButton() {
        clickToElement(appiumDriver, ManageTaskUI.DELETE_TASK_BUTTON);
    }

    public void checkDisplayTaskNameButton() {
        if (!isElementExist(appiumDriver, ManageTaskUI.ADD_TASK_ICON)) {
            closeAddTask();
        }
    }
}
