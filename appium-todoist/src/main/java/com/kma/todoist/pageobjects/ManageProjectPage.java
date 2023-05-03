package com.kma.todoist.pageobjects;

import com.kma.todoist.common.BasePage;
import com.kma.todoist.interfaces.ManageProjectPageUI;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class ManageProjectPage extends BasePage {
    AppiumDriver appiumDriver;

    public ManageProjectPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickToIconAddProject() {
        clickToElement(appiumDriver, ManageProjectPageUI.ADD_PROJECT_ICON);
    }

    public void inputToProjectNameTextbox(String projectName) {
        senkeysToElement(appiumDriver, ManageProjectPageUI.PROJECT_NAME_TEXTBOX, projectName);
    }

    public void clickToIconCompleteProject() {
        clickToElement(appiumDriver, ManageProjectPageUI.COMPLETE_PROJECT_ICON);
    }

    public void verifyCreateProjectSuccessful(String projectName) {
        Assert.assertEquals(getText(appiumDriver, ManageProjectPageUI.PROJECT_NAME_LABEL), projectName);
    }

    public void clickToColorButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.COLOR_BUTTON);
    }

    public void clickChooseColor(String color) {
        clickToElement(appiumDriver, ManageProjectPageUI.DYNAMIC_CHOOSE_BUTTON, color);
    }

    public void clickToParentButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.PARENT_BUTTON);
    }

    public void clickChooseParent(String parent) {
        clickToElement(appiumDriver, ManageProjectPageUI.DYNAMIC_CHOOSE_BUTTON, parent);
    }

    public void clickChooseFavorite() {
        clickToElement(appiumDriver, ManageProjectPageUI.FAVORITE_BUTTON);
    }

    public void clickChooseViewBoard() {
        clickToElement(appiumDriver, ManageProjectPageUI.VIEW_BOARD_BUTTON);
    }

    public void clickToOption(String projectName) {
        clickToElement(appiumDriver, ManageProjectPageUI.OPTION_BUTTON, projectName);
    }

    public void clickToArchiveOption() {
        clickToElement(appiumDriver, ManageProjectPageUI.ARCHIVE_OPTION_BUTTON);
    }

    public void clickToAcceptArchiveButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.ACCEPT_ARCHIVE_BUTTON);
    }

    public void clickToCancelArchiveButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.CANCEL_ARCHIVE_BUTTON);
    }

    public void clickToProjectName(String projectName) {
        clickToElement(appiumDriver, ManageProjectPageUI.PROJECT_NAME_BUTTON, projectName);
    }

    public void clickToMoreIconInToolBar() {
        clickToElement(appiumDriver, ManageProjectPageUI.MORE_ICON_IN_TOOLBAR);
    }

    public void clickToEditButtonInMore() {
        clickToElement(appiumDriver, ManageProjectPageUI.EDIT_PROJECT_BUTTON_IN_MORE);
    }

    public void clickToDeleteButtonInMore() {
        clickToElement(appiumDriver, ManageProjectPageUI.DELETE_PROJECT_BUTTON_IN_MORE);
    }

    public void clickToTabArchived() {
        clickToElement(appiumDriver, ManageProjectPageUI.ARCHIVED_TAB);
    }

    public void verifyProjectIsDisplay(String name) {
        isDisplayed(appiumDriver, ManageProjectPageUI.PROJECT_NAME_BUTTON, name);
    }

    public void clickToUnarchiveOption() {
        clickToElement(appiumDriver, ManageProjectPageUI.UNARCHIVE_OPTION_BUTTON);
    }

    public void clickToTabActive() {
        clickToElement(appiumDriver, ManageProjectPageUI.ACTIVE_TAB);
    }

    public void clickToAcceptUnarchiveButton() {
        clickToElement(appiumDriver, ManageProjectPageUI.ACCEPT_UNARCHIVE_BUTTON);
    }

    public void clickToBackIcon() {
        clickToElement(appiumDriver, ManageProjectPageUI.BACK_ICON);
    }

    public void clickToOpenMenu() {
        clickToElement(appiumDriver, ManageProjectPageUI.OPEN_MENU_PROJECT);

    }

    public void clickToCommentOption() {
        clickToElement(appiumDriver, ManageProjectPageUI.COMMENT_OPTION_BUTTON);
    }
}
