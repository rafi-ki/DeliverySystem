/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import defines.GeoLocation;

/**
 *
 * @author rafael, dominik
 */
public interface DeliveryRegionRepository<DeliveryRegion> extends Repository{
    public DeliveryRegion getByExternalId(int id);
    public DeliveryRegion getByLocation(GeoLocation location);
    public DeliveryRegion getClosestByLocation(GeoLocation location);
}
