package com.example.sima.DTO.management.customer;

import com.example.sima.domain.ConstantCategoryElement;

public class CustomerDTO {
    private long id;
    private long customerNumber;
    private String identifier;
    private ConstantCategoryElement identifierType;
    private boolean real;
    private String name;
    private ConstantCategoryElement status;
    private String blockDescription;
    private String creationDateTime;
    private String lastModifiedDateTime;

    public CustomerDTO() {
    }

    public CustomerDTO(long id, long customerNumber, String identifier, ConstantCategoryElement identifierType, boolean real, String name, ConstantCategoryElement status, String blockDescription, String creationDateTime, String lastModifiedDateTime) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.identifier = identifier;
        this.identifierType = identifierType;
        this.real = real;
        this.name = name;
        this.status = status;
        this.blockDescription = blockDescription;
        this.creationDateTime = creationDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ConstantCategoryElement getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(ConstantCategoryElement identifierType) {
        this.identifierType = identifierType;
    }

    public boolean isReal() {
        return real;
    }

    public void setReal(boolean real) {
        this.real = real;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConstantCategoryElement getStatus() {
        return status;
    }

    public void setStatus(ConstantCategoryElement status) {
        this.status = status;
    }

    public String getBlockDescription() {
        return blockDescription;
    }

    public void setBlockDescription(String blockDescription) {
        this.blockDescription = blockDescription;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(String lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }
}
