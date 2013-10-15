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
    private int delivery_region_id;
    private boolean delivered;
    
    public DirectedPackage(String address, int delivery_region_id)
    {
        this.delivery_region_id = delivery_region_id;
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
    public int getDelivery_region_id() {
        return delivery_region_id;
    }

    /**
     * @param delivery_region_id the delivery_region_id to set
     */
    public void setDelivery_region_id(int delivery_region_id) {
        this.delivery_region_id = delivery_region_id;
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
