package com.example.sima.domain.log;

import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.domain.SimaCustomer;
import com.example.sima.domain.SimaRequest;
import com.example.sima.domain.SimaResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "t_SimaCustomerLog")
public class SimaCustomerLog extends EntityGeneralLog {

    private SimaCustomer simaCustomer;

    private SimaRequest simaRequest;

    private SimaResponse simaResponse;

    private ConstantCategoryElement operation;

    private String preValue;

    private String nextValue;

    private ConstantCategoryElement changedField;

    @ManyToOne
    @JoinColumn(name = "c_simaCustomer")
    public SimaCustomer getSimaCustomer() {
        return simaCustomer;
    }

    public void setSimaCustomer(SimaCustomer simaCustomer) {
        this.simaCustomer = simaCustomer;
    }

    @ManyToOne
    @JoinColumn(name = "c_simaRequest")
    public SimaRequest getSimaRequest() {
        return simaRequest;
    }

    public void setSimaRequest(SimaRequest simaRequest) {
        this.simaRequest = simaRequest;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "c_operation")
    public ConstantCategoryElement getOperation() {
        return operation;
    }

    public void setOperation(ConstantCategoryElement operation) {
        this.operation = operation;
    }

    @ManyToOne
    @JoinColumn(name = "c_simaResponse")
    public SimaResponse getSimaResponse() {
        return simaResponse;
    }

    public void setSimaResponse(SimaResponse simaResponse) {
        this.simaResponse = simaResponse;
    }

    @Column(name = "c_preValue")
    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }

    @Column(name = "c_nextValue")
    public String getNextValue() {
        return nextValue;
    }

    public void setNextValue(String nextValue) {
        this.nextValue = nextValue;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "c_changedField")
    public ConstantCategoryElement getChangedField() {
        return changedField;
    }

    public void setChangedField(ConstantCategoryElement changedField) {
        this.changedField = changedField;
    }
}
