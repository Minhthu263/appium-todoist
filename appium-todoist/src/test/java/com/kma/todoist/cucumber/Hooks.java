package com.kma.todoist.cucumber;

//import com.epam.reportportal.message.ReportPortalMessage;

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
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Hooks extends BaseSteps {

    public static AppiumDriver<MobileElement> driver = null;
//    private static TestContext testContext;

    public Hooks(TestContext context) {
        super(context);
//        testContext = context;
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

            //      log.info("-----------Start the device---------------");
            driver.manage().timeouts().implicitlyWait(GlobalVariables.TIME_OUT, TimeUnit.SECONDS);
        }
//        File path = new File(String.join(File.separator, System.getProperty("user.dir"), "screenshot"));
//        try {
//            FileUtils.cleanDirectory(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
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
            //      log.info("-----------Start the device---------------");
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
                openAndQuitApp().quit();
                driver = null;
                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }
//
//    public static void tearDownApp(Scenario scenario) {
//        if (scenario.isFailed()) {
//            log.info("------------- " + scenario.getName() + " -------------" + scenario.getStatus());
//            log.info("------------- DRIVER DOWN -------------");
////            driver.closeApp();
//            driver = null;
//        } else {
//            log.info("------------- " + scenario.getName() + " -------------" + scenario.getStatus());
//        }
//    }

//    private static String nameImage() {
//        return UUID.randomUUID().toString();
//    }

//    public AppiumDriver<MobileElement> getDriver() {
//        return driver;
//    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
//            addScreenshot();
//            scenario.attach(Files.readAllBytes(lastestImage()), "png", scenario.getName());
            log.info("------------- " + scenario.getName() + " -------------" + scenario.getStatus());
            log.info("------------- DRIVER DOWN -------------");
            driver.closeApp();
//            driver = null;
        } else {
//            addScreenshot();
            log.info("------------- " + scenario.getName() + " -------------" + scenario.getStatus());
        }
    }

//    public static void ScreenShot() {
//        ReportPortalMessage message = null;
//        String folderName = "screenshot";
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy__hh_mm_sssaa");
//        new File(folderName).mkdir();
//        String fileName = dateFormat.format(new Date()) + ".png";
//
//        try {
//            FileUtils.copyFile(screenshotFile, new File(folderName + "/" + fileName));
//            message = new ReportPortalMessage(screenshotFile, fileName);
//        } catch (Exception e) {
//        }
//    }
//
//    public static void addScreenshot() {
//        ReportPortalMessage message = null;
//        String folderName = "screenshot";
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String string = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy__hh_mm_sssaa");
//        new File(folderName).mkdir();
//        String fileName = dateFormat.format(new Date()) + ".png";
//
//        try {
//            FileUtils.copyFile(screenshotFile, new File(folderName + "/" + fileName));
//            //  message = new ReportPortalMessage(string);
//        } catch (Exception e) {
//        }
//    }

//    private Path lastestImage() {
//        File root = new File(String.join(File.separator, System.getProperty("user.dir"), "screenshot"));
//        File[] images = root.listFiles(file -> file.isFile() && file.getName().toLowerCase().endsWith(".png"));
//        File lastestImg = images[0];
//        for (File image : images) {
//            if (image.lastModified() > lastestImg.lastModified()) {
//                lastestImg = image;
//            }
//        }
//        return lastestImg.toPath();
//    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

}
