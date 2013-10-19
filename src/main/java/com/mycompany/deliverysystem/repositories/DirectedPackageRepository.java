/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DirectedPackage;

/**
 *
 * @author rafael, dominik
 */
public interface DirectedPackageRepository extends Repository<DirectedPackage> {
    public Iterable getDirectedPackageByRegionId(long region_id)throws RepositoryException;
    public void setPackageAsDelivered(long delivered_package_id)throws RepositoryException;
}
