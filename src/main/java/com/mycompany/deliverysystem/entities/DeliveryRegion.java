/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.entities;

import defines.GeoLocation;

/**
 *
 * @author rafael, dominik
 */
public class DeliveryRegion {
    private int id;
    private int external_id;
    private GeoLocation location;
    
    public DeliveryRegion(int external_id,GeoLocation location)
    {
        this.external_id = external_id;
        this.location=location;
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
     * @return the location
     */
    public GeoLocation getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(GeoLocation location) {
        this.location = location;
    }

}
