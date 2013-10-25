/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DirectedPackage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author dominik,rafael
 */
public class DirectedPackageRepositoryDB implements DirectedPackageRepository {

    private final static Logger LOGGER = Logger.getLogger(DirectedPackageRepositoryDB.class.getName()); 
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
        EntityTransaction tx = null;
        try{
          tx = entityManager.getTransaction();
          tx.begin();
          Query query = entityManager.createQuery("SELECT pack FROM DirectedPackage pack WHERE pack.deliveryRegion.id = :regionId");
          query.setParameter("regionId", region_id);
          List<DirectedPackage> result = query.getResultList();
          tx.commit();
          return result;
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            LOGGER.log(Level.SEVERE, "Could not get directed packges by region id <" + region_id + ">", ex);
            throw new RepositoryException(ex);
        }
    }

    public void setPackageAsDelivered(long delivered_package_id) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            DirectedPackage updatePackage = entityManager.find(DirectedPackage.class, delivered_package_id);
            updatePackage.setDelivered(true);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            LOGGER.log(Level.SEVERE, "Could not set directed packge with id <" + delivered_package_id +"> as deliverd", ex);
            throw new RepositoryException(ex);
        }
    }

    public void add(DirectedPackage Object) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(Object);
            LOGGER.log(Level.INFO, "added DirectedPackage successfully");
            tx.commit();
        }catch (Exception ex){
            if( tx != null )
                tx.rollback();
            LOGGER.log(Level.SEVERE, "Could not add directed packge", ex);
            throw new RepositoryException(ex);
        }
    }

    public void update(long id, DirectedPackage Object) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            DirectedPackage updatePackage = entityManager.find(DirectedPackage.class, id);
            updatePackage.setAddress(Object.getAddress());
            updatePackage.setDelivered(Object.isDelivered());
            updatePackage.setDeliveryRegion(Object.getDeliveryRegion());
            LOGGER.log(Level.INFO, "updated DirectedPackage with id <{0}> successfully", id);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            LOGGER.log(Level.SEVERE, "Could not update directed packge with id <" + id + ">", ex);
            throw new RepositoryException(ex);
        }
    }

    public void delete(long id) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            DirectedPackage toDelete = entityManager.find(DirectedPackage.class, id);
            entityManager.remove(toDelete);
            tx.commit();
            LOGGER.log(Level.INFO, "deleted DirectedPackage with id <{0}> successfully", id);
        } catch(Exception ex)
        {
            if (tx != null)
                tx.rollback();
            LOGGER.log(Level.SEVERE, "Could not delete directed packge with id <" + id + ">", ex);
            throw new RepositoryException(ex);
        }
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
             LOGGER.log(Level.SEVERE, "Error getting all packages", ex);
            throw new RepositoryException(ex);
        }
    }

    public DirectedPackage getById(long id) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            DirectedPackage result = entityManager.find(DirectedPackage.class, id);
            tx.commit();
            return result;
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            LOGGER.log(Level.SEVERE, "Could not get directed packge by Id <" + id + ">", ex);
            throw new RepositoryException(ex);
        }
    }
}
