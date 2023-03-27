package com.kma.todoist.common;

import com.kma.todoist.helper.TestContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BaseSteps extends BasePage {
    protected static Log log = null;
    static TestContext testContext = new TestContext();

    public BaseSteps(TestContext context) {
        super();
        log = LogFactory.getLog(getClass());
        testContext = context;

    }

    private boolean checkTrue(boolean condition) {

        boolean pass = true;
        try {
            if (condition) {
                printLogPass();

            } else {
                //log4j
                printLogFail();

            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

        }
        return pass;
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (!condition) {
                printLogPass();
            } else {
                printLogFail();
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
        }
        return pass;
    }

    private boolean checkEquals(Object actual, Object expected) {

        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            printLogPass();
        } catch (Throwable e) {
            pass = false;
            log.info("\nExpect: " + expected + "\nActual: " + actual);
            printLogFail();

        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }


    public boolean checkTrueSoft(SoftAssert soft, boolean condition) {
        boolean pass = true;
        try {
            soft.assertTrue(condition);
            printLogPass();

        } catch (Throwable e) {
            printLogFail();
            log.warn("Exception = " + e.getMessage());
            pass = false;
        }
        return pass;
    }

    public boolean checkFalseSoft(SoftAssert soft, boolean condition) {
        boolean pass = true;
        try {
            soft.assertFalse(condition);
            printLogPass();
        } catch (Throwable e) {
            printLogFail();
            log.warn("Exception = " + e.getMessage());
            pass = false;
        }
        return pass;
    }

    public boolean checkEqualsSoft(SoftAssert soft, Object actual, Object expected) {
        boolean pass = true;
        try {
            soft.assertEquals(actual, expected);
            printLogPass();
        } catch (Throwable e) {
            printLogFail();
            log.warn("Exception = " + e.getMessage());
            pass = false;
        }
        return pass;
    }


    private void printLogPass() {
        log.info(" -------------------------- PASSED -------------------------- ");
    }

    private void printLogFail() {
        log.info(" -------------------------- FAILED -------------------------- ");
    }
}
