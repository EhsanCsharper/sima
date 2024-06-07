
package com.example.sima.DTO.mq;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for IsPartyBlockedResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IsPartyBlockedResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://modernisc.com/api/csd}AbstractResponseType">
 *       &lt;sequence>
 *         &lt;element name="Blocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BlockerBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BlockerBranch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsPartyBlockedResponseType", namespace = "http://modernisc.com/api/csd", propOrder = {
    "blocked",
    "blockerBank",
    "blockerBranch",
    "description",
    "fromDate",
    "toDate"
})
public class IsPartyBlockedResponseType
    extends AbstractResponseType
{

    @XmlElement(name = "Blocked", namespace = "http://modernisc.com/api/csd")
    protected Boolean blocked;
    @XmlElement(name = "BlockerBank", namespace = "http://modernisc.com/api/csd")
    protected String blockerBank;
    @XmlElement(name = "BlockerBranch", namespace = "http://modernisc.com/api/csd")
    protected String blockerBranch;
    @XmlElement(name = "Description", namespace = "http://modernisc.com/api/csd")
    protected String description;

    /**
     * Gets the value of the blocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBlocked() {
        return blocked;
    }

    /**
     * Sets the value of the blocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBlocked(Boolean value) {
        this.blocked = value;
    }

    /**
     * Gets the value of the blockerBank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockerBank() {
        return blockerBank;
    }

    /**
     * Sets the value of the blockerBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockerBank(String value) {
        this.blockerBank = value;
    }

    /**
     * Gets the value of the blockerBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockerBranch() {
        return blockerBranch;
    }

    /**
     * Sets the value of the blockerBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockerBranch(String value) {
        this.blockerBranch = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    public Boolean getBlocked() {
        return blocked;
    }
}
