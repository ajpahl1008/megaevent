//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.18 at 09:59:09 PM EST 
//


package com.pahlsoft.ws.megaevent.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for role.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="role">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SYSADMIN"/>
 *     &lt;enumeration value="DBA"/>
 *     &lt;enumeration value="NETWORK_ENGINEER"/>
 *     &lt;enumeration value="SAN_ENGINEER"/>
 *     &lt;enumeration value="DEVELOPER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "role")
@XmlEnum
public enum Role {

    SYSADMIN,
    DBA,
    NETWORK_ENGINEER,
    SAN_ENGINEER,
    DEVELOPER;

    public String value() {
        return name();
    }

    public static Role fromValue(String v) {
        return valueOf(v);
    }

}