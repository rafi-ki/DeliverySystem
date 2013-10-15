/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

/**
 *
 * @author rafael, dominik
 */
public interface DeliveryRegionRepository<DeliveryRegion> extends Repository{
    public DeliveryRegion getByExternalId(int id);
    public DeliveryRegion getByLocation(double longitude, double latitude);
    public DeliveryRegion getClosestByLocation(double longitude, double latitude);
}
