/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Gilbert
 */
public class ViewCount {
    private String page_id;
    private String page_views;

    public ViewCount() {
    }

    public ViewCount(String page_id, String page_views) {
        this.page_id = page_id;
        this.page_views = page_views;
    }

    public String getPage_id() {
        return page_id;
    }

    public void setPage_id(String page_id) {
        this.page_id = page_id;
    }

    public String getPage_views() {
        return page_views;
    }

    public void setPage_views(String page_views) {
        this.page_views = page_views;
    }
    
    
}
