package com.kma.todoist.helper;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class LoadDevicesConfig {
    public static final LoadDevicesConfig LOAD_DEVICES_CONFIG = getInstance();

    private final Config conf;

    private LoadDevicesConfig() {
        conf = ConfigFactory.load("devices.conf");
    }

    public static LoadDevicesConfig getInstance() {
        return new LoadDevicesConfig();
    }

    public String getProperty(String key) {
        // Default environment is defined in pom.xml
        String chosenEnv = System.getProperty("device");
        Config env = conf.getConfig(chosenEnv);
        return env.getString(key);
    }
}
