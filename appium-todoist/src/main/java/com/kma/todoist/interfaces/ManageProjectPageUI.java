package com.kma.todoist.interfaces;

public class ManageProjectPageUI {
    public static final String ADD_PROJECT_ICON = "//android.view.View[@content-desc='Add']/following-sibling::android.widget.Button";
    public static final String PROJECT_NAME_TEXTBOX = "//android.widget.EditText[@resource-id='com.todoist:id/name']";
    public static final String COMPLETE_PROJECT_ICON = "//android.widget.Button[@content-desc='Done']";
    public static final String COLOR_BUTTON = "//android.widget.TextView[@text='Color']";
    public static final String DYNAMIC_CHOOSE_BUTTON = "//android.widget.TextView[@text='%s']";
    public static final String PARENT_BUTTON = "//android.widget.TextView[@text='Parent']";
    public static final String FAVORITE_BUTTON = "//android.widget.Switch[@resource-id='com.todoist:id/favorite']";
    public static final String VIEW_BOARD_BUTTON = "//android.widget.CheckedTextView[@text='Board']";
    public static final String PROJECT_NAME_LABEL = "//android.view.ViewGroup[@resource-id='com.todoist:id/toolbar']/android.widget.TextView";
    public static final String OPTION_BUTTON = "//android.widget.TextView[@text='%s']/following-sibling::android.view.View";
    public static final String ARCHIVE_OPTION_BUTTON = "//android.widget.ScrollView//android.widget.TextView[@text='Archive']";
    public static final String ACCEPT_ARCHIVE_BUTTON = "//android.widget.ScrollView[@resource-id='com.todoist:id/buttonPanel']//android.widget.Button[@text='ARCHIVE']";
    public static final String CANCEL_ARCHIVE_BUTTON = "//android.widget.ScrollView[@resource-id='com.todoist:id/buttonPanel']//android.widget.Button[@text='CANCEL']";
    public static final String PROJECT_NAME_BUTTON = "//android.widget.TextView[@text='%s']";
    public static final String MORE_ICON_IN_TOOLBAR = "//android.widget.ImageView[@content-desc='More options']";
    public static final String EDIT_PROJECT_BUTTON_IN_MORE = "//android.widget.TextView[@resource-id='com.todoist:id/title' and @text='Edit project']";
}
