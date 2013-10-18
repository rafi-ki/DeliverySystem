/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DirectedPackage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dominik,rafael
 */
public class DirectedPackageRepositoryInMemory implements DirectedPackageRepository {
    
    public List<DirectedPackage> packageList = new ArrayList<DirectedPackage>();

    public Iterable getDirectedPackageByRegionId(long region_id) {
        List<DirectedPackage> resultList = new ArrayList<DirectedPackage>();
        for (DirectedPackage pack : packageList)
        {
            if(pack.getDeliveryRegion().getId() == region_id)
                resultList.add(pack);
        }
        
        return resultList;
    }

    public void setPackageAsDelivered(long delivered_package_id) {
        for (DirectedPackage p : packageList)
        {
            if (p.getId() == delivered_package_id)
            {
                p.setDelivered(true);
                break;
            }
        }
    }

    public void add(DirectedPackage Object) {
        this.packageList.add(Object);
    }

    public void update(long id, DirectedPackage newPackage) {
        DirectedPackage pToDelete = null;
        for (DirectedPackage dirPackage : packageList)
        {
            if(dirPackage.getId() == id)
               pToDelete = dirPackage;
        }
        if (pToDelete != null)
        {
            newPackage.setId(pToDelete.getId());
            packageList.remove(pToDelete);
            packageList.add(newPackage);
        }
    }

    public void delete(long id) {
        DirectedPackage pToDelete = null;
        for (DirectedPackage p : packageList)
        {
            if (p.getId() == id)
            {
                pToDelete = p;
                break;
            }
        }
        if (pToDelete != null)
            packageList.remove(pToDelete);
    }

    public Iterable<DirectedPackage> getAll() {
        return packageList;
    }

    public DirectedPackage getById(long id) {
        DirectedPackage result = null;
        for (DirectedPackage p : packageList)
        {
            if (p.getId() == id)
                result = p;
        }
        return result;
    }

    
}
