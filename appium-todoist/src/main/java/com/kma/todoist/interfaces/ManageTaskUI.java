package com.kma.todoist.interfaces;

public class ManageTaskUI {
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
    public static final String TASK_NAME_BUTTON = "//android.widget.TextView[@resource-id='com.todoist:id/text' and @text='%s']";
    public static final String TASK_NAME_LABEL_IN_DETAIL_TASK = "//android.widget.EditText[@resource-id='com.todoist:id/item_content']";
    public static final String PRIORITY_LABEL_IN_DETAIL_TASK = "//android.view.ViewGroup[@resource-id='com.todoist:id/item_attribute_priority']//android.widget.TextView";
    public static final String LABEL_LABEL_IN_DETAIL_TASK = "//android.view.ViewGroup[@resource-id='com.todoist:id/item_attribute_labels']//android.widget.TextView";
    public static final String PROJECT_NAME_LABEL_IN_DETAIL_TASK = "//android.widget.TextView[@resource-id='com.todoist:id/item_parent']";
    public static final String DESCRIPTION_LABEL_IN_DETAIL_TASK = "//android.widget.EditText[@resource-id='com.todoist:id/item_description']";
    public static final String INBOX_MENU_BAR = "//android.view.ViewGroup[@resource-id='com.todoist:id/list_container']//android.widget.TextView[@text='Inbox']";
    public static final String SCHEDULE_BUTTON_IN_CREATE_TASK = "//android.widget.TextView[@resource-id='com.todoist:id/schedule']";
    public static final String TOMORROW_BUTTON = "//android.widget.TextView[@resource-id='android:id/text1' and @text='Tomorrow']";
    public static final String DUE_DATE_LABEL = "//android.widget.TextView[@resource-id='com.todoist:id/text' and @text='%s']/following-sibling::android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.todoist:id/due_date']";
    public static final String MORE_ICON_IN_HOME = "//android.widget.ImageView[@content-desc='More options']";
    public static final String THIS_WEEKEND_BUTTON = "//android.widget.TextView[@resource-id='android:id/text1' and @text='This weekend']";
    public static final String ANY_DAY_BUTTON = "//android.view.View[@resource-id='com.todoist:id/month_view'][2]/android.view.View[8]";
    public static final String SCHEDULE_BUTTON_IN_DUEDATE = "//android.widget.Button[@resource-id='com.todoist:id/scheduler_submit']";
    public static final String COMPLETE_TASK_CHECKBOX = "//android.widget.TextView[@resource-id='com.todoist:id/text' and @text='%s']/preceding-sibling::android.widget.CheckBox";
    public static final String COMPLETE_MSG = "//android.widget.TextView[@text='Completed.']";
    public static final String DISCARD_TASK_BUTTON = "//android.widget.Button[@text='DISCARD']";
    public static final String NEXT_WEEKEND_BUTTON = "//android.widget.TextView[@resource-id='android:id/text1' and @text='Next weekend']";
}
