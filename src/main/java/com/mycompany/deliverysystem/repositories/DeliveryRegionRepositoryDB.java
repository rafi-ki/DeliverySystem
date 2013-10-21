/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author dominik,rafael
 */
public class DeliveryRegionRepositoryDB implements DeliveryRegionRepository{
    
    private EntityManager entityManager;
    
    public DeliveryRegionRepositoryDB (EntityManager entMan){
        this.entityManager=entMan;
    }
    
    public DeliveryRegion getByExternalId(int id) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DeliveryRegion getByLocation(double longitude, double latitude) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DeliveryRegion getClosestByLocation(double longitude, double latitude) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(DeliveryRegion Object) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(Object);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw new RepositoryException(ex);
        }
    }

    public void update(long id, DeliveryRegion Object) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(long id) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterable<DeliveryRegion> getAll() throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DeliveryRegion getById(long id) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
