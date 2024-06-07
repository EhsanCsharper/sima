package com.example.sima.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;
import jakarta.persistence.Entity;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = jakarta.persistence.InheritanceType.JOINED)
@Table(name = "t_CategoryElement")
public class CategoryElement extends com.example.sima.domain.Entity {

    private String value;
    private Category category;

    public CategoryElement() {
    }

    @Column(name = "c_value")
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_category")
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Transient
    @Override
    public String getStringValue() {
        return value;
    }


}
