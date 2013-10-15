/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

/**
 *
 * @author rafael, dominik
 */
public interface DirectedPackageRepository<DirectedPackage> extends Repository {
    public Iterable<DirectedPackage> getDirectedPackageByRegionId(int region_id);
    public void setPackageAsDelivered(int delivered_package_id);
}
