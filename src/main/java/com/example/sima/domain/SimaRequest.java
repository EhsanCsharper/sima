package com.example.sima.domain;


import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_SimaRequest")
public class SimaRequest extends BaseEntity {

    private ConstantCategoryElement serviceType;
    private ConstantCategoryElement status;
    private JMSRequest jmsRequest;
    private String sendDate;
    private SimaResponse simaResponse;
    private String machineIP;
    private String userCode;
    private String branchCode;
    private String userFirstName;
    private String userLastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_serviceType")
    public ConstantCategoryElement getServiceType() {
        return serviceType;
    }

    public void setServiceType(ConstantCategoryElement serviceType) {
        this.serviceType = serviceType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_status")
    public ConstantCategoryElement getStatus() {
        return status;
    }

    public void setStatus(ConstantCategoryElement status) {
        this.status = status;
    }

    @Column(name = "c_sendDate")
    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_jmsRequest")
    public JMSRequest getJmsRequest() {
        return jmsRequest;
    }

    public void setJmsRequest(JMSRequest jmsRequest) {
        this.jmsRequest = jmsRequest;
    }

    @OneToOne
    @JoinColumn(name = "c_simaResponse")
    public SimaResponse getSimaResponse() {
        return simaResponse;
    }

    public void setSimaResponse(SimaResponse simaResponse) {
        this.simaResponse = simaResponse;
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
}
