/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.entities;

/**
 *
 * @author rafael, dominik
 */
public class DirectedPackage {
    
    private int id;
    private String address;
    private DeliveryRegion deliveryRegion;
    private boolean delivered;
    
    public DirectedPackage(String address, DeliveryRegion deliveryRegion)
    {
        this.deliveryRegion = deliveryRegion;
        this.address = address;
        this.delivered = false;
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
     * @return the delivery_region_id
     */
    public DeliveryRegion getDelivery_region_id() {
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
}
