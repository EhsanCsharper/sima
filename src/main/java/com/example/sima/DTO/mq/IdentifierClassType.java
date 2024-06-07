
package com.example.sima.DTO.mq;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentifierClassType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IdentifierClassType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="NATIONAL_CODE"/>
 *     &lt;enumeration value="FIDA"/>
 *     &lt;enumeration value="NATIONAL_ID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IdentifierClassType", namespace = "http://modernisc.com/api/csd")
@XmlEnum
public enum IdentifierClassType {

    NATIONAL_CODE,
    FIDA,
    NATIONAL_ID;

    public String value() {
        return name();
    }

    public static IdentifierClassType fromValue(String v) {
        return valueOf(v);
    }

}
