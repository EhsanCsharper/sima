package com.example.sima.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "t_SimaResponseError")
public class SimaResponseError extends BaseEntity {

    private String message;

    private String code;

    @Column(name = "c_message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "c_code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
