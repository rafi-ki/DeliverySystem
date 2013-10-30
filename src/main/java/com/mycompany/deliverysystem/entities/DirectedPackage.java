/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author rafael, dominik
 */
@Entity
public class DirectedPackage implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    private String street;
    private String postalcode;
    private String city;
    private boolean delivered;
    
    @ManyToOne (cascade= CascadeType.PERSIST)
    private DeliveryRegion deliveryRegion;
    
    public DirectedPackage(){}
    
    public DirectedPackage(String street, String postalcode, String city, DeliveryRegion deliveryRegion)
    {
        this.deliveryRegion = deliveryRegion;
        this.street = street;
        this.postalcode = postalcode;
        this.city = city;
        this.delivered = false;
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
     * @return the delivery_region_id
     */
    public DeliveryRegion getDeliveryRegion() {
        return deliveryRegion;
    }

    /**
     * @param delivery_region_id the delivery_region_id to set
     */
    public void setDeliveryRegion(DeliveryRegion deliveryRegion) {
        this.deliveryRegion = deliveryRegion;
    }

    /**
     * @return the delivered
     */
    public boolean isDelivered() {
        return delivered;
    }

    /**
     * @param delivered the delivered to set
     */
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    @Override
    public String toString()
    {
        return "DirectedPackage: id<" + id + ">, "
                + "address<" + getCity() + ">, "
                + "delivered<" + delivered + ">, "
                + "deliveryregion_externalId<" + deliveryRegion.getExternal_id() + ">";
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the postalcode
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     * @param postalcode the postalcode to set
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
}
