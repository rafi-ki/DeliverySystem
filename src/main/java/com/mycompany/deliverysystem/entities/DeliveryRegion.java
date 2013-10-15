/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.entities;

/**
 *
 * @author rafael, dominik
 */
public class DeliveryRegion {
    private int id;
    private int external_id;
    private double longitude;
    private double latitude;
    
    public DeliveryRegion(int external_id, double longitude, double latitude)
    {
        this.external_id = external_id;
        this.longitude = longitude;
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
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
