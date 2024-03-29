package com.kma.todoist.cucumber;

import com.kma.todoist.common.BaseSteps;
import com.kma.todoist.common.GlobalVariables;
import com.kma.todoist.factorydevice.AndroidRealDeviceDriver;
import com.kma.todoist.helper.TestContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Hooks extends BaseSteps {

    public static AppiumDriver<MobileElement> driver = null;

    public Hooks(TestContext context) {
        super(context);
    }

    @Before
    public synchronized static AppiumDriver<MobileElement> openAndQuitApp(Scenario scenario) {
        if (driver == null) {
            boolean isLoginTestCase = scenario.getSourceTagNames().contains("@login");
            String device = System.getProperty("device");
            if (isLoginTestCase) {
                try {
                    if (device.startsWith("android")) {
                        driver = new AndroidRealDeviceDriver().getMobileDriverWithoutLogin();
                    } else {
                        log.info("-----------Not support device---------------");
                    }
                } finally {
                    Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
                }
            } else {
                try {
                    if (device.startsWith("android")) {
                        driver = new AndroidRealDeviceDriver().getMobileDriver();
                    } else {
                        log.info("-----------Not support device---------------");
                    }
                } finally {
                    Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
                }
            }
            driver.manage().timeouts().implicitlyWait(GlobalVariables.TIME_OUT, TimeUnit.SECONDS);
        }
        return driver;
    }

    public synchronized static AppiumDriver<MobileElement> openAndQuitApp() {
        if (driver == null) {
            String device = System.getProperty("device");
            try {
                if (device.startsWith("android")) {
                    driver = new AndroidRealDeviceDriver().getMobileDriver();
                } else {
                    log.info("-----------Not support device---------------");
                }
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
            log.info("-----------Start the device---------------");
            driver.manage().timeouts().implicitlyWait(GlobalVariables.TIME_OUT, TimeUnit.SECONDS);
        }
        File path = new File(String.join(File.separator, System.getProperty("user.dir"), "screenshot"));
        try {
            FileUtils.cleanDirectory(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    public static void close() {
        try {
            if (driver != null) {
//                openAndQuitApp().quit();
                driver.quit();
                driver = null;
                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    public static void tearDownApp(Scenario scenario) {
        if (scenario.isFailed()) {
            log.info("------------- " + scenario.getName() + " -------------" + scenario.getStatus());
            log.info("------------- DRIVER DOWN -------------");
//            driver.closeApp();
            driver = null;
        } else {
            log.info("------------- " + scenario.getName() + " -------------" + scenario.getStatus());
        }
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            addScreenshot(scenario);
            scenario.attach(Files.readAllBytes(addScreenshot(scenario)), "png", scenario.getName());

            log.info("------------- " + scenario.getName() + " -------------" + scenario.getStatus());
            log.info("------------- DRIVER DOWN -------------");
//            driver.closeApp();
            driver = null;
        } else {
            log.info("------------- " + scenario.getName() + " -------------" + scenario.getStatus());
        }
    }

    public static Path addScreenshot(Scenario scenario) {
        String folderName = "screenshot";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        new File(folderName);
        String fileName = scenario.getName() + ".png";
        try {
            FileUtils.copyFile(screenshotFile, new File(folderName + "/" + fileName));
        } catch (Exception ignored) {
        }
        return Paths.get(folderName + "/" + fileName);
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }
}
