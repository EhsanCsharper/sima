package com.example.sima.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.persistence.Entity;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="t_Category")
public class Category extends com.example.sima.domain.Entity{

    private String name;
    private Set<CategorizedField> categorizedFields;
    private List<CategoryElement> possibleValues;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Column(name="c_name", unique=true)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="c_category")
    public Set<CategorizedField> getCategorizedFields() {
        return this.categorizedFields;
    }

    public void setCategorizedFields(Set<CategorizedField> categorizedFields) {
        this.categorizedFields = categorizedFields;
    }

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="c_category")
    //@OrderColumn(name = "i_category")
    public List<CategoryElement> getPossibleValues() {
        return this.possibleValues;
    }

    public void setPossibleValues(List<CategoryElement> possibleValues) {
        this.possibleValues = possibleValues;
    }

}


