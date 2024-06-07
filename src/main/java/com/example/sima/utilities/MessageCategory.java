package com.example.sima.utilities;


public enum MessageCategory {
    SIMA ("sima");

    final String path;

    MessageCategory(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

}
