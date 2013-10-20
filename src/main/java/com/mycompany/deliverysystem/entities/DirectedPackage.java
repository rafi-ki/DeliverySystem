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
    private String address;
    private boolean delivered;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    private DeliveryRegion deliveryRegion;
    
    public DirectedPackage(){}
    
    public DirectedPackage(String address, DeliveryRegion deliveryRegion)
    {
        this.deliveryRegion = deliveryRegion;
        this.address = address;
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

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString()
    {
        return "DirectedPackage: id<" + id + ">, "
                + "address<" + address + ">, "
                + "delivered<" + delivered + ">, "
                + "deliveryregion_externalId<" + deliveryRegion.getExternal_id() + ">";
    }
}
