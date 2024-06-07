package com.example.sima.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="t_MqRequest")
public class MqRequest extends com.example.sima.domain.Entity {

    private String dateTime;
    private String key;
    private String sequenceCode;
    @Lob
    private String messageBody;
    private CategoryElement status;

    public MqRequest() {
    }
    
    @Column(name="c_dateTime")
    public String getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    
    @Column(name="c_key")
    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    
    @Column(name="c_sequenceCode")
    public String getSequenceCode() {
        return this.sequenceCode;
    }

    public void setSequenceCode(String sequenceCode) {
        this.sequenceCode = sequenceCode;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="c_status")
    public CategoryElement getStatus() {
        return this.status;
    }

    public void setStatus(CategoryElement status) {
        this.status = status;
    }

    @Column(name = "c_messageBody")
    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}


