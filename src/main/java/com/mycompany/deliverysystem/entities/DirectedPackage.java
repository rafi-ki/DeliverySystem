/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.entities;

/**
 *
 * @author rafael
 */
public class DirectedPackage {
    
    private int id;
    private int package_id;
    private int delivery_region_id;
    private boolean delivered;
    
    public DirectedPackage(int package_id, int delivery_region_id)
    {
        this.package_id = package_id;
        this.delivery_region_id = delivery_region_id;
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
     * @return the package_id
     */
    public int getPackage_id() {
        return package_id;
    }

    /**
     * @param package_id the package_id to set
     */
    public void setPackage_id(int package_id) {
        this.package_id = package_id;
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
}
