package com.example.sima.domain;


import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "t_SimaCustomer")
public class SimaCustomer extends BaseEntity {

    private Long customer;
    private String identifier;
    private ConstantCategoryElement identifierType;
    private ConstantCategoryElement status;
    private SimaResponse lastSimaResponse;
    private SimaRequest lastSimaRequest;

    @Column(name = "c_customer")
    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    @Column(name = "c_identifier")
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_identifierType")
    public ConstantCategoryElement getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(ConstantCategoryElement identifierType) {
        this.identifierType = identifierType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_status")
    public ConstantCategoryElement getStatus() {
        return status;
    }

    public void setStatus(ConstantCategoryElement status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "c_lastSimaResponse")
    public SimaResponse getLastSimaResponse() {
        return lastSimaResponse;
    }

    public void setLastSimaResponse(SimaResponse lastSimaResponse) {
        this.lastSimaResponse = lastSimaResponse;
    }

    @ManyToOne
    @JoinColumn(name = "c_lastSimaRequest")
    public SimaRequest getLastSimaRequest() {
        return lastSimaRequest;
    }

    public void setLastSimaRequest(SimaRequest lastSimaRequest) {
        this.lastSimaRequest = lastSimaRequest;
    }
}
