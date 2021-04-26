/*
 * Information.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */

package entity;
/**
 * Information <br>
 * 
 * <pre>
 * Store Information
 * .Information()
 * .getShortDescription()
 * .setShortDescription()
 * .getAddress()
 * .setAddress()
 * .getTel()
 * .setTel()
 * .getEmail()
 * .setEmail()
 * .getOpeningHours()
 * .setOpeningHours()
 * .getSignature()
 * .setSignature()
 * </pre>
 * 
 * @author thinh
 */


public class Information {
    /** Store shortDescription, address, tel, email, openingHours, signature */
    private String shortDescription, address, tel, email, openingHours, signature;

    /**
     * Constructor.<br>
     */
    public Information() {
    }

    /**
     * Constructor.<br>
     * 
     * @param shortDescription
     * @param address
     * @param tel
     * @param email
     * @param openingHours
     * @param signature 
     */
    public Information(String shortDescription, String address, String tel, String email, String openingHours, String signature) {
        this.shortDescription = shortDescription;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.openingHours = openingHours;
        this.signature = signature;
    }

    /**
     * Get shortDescription.<br>
     * 
     * @return shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Set ShortDescription.<br>
     * 
     * @param shortDescription 
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Get address.<br>
     * 
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address.<br>
     * 
     * @param address 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get tel.<br>
     * 
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Set tel.<br>
     * 
     * @param tel 
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Get email.<br>
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email.<br>
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get openingHours.<br>
     * 
     * @return openingHours
     */
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * Set openingHours.<br>
     * 
     * @param openingHours 
     */
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    /**
     * Get signature.<br>
     * 
     * @return signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Set signature.<br>
     * 
     * @param signature 
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }
    
}
