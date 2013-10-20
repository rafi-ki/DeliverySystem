/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DirectedPackage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author dominik,rafael
 */
public class DirectedPackageRepositoryDB implements DirectedPackageRepository {

    private EntityManager entityManager;
    
    public DirectedPackageRepositoryDB(EntityManager entMan){
        this.entityManager=entMan;
    }
    

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Iterable getDirectedPackageByRegionId(long region_id) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPackageAsDelivered(long delivered_package_id) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(DirectedPackage Object) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(Object);
            tx.commit();
        }catch (Exception err){
            if( tx != null )
                tx.rollback();
            throw new RepositoryException(err);
        }
    }

    public void update(long id, DirectedPackage Object) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(long id) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterable<DirectedPackage> getAll() throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            Query query = entityManager.createQuery("SELECT pack FROM DirectedPackage pack");
            List<DirectedPackage> packageList = query.getResultList();
            tx.commit();
            return packageList;
        } catch (Exception ex) {
             if( tx != null )
                tx.rollback();
            throw new RepositoryException(ex);
        }
    }

    public DirectedPackage getById(long id) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}