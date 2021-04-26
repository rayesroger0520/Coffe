/*
 * Introduction.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */

package entity;

/**
 * Introduction <br>
 * 
 * <pre>
 * Store Introduction
 * .Introduction()
 * .getTitle()
 * .setTitle()
 * .getPicture()
 * .setPicture()
 * .getShortDescription()
 * .setShortDescription()
 * .getDetailDescription()
 * .setDetailDescription()
 * </pre>
 * 
 * @author thinh
 */

public class Introduction {
    /** Store the title, picture, shortDescription, detailDescription */
    private String title, picture, shortDescription, detailDescription;

    /**
     * Constructor.<br>
     */
    public Introduction() {
    }

    /**
     * Constructor.<br>
     * 
     * @param title
     * @param picture
     * @param shortDescription
     * @param detailDescription 
     */
    public Introduction(String title, String picture, String shortDescription, String detailDescription) {
        this.title = title;
        this.picture = picture;
        this.shortDescription = shortDescription;
        this.detailDescription = detailDescription;
    }

    /**
     * Get title.<br>
     * 
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title.<br>
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get picture.<br>
     * 
     * @return picture
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
     * @return shortDescription
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
     * @return detailDescription
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
    
}
