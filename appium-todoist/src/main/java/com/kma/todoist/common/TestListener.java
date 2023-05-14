package com.kma.todoist.common;

import com.kma.todoist.helper.mail.EmailSendUtils;
import org.apache.commons.logging.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    protected static Log log = null;
    static int count_totalTCs;
    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }
    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onFinish(ITestContext result) {
//        Log.info("End suite testing " + result.getName());
        log.info("SEND mail success");
        //Kết thúc và thực thi Extents Report
        log.info("onFinish");
        EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
    }

    @Override
    public void onStart(ITestContext result) {
        log.info("onStart");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        Log.info("Đây là test case bị fail có phần trăm pass: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("onTestFailure");

//        Log.error("Đây là test case bị fail: " + result.getName());
        //Chụp màn hình khi test case bị Fail
        try {
//            Log.error("Test case: " + getTestName(result) + " is failed.");
            count_failedTCs = count_failedTCs + 1;
        } catch (Exception e) {
//            Log.info("Exception while taking screenshot " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("onTestSkipped");

//        Log.warn("Test case: " + getTestName(result) + " is skipped.");
        count_skippedTCs = count_skippedTCs + 1;
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("onTestStart");

//        Log.info("Test case: " + getTestName(result) + " test is starting...");
        count_totalTCs = count_totalTCs + 1;

    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        Log.info("Test case: " + getTestName(result) + " is passed.");
        count_passedTCs = count_passedTCs + 1;

    }
}