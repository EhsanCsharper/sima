package com.example.sima.DTO.management;

import java.io.Serializable;

public class SimaConstantCategoryElementDTO implements Serializable {
    private Long id;
    private String value;
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
