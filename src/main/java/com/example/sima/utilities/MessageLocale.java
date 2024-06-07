package com.example.sima.utilities;


import java.util.Locale;

final class MessageLocale {

    private static ThreadLocal<Locale> localeStorage = new ThreadLocal<>();

    private MessageLocale(){}

    public static void set(Locale locale) {
        localeStorage.set(locale);
    }

    public static void remove() {
        localeStorage.remove();
    }

    public static Locale get() {
        return localeStorage.get();
    }

}
