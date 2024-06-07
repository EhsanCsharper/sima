package com.example.sima.utilities;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Messages {

    public static void setLocale(Locale locale) {
        MessageLocale.set(locale);
    }

    private static final Log LOGGER = LogFactory.getLog(Messages.class);

    private Messages(){}

    public static String get(MessageCategory category, String key, Locale locale, Object ...args) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(category.getPath(), locale);
            String value = bundle.getString(key);
            return MessageFormat.format(value, args);
        } catch (MissingResourceException e) {
            LOGGER.warn("Can not find corresponded value for key: " + key, e);
            return key;
        }
    }

    public static void unsetLocale() {
        MessageLocale.remove();
    }

    public static String getSimaMessage(String key, Object... args) {
        return get(MessageCategory.SIMA, key, resolveLocal(), args);
    }

    private static  Locale resolveLocal() {
        Locale locale = MessageLocale.get();
        return locale != null ? locale : Locale.getDefault();
    }

}