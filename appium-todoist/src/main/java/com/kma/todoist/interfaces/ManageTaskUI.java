package com.kma.todoist.interfaces;

public class ManageTaskUI{
    public static final String ADD_TASK_ICON = "//android.widget.ImageButton[@content-desc='Quick add']";
    public static final String TASK_NAME_TEXTBOX = "//android.widget.EditText[@resource-id='android:id/message']";
    public static final String DESCRIPTION_TEXTBOX = "//android.widget.EditText[@resource-id='com.todoist:id/description']";
    public static final String PRIORITY_BUTTON = "//android.widget.TextView[@resource-id='com.todoist:id/priority']";
    public static final String PRIORITY_OPTIONS = "";
    public static final String MORE_ICON = "//android.widget.TextView[@resource-id='com.todoist:id/more']";
    public static final String LABEL_BUTTON = "";
    public static final String LABEL_OPTIONS = "";
    public static final String PROJECT_DROPDOWN = "//android.widget.TextView[@resource-id='com.todoist:id/project']";
    public static final String PROJECT_OPTIONS = "";
    public static final String SEND_TASK_BUTTON = "//android.widget.ImageView[@content-desc='Add']";
    public static final String TODAY_LABEL = "//android.view.ViewGroup[@resource-id='com.todoist:id/toolbar']/android.widget.TextView[@text='Today']";
    public static final String TASK_NAME_LABEL = "//android.widget.TextView[@resource-id='com.todoist:id/text' and @text='%s']";
    public static final String DESCRIPTION_LABEL = "//android.widget.TextView[@resource-id='com.todoist:id/text' and @text='%s']/following-sibling::android.widget.TextView[@resource-id='com.todoist:id/description']";
    public static final String LABEL_LABEL = "//android.widget.TextView[@resource-id='com.todoist:id/text' and @text='%s']/following-sibling::android.widget.RelativeLayout/android.widget.TextView[@resource-id='com.todoist:id/labels']";
    public static final String PROJECT_LABEL = "//android.widget.TextView[@resource-id='com.todoist:id/text' and @text='%s']/following-sibling::android.widget.RelativeLayout/android.widget.TextView[@resource-id='com.todoist:id/breadcrumb']";
}
