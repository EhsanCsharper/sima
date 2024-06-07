package com.example.sima.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="t_CategorizedField")
public class CategorizedField extends com.example.sima.domain.Entity {

    private String className;
    private String fieldName;
    private Category category;

    public CategorizedField() {
    }
    
    @Column(name="c_className")
    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    
    @Column(name="c_fieldName")
    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="c_category")
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}


