
package com.example.sima.DTO.mq;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for IsPartyBlockedRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IsPartyBlockedRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://modernisc.com/api/csd}AbstractRequestType">
 *       &lt;sequence>
 *         &lt;element name="Identifier" type="{http://modernisc.com/api/csd}IdentifierType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsPartyBlockedRequestType", propOrder = {
    "identifier"
})
@XmlRootElement(name = "IsPartyBlockedRequest")
public class IsPartyBlockedRequestType
    extends AbstractRequestType
{

    @XmlElement(name = "Identifier", required = true)
    protected IdentifierType identifier;

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifierType }
     *     
     */
    public IdentifierType getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierType }
     *     
     */
    public void setIdentifier(IdentifierType value) {
        this.identifier = value;
    }

}
