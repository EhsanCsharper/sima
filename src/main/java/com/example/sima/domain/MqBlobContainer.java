package com.example.sima.domain;

import java.sql.Blob;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="t_MqBlobContainer")
public class MqBlobContainer extends com.example.sima.domain.Entity {
    private Blob blob;

    private String creationDate;

    public MqBlobContainer() {
    }

    @Column(name = "c_blob", length = 2000000)
    public Blob getBlob() {
        return this.blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    @Column(name="c_creationDate")
    public String getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

}


