package com.example.sima.config.feature;

import com.example.sima.SharedCodes;
import com.example.sima.utilities.ResourceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class FeatureConfig {
    private static final Logger logger = LoggerFactory.getLogger(FeatureConfig.class);
    private static String activeBank;
    private static Properties properties = new Properties();
    private static Properties appProperties = new Properties();;


    static {
        setActiveBank();
        getAllProperties();
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }

    private static void getAllProperties() {
        properties.putAll(getDefaultProperties());
        properties.putAll(getCustomerProperties());
    }

    private static Properties getDefaultProperties() {
        try {
            Properties defaultProperties = new Properties();
            String resourcePath = getResourcePath(SharedCodes.EMPTY_STRING);
            defaultProperties.load(ResourceHelper.getResourceAsStream(resourcePath));
            return defaultProperties;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new Properties();
    }

    private static Properties getCustomerProperties() {
        try {
            Properties customerProperties = new Properties();
            String resourcePath = getResourcePath(activeBank);
            customerProperties.load(ResourceHelper.getResourceAsStream(resourcePath));
            return customerProperties;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new Properties();
    }

    private static void setActiveBank() {
        try {
            appProperties.load(ResourceHelper.getResourceAsStream("application.properties"));
            activeBank = appProperties.getProperty("active.bank");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("can not load file < application.properties >");
        }
    }

    private static String getResourcePath(String activeBank) {
        if (activeBank.equalsIgnoreCase("sepah")) {
            return "feature/sepah/simaFile.properties";
        }
        return "feature/default/simaFile.properties";
    }
}
