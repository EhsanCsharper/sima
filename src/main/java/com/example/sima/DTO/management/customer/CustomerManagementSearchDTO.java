package com.example.sima.DTO.management.customer;

import com.example.sima.DTO.management.PagingDTO;

public class CustomerManagementSearchDTO extends PagingDTO {

    private String identifier;
    private String identifierTypeCode;
    private String customerNumber;
    private String statusCode;

    public static String DEFAULT_ORDER_BY = "customer";

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifierTypeCode() {
        return identifierTypeCode;
    }

    public void setIdentifierTypeCode(String identifierTypeCode) {
        this.identifierTypeCode = identifierTypeCode;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
