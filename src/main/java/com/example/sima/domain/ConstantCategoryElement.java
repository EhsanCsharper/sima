package com.example.sima.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="t_ConstantCategoryElement")
public class ConstantCategoryElement extends CategoryElement {

    private String code;

    public ConstantCategoryElement() {
    }
    
    @Column(name="c_code", unique=true)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}


