package com.kma.todoist.factorydevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.kma.todoist.helper.LoadDevicesConfig.LOAD_DEVICES_CONFIG;

public interface DeviceFactory {
    //    public String user = LOAD_DEVICES_CONFIG.getProperty("username");
    public String hub = LOAD_DEVICES_CONFIG.getProperty("hub");
//
//    public abstract AppiumDriver<MobileElement> getMobileDriver(String udid, String hub);
//
//    public abstract DesiredCapabilities getDesiredCapabilities(String udid);
public abstract AppiumDriver<MobileElement> getMobileDriver();

    public abstract DesiredCapabilities getDesiredCapabilities();
}
