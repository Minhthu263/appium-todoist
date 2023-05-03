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

    public void choosePrority(String priority) {
        clickToElement(appiumDriver, ManageTaskUI.PRIORITY_BUTTON);
        clickToElement(appiumDriver, ManageTaskUI.PRIORITY_OPTIONS, priority);
    }

    public void chooseLabel(String label) {
        clickToElement(appiumDriver, ManageTaskUI.MORE_ICON);
        clickToElement(appiumDriver, ManageTaskUI.LABEL_BUTTON);
        clickToElement(appiumDriver, ManageTaskUI.LABEL_OPTIONS, label);
    }

    public void chooseProjectForTask(String projectName) {
        clickToElement(appiumDriver, ManageTaskUI.PROJECT_DROPDOWN);
        clickToElement(appiumDriver, ManageTaskUI.PROJECT_OPTIONS, projectName);
    }

    public void clickToSendButton() {
        clickToElement(appiumDriver, ManageTaskUI.SEND_TASK_BUTTON);
    }

    public void closeAddTask() {
//        clickToElement(appiumDriver, ManageTaskUI.TODAY_LABEL);
//        tapToElementByPosition(appiumDriver, ManageTaskUI.TODAY_LABEL);
        tapToPosition(appiumDriver);
    }
}
