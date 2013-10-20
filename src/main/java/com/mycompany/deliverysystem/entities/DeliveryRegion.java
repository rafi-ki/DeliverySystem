/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 *
 * @author rafael, dominik
 */
@Entity
public class DeliveryRegion implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    
    private int external_id;
    private double longitude;
    private double latitude;
    
    @OneToMany (mappedBy="DeliveryRegion",cascade=CascadeType.PERSIST)
    private List<DirectedPackage> directedPackage = new ArrayList<DirectedPackage>();

    public DeliveryRegion() {
    }
    
    public DeliveryRegion(int external_id, double longitude, double latitude)
    {
        this.external_id = external_id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
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

    /**
     * @return the directedPackage
     */
    public List<DirectedPackage> getDirectedPackage() {
        return directedPackage;
    }

    /**
     * @param directedPackage the directedPackage to set
     */
    public void setDirectedPackage(List<DirectedPackage> directedPackage) {
        this.directedPackage = directedPackage;
    }

}
