/*
 * Cake.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package entity;

/**
 * Cake <br>
 * 
 * <pre>
 * Store Cake
 * .Cake()
 * .getId()
 * .setId()
 * .getName()
 * .setName()
 * .getPicture()
 * .setPicture()
 * .getShortDescription()
 * .setShortDescription()
 * .getDetailDescription()
 * .setDetailDescription()
 * .getPrice()
 * .setPrice()
 * </pre>
 * 
 * @author thinh
 */

public class Cake {
    
    /** Store the id */
    private int id;
    
    /** Store the name, picture, shortDescription, detailDescription */
    private String name, picture, shortDescription, detailDescription;
    
    /** Store the price */
    private String price;

    /**
     * Constructor.<br>
     */
    public Cake() {
    }
    
    /**
     * Constructor.<br>
     * 
     * @param id
     * @param name
     * @param picture
     * @param shortDescription
     * @param detailDescription 
     * @param price 
     */
    public Cake(int id, String name, String picture, String shortDescription, String detailDescription, String price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.shortDescription = shortDescription;
        this.detailDescription = detailDescription;
        this.price = price;
    }

    /**
     * Get id.<br>
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.<br>
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get name.<br>
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.<br>
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get picture.<br>
     * 
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Set picture.<br>
     * 
     * @param picture 
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Get shortDescription.<br>
     * 
     * @return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Set shortDescription.<br>
     * 
     * @param shortDescription 
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Get detailDescription.<br>
     * 
     * @return the detailDescription
     */
    public String getDetailDescription() {
        return detailDescription;
    }

    /**
     * Set detailDescription.<br>
     * 
     * @param detailDescription 
     */
    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    /**
     * Get price.<br>
     * 
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Set price.<br>
     * 
     * @param price 
     */
    public void setPrice(String price) {
        this.price = price;
    }

   
    
    
}
