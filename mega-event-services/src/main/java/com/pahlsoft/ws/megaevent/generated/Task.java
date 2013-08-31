//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.31 at 07:49:26 PM EDT 
//


package com.pahlsoft.ws.megaevent.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for task complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="task">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskStatus" type="{http://megaevent.ws.pahlsoft.com}taskStatus"/>
 *         &lt;element name="taskResult" type="{http://megaevent.ws.pahlsoft.com}taskResult"/>
 *         &lt;element name="eventId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dependencyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ownerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="activatorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="validatorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="role" type="{http://megaevent.ws.pahlsoft.com}role"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changeControlNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changeControlStatus" type="{http://megaevent.ws.pahlsoft.com}changeStatus"/>
 *         &lt;element name="assetName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "task", propOrder = {
    "id",
    "name",
    "taskStatus",
    "taskResult",
    "eventId",
    "dependencyId",
    "ownerId",
    "activatorId",
    "validatorId",
    "role",
    "description",
    "changeControlNumber",
    "changeControlStatus",
    "assetName"
})
public class Task {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected TaskStatus taskStatus;
    @XmlElement(required = true)
    protected TaskResult taskResult;
    protected int eventId;
    protected int dependencyId;
    protected int ownerId;
    protected int activatorId;
    protected int validatorId;
    @XmlElement(required = true)
    protected Role role;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String changeControlNumber;
    @XmlElement(required = true)
    protected ChangeStatus changeControlStatus;
    @XmlElement(required = true)
    protected String assetName;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the taskStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TaskStatus }
     *     
     */
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    /**
     * Sets the value of the taskStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskStatus }
     *     
     */
    public void setTaskStatus(TaskStatus value) {
        this.taskStatus = value;
    }

    /**
     * Gets the value of the taskResult property.
     * 
     * @return
     *     possible object is
     *     {@link TaskResult }
     *     
     */
    public TaskResult getTaskResult() {
        return taskResult;
    }

    /**
     * Sets the value of the taskResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskResult }
     *     
     */
    public void setTaskResult(TaskResult value) {
        this.taskResult = value;
    }

    /**
     * Gets the value of the eventId property.
     * 
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * Sets the value of the eventId property.
     * 
     */
    public void setEventId(int value) {
        this.eventId = value;
    }

    /**
     * Gets the value of the dependencyId property.
     * 
     */
    public int getDependencyId() {
        return dependencyId;
    }

    /**
     * Sets the value of the dependencyId property.
     * 
     */
    public void setDependencyId(int value) {
        this.dependencyId = value;
    }

    /**
     * Gets the value of the ownerId property.
     * 
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the value of the ownerId property.
     * 
     */
    public void setOwnerId(int value) {
        this.ownerId = value;
    }

    /**
     * Gets the value of the activatorId property.
     * 
     */
    public int getActivatorId() {
        return activatorId;
    }

    /**
     * Sets the value of the activatorId property.
     * 
     */
    public void setActivatorId(int value) {
        this.activatorId = value;
    }

    /**
     * Gets the value of the validatorId property.
     * 
     */
    public int getValidatorId() {
        return validatorId;
    }

    /**
     * Sets the value of the validatorId property.
     * 
     */
    public void setValidatorId(int value) {
        this.validatorId = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link Role }
     *     
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link Role }
     *     
     */
    public void setRole(Role value) {
        this.role = value;
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

    /**
     * Gets the value of the changeControlNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeControlNumber() {
        return changeControlNumber;
    }

    /**
     * Sets the value of the changeControlNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeControlNumber(String value) {
        this.changeControlNumber = value;
    }

    /**
     * Gets the value of the changeControlStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeStatus }
     *     
     */
    public ChangeStatus getChangeControlStatus() {
        return changeControlStatus;
    }

    /**
     * Sets the value of the changeControlStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeStatus }
     *     
     */
    public void setChangeControlStatus(ChangeStatus value) {
        this.changeControlStatus = value;
    }

    /**
     * Gets the value of the assetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssetName() {
        return assetName;
    }

    /**
     * Sets the value of the assetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssetName(String value) {
        this.assetName = value;
    }

}
