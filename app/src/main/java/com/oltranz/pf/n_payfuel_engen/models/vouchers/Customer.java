/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oltranz.pf.n_payfuel_engen.models.vouchers;

/**
 * @author manzi
 */
public class Customer {
    private Integer id;
    private String name;
    private String contactEmail;
    private String contactTelephoneNumber;
    private String contactPersonName;
    private Boolean isActive;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * @param contactEmail the contactEmail to set
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * @return the contactTelephoneNumber
     */
    public String getContactTelephoneNumber() {
        return contactTelephoneNumber;
    }

    /**
     * @param contactTelephoneNumber the contactTelephoneNumber to set
     */
    public void setContactTelephoneNumber(String contactTelephoneNumber) {
        this.contactTelephoneNumber = contactTelephoneNumber;
    }

    /**
     * @return the contactPersonName
     */
    public String getContactPersonName() {
        return contactPersonName;
    }

    /**
     * @param contactPersonName the contactPersonName to set
     */
    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
