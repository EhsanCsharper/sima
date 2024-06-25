package com.example.sima.api.v1.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
public class GeneralDTO implements Serializable {
    protected static final Logger logger = LoggerFactory.getLogger(GeneralDTO.class);
    private String rsCode = "-1";
    // private String transactionCode = "-1";
    private String errorMessage = "";
    private Long responseTimeMillis = Long.valueOf("0");
    private String requestId = "";
    private String requestDateTime;
    private String responseDateTime;
    private String resultUrl;
    private String correlationId;

    public GeneralDTO() {
    }

    public GeneralDTO(String rsCode, String errorMessage) {
        this.rsCode = rsCode;
        this.errorMessage = errorMessage;
    }

    public GeneralDTO(String rsCode, String errorMessage, String resultUrl) {
        this.rsCode = rsCode;
        this.errorMessage = errorMessage;
        this.resultUrl = resultUrl;
    }

    public GeneralDTO(String rsCode, String errorMessage, String resultUrl, String correlationID) {
        this.rsCode = rsCode;
        this.errorMessage = errorMessage;
        this.resultUrl = resultUrl;
        this.correlationId = correlationID;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(String responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getResponseTimeMillis() {
        return responseTimeMillis;
    }

    public void setResponseTimeMillis(Long responseTimeMillis) {
        this.responseTimeMillis = responseTimeMillis;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRsCode() {
        return rsCode;
    }

    public void setRsCode(String rsCode) {
        this.rsCode = rsCode;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
