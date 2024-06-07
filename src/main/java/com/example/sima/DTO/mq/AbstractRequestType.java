
package com.example.sima.DTO.mq;

import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3c.dom.Element;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for AbstractRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Principal" type="{http://modernisc.com/api/csd}PrincipalType"/>
 *         &lt;element name="MessageId" type="{http://modernisc.com/api/csd}GUID"/>
 *         &lt;element name="Test" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Version" type="{http://modernisc.com/api/csd}SupportedVersions"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractRequestType", namespace = "http://modernisc.com/api/csd", propOrder = {
    "principal",
    "messageId",
    "test",
    "version",
    "any"
})
@XmlSeeAlso({
    IsPartyBlockedRequestType.class
})
public abstract class AbstractRequestType {

    @XmlElement(name = "Principal", required = true)
    protected PrincipalType principal;
    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "Test", defaultValue = "true")
    protected boolean test;
    @XmlElement(name = "Version", required = true, defaultValue = "2.0")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String version;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    //"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>
    // <PingRequestType xmlns=\"http://modernisc.com/api/csd\" xmlns:xsi=\"http://www.w3.org/2001/xmlSchema-instance\" xsi:schemaLocation=\"http://modernisc.com/api/csd file:/F/:/Project/CSD/MQ/ISC-SSvc-2.0.xsd\">\n    <Principal>\n        <Username>502229</Username>\n        <Password>Nn123456789@</Password>\n        <BranchCode>1</BranchCode>\n    </Principal>\n    <Test>true</Test>\n</PingRequestType>\n"


    /**
     * Gets the value of the principal property.
     * 
     * @return
     *     possible object is
     *     {@link PrincipalType }
     *     
     */
    public PrincipalType getPrincipal() {
        return principal;
    }

    /**
     * Sets the value of the principal property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrincipalType }
     *     
     */
    public void setPrincipal(PrincipalType value) {
        this.principal = value;
    }

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the test property.
     * 
     */
    public boolean isTest() {
        return test;
    }

    /**
     * Sets the value of the test property.
     * 
     */
    public void setTest(boolean value) {
        this.test = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
