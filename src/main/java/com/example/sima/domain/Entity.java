package com.example.sima.domain;


import jakarta.persistence.*;

@MappedSuperclass
public abstract class Entity implements Cloneable, java.io.Serializable {

    private long id;
    private int version;
	private Boolean active;
	private String manualId;
	private Boolean enable;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable = false)
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }



    @Version
    @Column(name="c_version", nullable=false)
    public int getVersion() {
        return this.version;
    }
    public void setVersion(int version) {
        this.version = version;
    }



    @Column(name="c_active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Column(name="c_manualId")
    public String getManualId() {
        return manualId;
    }

    public void setManualId(String manualId) {
        this.manualId = manualId;
    }

    @Column(name="c_enable")
    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /*@Transient
    public Object clone() throws CloneNotSupportedException {
        return DeepCopy.copy(this);
    }*/

    /**
     *
     * @return A meaningful string representation of current object.
     */
    @Transient
    public String getStringValue(){
        return "";
    }

    /**
     *
     * @return A string that is combination of fields which distinguishes current object and others.
     */
    @Transient
    public String getMetadata(){
        return "";
    }

}

