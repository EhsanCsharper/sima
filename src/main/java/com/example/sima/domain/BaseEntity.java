package com.example.sima.domain;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity extends Entity {

    private String creationDateTime;

    private String lastModifiedDateTime;

    @Column(name = "c_creationDateTime")
    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    @Column(name = "c_lastModifiedDateTime")
    public String getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(String lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

}

