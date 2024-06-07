package com.example.sima.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_SimaResponse")
public class SimaResponse extends BaseEntity {

    private Boolean isProcessed;
    private SimaRequest simaRequest;
    private ConstantCategoryElement ackStatus;
    private List<SimaResponseError> simaResponseErrors;
    private JMSRequest jmsRequest;
    private String machineIP;
    private String userCode;
    private String branchCode;
    private String userFirstName;
    private String userLastName;
    private String checkSUM;

    @Column(name = "c_isProcessed")
    public Boolean getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(Boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    @OneToOne
    @JoinColumn(name = "c_simaRequest")
    public SimaRequest getSimaRequest() {
        return simaRequest;
    }

    public void setSimaRequest(SimaRequest simaRequest) {
        this.simaRequest = simaRequest;
    }

    @ManyToOne
    @JoinColumn(name = "c_ackStatus")
    public ConstantCategoryElement getAckStatus() {
        return ackStatus;
    }

    public void setAckStatus(ConstantCategoryElement ackStatus) {
        this.ackStatus = ackStatus;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_simaResponse")
    public List<SimaResponseError> getSimaResponseErrors() {
        return simaResponseErrors;
    }

    public void setSimaResponseErrors(List<SimaResponseError> simaResponseErrors) {
        this.simaResponseErrors = simaResponseErrors;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_jmsRequest")
    public JMSRequest getJmsRequest() {
        return jmsRequest;
    }

    public void setJmsRequest(JMSRequest jmsRequest) {
        this.jmsRequest = jmsRequest;
    }


    @Column(name = "c_machineIP")
    public String getMachineIP() {
        return machineIP;
    }

    public void setMachineIP(String machineIP) {
        this.machineIP = machineIP;
    }

    @Column(name = "c_userCode")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Column(name = "c_branchCode")
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Column(name = "c_userFirstName")
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    @Column(name = "c_userLastName")
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }


    @Column(name = "c_checkSUM")
    public String getCheckSUM() {
        return checkSUM;
    }

    public void setCheckSUM(String checkSUM) {
        this.checkSUM = checkSUM;
    }
}
