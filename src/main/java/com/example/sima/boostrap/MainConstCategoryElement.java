package com.example.sima.boostrap;

public class MainConstCategoryElement {
    private final String code;
    private final String value;
    private final String categoryName;

    public MainConstCategoryElement(String code, String value, String categoryName) {
        this.code = code;
        this.value = value;
        this.categoryName = categoryName;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
