package com.kma.todoist.common;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;

public class BasePage {

    protected static void setImplicitlyWait(AppiumDriver<MobileElement> appiumDriver, long timeout) {
        appiumDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    protected static void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected static String getDay(int count) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(c.getTime());
        c.add(Calendar.DATE, count);  // number of days to add
        return sdf.format(c.getTime());
    }

    protected boolean isElementExist(AppiumDriver<MobileElement> appiumDriver, String locator) {
        setImplicitlyWait(appiumDriver, GlobalVariables.SHORT_TIME_OUT);
        boolean check = findElementsByXpath(appiumDriver, locator).isEmpty();
        setImplicitlyWait(appiumDriver, GlobalVariables.TIME_OUT);
        return !check;
    }

    protected MobileElement findElementByXpath(AppiumDriver<MobileElement> appiumDriver, String locator) {
        return appiumDriver.findElement(By.xpath(locator));
    }

    protected List<MobileElement> findElementsByXpath(AppiumDriver<MobileElement> appiumDriver, String locator) {
        return appiumDriver.findElements(By.xpath(locator));
    }

    protected List<MobileElement> findElementsByXpath(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        return appiumDriver.findElements(By.xpath(getLocatorDynamic(locator, value)));
    }

    protected MobileElement findElementByXpath(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {

        return appiumDriver.findElement(By.xpath(getLocatorDynamic(locator, value)));

    }

    protected String getLocatorDynamic(String locator, String... value) {
        locator = String.format(locator, (Object[]) value);
        return locator;
    }

    protected void waitForVisible(AppiumDriver<MobileElement> appiumDriver, String locator) {

        WebDriverWait wait = new WebDriverWait(appiumDriver, GlobalVariables.TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitForVisible(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, GlobalVariables.TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getLocatorDynamic(locator, value))));
    }

    protected void waitForNotVisible(AppiumDriver<MobileElement> appiumDriver, String locator) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, GlobalVariables.TIME_OUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitForClickable(AppiumDriver<MobileElement> appiumDriver, String locator) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, GlobalVariables.TIME_OUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    protected void waitForClickable(AppiumDriver<MobileElement> appiumDriver, String locator, String... values) {

        WebDriverWait wait = new WebDriverWait(appiumDriver, GlobalVariables.TIME_OUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getLocatorDynamic(locator, values))));
    }

    protected void clickToElement(AppiumDriver<MobileElement> appiumDriver, String locator) {
        waitForClickable(appiumDriver, locator);
        findElementByXpath(appiumDriver, locator).click();
    }

    protected void clearInputFeild(AppiumDriver<MobileElement> appiumDriver, String locator) {
        waitForClickable(appiumDriver, locator);
        findElementByXpath(appiumDriver, locator).click();
        findElementByXpath(appiumDriver, locator).clear();
    }

    protected void clickToElement(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        waitForClickable(appiumDriver, locator, value);
        findElementByXpath(appiumDriver, locator, value).click();
    }

    protected void checkCheckbox(AppiumDriver<MobileElement> appiumDriver, String locator) {
        if (!findElementByXpath(appiumDriver, locator).getAttribute("checked").equals("true")) {
            clickToElement(appiumDriver, locator);
        }
    }

    protected void checkCheckbox(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        if (!findElementByXpath(appiumDriver, locator, value).getAttribute("checked").equals("true")) {
            clickToElement(appiumDriver, locator, value);
        }
    }

    public void setAttribute(AppiumDriver<MobileElement> appiumDriver, String locator, String attName, String attValue, String... value) {
        WebElement element = findElementByXpath(appiumDriver, locator, value);
        JavascriptExecutor js = appiumDriver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attName, attValue);
    }

    protected void unCheckCheckbox(AppiumDriver<MobileElement> appiumDriver, String locator) {
        if (findElementByXpath(appiumDriver, locator).getAttribute("checked").equals("true")) {
            clickToElement(appiumDriver, locator);
        }
    }

    protected void checkAllCheckbox(List<MobileElement> listElement) {
        for (MobileElement e : listElement) {
            if (!e.getAttribute("checked").equals("true")) {
                e.click();
            }
        }
    }

    protected void unCheckAllCheckbox(List<MobileElement> listElement) {
        for (MobileElement e : listElement) {
            if (e.getAttribute("checked").equals("true")) {
                e.click();
            }
        }
    }

    protected void senkeysToElement(AppiumDriver<MobileElement> appiumDriver, String locator, String value) {
        waitForVisible(appiumDriver, locator);
        MobileElement element = findElementByXpath(appiumDriver, locator);
        element.clear();
        element.sendKeys(value);
    }

    protected void clearTextElement(AppiumDriver<MobileElement> appiumDriver, String locator) {
        waitForVisible(appiumDriver, locator);
        MobileElement element = findElementByXpath(appiumDriver, locator);
        element.click();
        element.clear();
    }

    protected void tapThenSenkeysToElement(AppiumDriver<MobileElement> appiumDriver, String locator, String value) {
        waitForVisible(appiumDriver, locator);
        MobileElement element = findElementByXpath(appiumDriver, locator);
        waitForClickable(appiumDriver, locator);
        element.click();
        sleepInSecond(1);
        element.clear();
        element.sendKeys(value);
        appiumDriver.hideKeyboard();
    }

    protected void tapThenSenkeysToElement(AppiumDriver<MobileElement> appiumDriver, String locator, String param, String value) {
        waitForClickable(appiumDriver, locator, param);
        MobileElement element = findElementByXpath(appiumDriver, locator, param);
        element.click();
        sleepInSecond(1);
        element.clear();
        element.sendKeys(value);
        appiumDriver.hideKeyboard();
    }

    protected void hideKeyboard(AppiumDriver<MobileElement> appiumDriver) {
        appiumDriver.hideKeyboard();
    }

    protected String getText(AppiumDriver<MobileElement> appiumDriver, String locator) {
        return findElementByXpath(appiumDriver, locator).getText();
    }

    protected String getAttribute(AppiumDriver<MobileElement> appiumDriver, String locator, String nameAtribute) {
        return findElementByXpath(appiumDriver, locator).getAttribute(nameAtribute);
    }

    protected String getAttribute(AppiumDriver<MobileElement> appiumDriver, String locator, String nameAtribute, String... value) {
        return findElementByXpath(appiumDriver, locator, value).getAttribute(nameAtribute);
    }

    protected int convertMoneyTextToInt(String money) {
        return Integer.parseInt(money.replace(",", ""));
    }

    protected String convertMoneyIntToString(int money) {
        return String.format("%,d", money);
    }

    public String getContentdescAtribute(AppiumDriver<MobileElement> appiumDriver, String locator) {
        return getAttribute(appiumDriver, locator, "content-desc");
    }

    public String getContentdescAtribute(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        return getAttribute(appiumDriver, locator, "content-desc", value);
    }

    public String getTextAtribute(AppiumDriver<MobileElement> appiumDriver, String locator) {
        return getAttribute(appiumDriver, locator, "text");
    }

    public String getTextAtribute(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        return getAttribute(appiumDriver, locator, "text", value);
    }

    protected boolean isDisplayed(AppiumDriver<MobileElement> appiumDriver, String locator) {
        try {
            return findElementByXpath(appiumDriver, locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isDisplayed(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        return findElementByXpath(appiumDriver, locator, value).isDisplayed();
    }

    protected boolean isNotDisplayed(AppiumDriver<MobileElement> appiumDriver, String locator) {
        try {
            return findElementsByXpath(appiumDriver, locator).isEmpty();
        } catch (Exception e) {
            return true;
        }
    }

    protected boolean isNotDisplayed(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        try {
            return findElementsByXpath(appiumDriver, locator, value).isEmpty();
        } catch (Exception e) {
            return true;
        }
    }

    protected void longPress(AppiumDriver<MobileElement> appiumDriver) {
        Dimension size = appiumDriver.manage().window().getSize();
        int starty = (int) (size.height * 0.5);
        int startx = (int) (size.width * 0.5);
        new TouchAction(appiumDriver).
                longPress(PointOption.point(startx, starty)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .release().perform();
    }

    protected void swipe(AppiumDriver<MobileElement> appiumDriver, int startx, int starty, int endx, int endy) {
        new TouchAction(appiumDriver).longPress(PointOption.point(startx, starty))
                .moveTo(PointOption.point(endx, endy))
                .release().perform();
    }

    protected void swipeMobileUp(AppiumDriver<MobileElement> appiumDriver) {
        Dimension size = appiumDriver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.1);
        int starx = size.width / 2;
        swipe(appiumDriver, starx, starty, starx, endy);
    }

    protected void swipeMobileDown(AppiumDriver<MobileElement> appiumDriver) {
        Dimension size = appiumDriver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.3);
        int starx = size.width / 2;
        swipe(appiumDriver, starx, endy, starx, starty);
    }

    protected void scrollMenu(AppiumDriver<MobileElement> appiumDriver, WebElement element) {
        Dimension size = element.getSize();
        int starty = (int) (element.getLocation().getY() + Math.round(size.getHeight() * 0.9));
        int endy = (int) (element.getLocation().getY() + Math.round(size.getHeight() * 0.1));
        int starx = element.getLocation().getX() + (size.getWidth() / 2);
        swipe(appiumDriver, starx, starty, starx, endy);
    }

    protected void swipeItemRightToLeft(AppiumDriver<MobileElement> appiumDriver, String locator) {
        WebElement element = findElementByXpath(appiumDriver, locator);
        Dimension size = element.getSize();
        int startX = (int) (element.getLocation().getX() + Math.round(size.getWidth() * 0.7));
        int endX = (int) (element.getLocation().getX() + Math.round(size.getWidth() * 0.1));
        int startY = element.getLocation().getY() + size.getHeight() / 2;
        swipe(appiumDriver, startX, startY, endX, startY);
    }

    protected void swipeItemUp(AppiumDriver<MobileElement> appiumDriver, String locator) {
        WebElement element = findElementByXpath(appiumDriver, locator);
        Dimension size = element.getSize();
        int startX = (int) (element.getLocation().getX() + Math.round(size.getWidth() * 0.5));
        int endY = (int) (element.getLocation().getX() + Math.round(size.getWidth() * 0.1));
        int startY = element.getLocation().getY() + size.getHeight() / 2;
        swipe(appiumDriver, startX, startY, startX, endY);
    }

    protected void swipeItemDown(AppiumDriver<MobileElement> appiumDriver, String locator) {
        WebElement element = findElementByXpath(appiumDriver, locator);
        Dimension size = element.getSize();
        int startX = (int) (element.getLocation().getX() + Math.round(size.getWidth() * 0.5));
        int endY = (int) (element.getLocation().getY() + Math.round(size.getWidth() * 0.1));
        int startY = element.getLocation().getY() + size.getHeight() / 2;
        swipe(appiumDriver, startX, endY, startX, startY);
    }

    protected void swipeItemRightToLeft(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        WebElement element = findElementByXpath(appiumDriver, locator, value);
        Dimension size = element.getSize();
        int startX = (int) (element.getLocation().getX() + Math.round(size.getWidth() * 0.7));
        int endX = (int) (element.getLocation().getX() + Math.round(size.getWidth() * 0.1));
        int startY = element.getLocation().getY() + size.getHeight() / 2;
        swipe(appiumDriver, startX, startY, endX, startY);
    }

    protected void scrollToElement(AppiumDriver<MobileElement> appiumDriver, String locator) {
        WebElement element = null;
        boolean check = false;
        do {
            try {
                element = appiumDriver.findElement(By.xpath(locator));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (element == null) {
                swipeMobileUp(appiumDriver);
            } else {
                check = true;
            }

        } while (!check);
    }

    protected void scrollToElement(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        setImplicitlyWait(appiumDriver, GlobalVariables.SHORT_TIME_OUT);
        WebElement element = null;
        boolean check = false;
        do {
            try {
                element = findElementByXpath(appiumDriver, locator, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (element == null) {
                swipeMobileUp(appiumDriver);
            } else {
                check = true;
            }
        } while (!check);
        setImplicitlyWait(appiumDriver, GlobalVariables.TIME_OUT);
    }

    protected void scrollMobileUpToElement(AppiumDriver<MobileElement> appiumDriver, String locator, String... value) {
        setImplicitlyWait(appiumDriver, GlobalVariables.SHORT_TIME_OUT);
        WebElement element = null;
        boolean check = false;
        do {
            try {
                element = findElementByXpath(appiumDriver, locator, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (element == null) {
                swipeMobileUp(appiumDriver);
            } else {
                check = true;
            }
        } while (!check);
        setImplicitlyWait(appiumDriver, GlobalVariables.TIME_OUT);
    }

    protected void scrollMobileUpToElement(AppiumDriver<MobileElement> appiumDriver, String locator) {
        WebElement element = null;
        boolean check = false;
        do {
            try {
                element = appiumDriver.findElement(By.xpath(locator));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (element == null) {
                swipeMobileUp(appiumDriver);
            } else {
                check = true;
            }
        } while (!check);
    }

    protected void scrollUpToElement(AppiumDriver<MobileElement> appiumDriver, String locatorItem, String locator) {
        WebElement element = null;
        boolean check = false;
        do {
            try {
                element = appiumDriver.findElement(By.xpath(locator));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (element == null) {
                swipeItemUp(appiumDriver, locatorItem);
            } else {
                check = true;
            }
        } while (!check);
    }

    protected void tapToElementByPosition(AppiumDriver appiumDriver, String location) {
        MobileElement element = findElementByXpath(appiumDriver, location);
        int startX = element.getLocation().getX();
        int startY = element.getLocation().getY();
        int x = startX + (element.getSize().getWidth() / 2);
        int y = startY + (element.getSize().getHeight() / 2);
        new TouchAction(appiumDriver)
                .press(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(ofMillis(100)))
                .release().perform();
    }
    protected void tapToPosition(AppiumDriver appiumDriver) {
        Dimension size = appiumDriver.manage().window().getSize();
        int x = (int) (size.height * 0.1);
        int y = size.width / 2;
        new TouchAction(appiumDriver)
                .press(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(ofMillis(100)))
                .release().perform();
    }

    protected String generateNameCustomer() {
        Faker faker = new Faker();
        return (faker.name().fullName() + faker.name().firstName()).replace("'", "");
    }

    protected String generateProductName() {
        Faker faker = new Faker();
        return faker.commerce().productName().replace("'", "");
    }

    protected String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    protected String generatePhoneNumber() {
        Faker faker = new Faker();
        return faker.phoneNumber().subscriberNumber(10);
    }

    protected String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Calendar c = Calendar.getInstance();
        return sdf.format(c.getTime()) + "+07:00";
    }

    protected Date covertStringToDate(String format, String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }
}
