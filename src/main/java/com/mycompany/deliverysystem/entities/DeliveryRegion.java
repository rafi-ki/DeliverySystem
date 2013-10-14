/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.entities;

/**
 *
 * @author rafael
 */
public class DeliveryRegion {
    private int id;
    private int external_id;
    private int longitued;
    private int latitude;
    
    public DeliveryRegion(int external_id, int longitude, int latitude)
    {
        this.external_id = external_id;
        this.longitued = longitude;
        this.latitude = latitude;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the external_id
     */
    public int getExternal_id() {
        return external_id;
    }

    /**
     * @param external_id the external_id to set
     */
    public void setExternal_id(int external_id) {
        this.external_id = external_id;
    }

    /**
     * @return the longitued
     */
    public int getLongitued() {
        return longitued;
    }

    /**
     * @param longitued the longitued to set
     */
    public void setLongitued(int longitued) {
        this.longitued = longitued;
    }

    /**
     * @return the latitude
     */
    public int getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
}
