package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
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
public class DeliveryRegionRepositoryDB implements DeliveryRegionRepository{
    
    private EntityManager entityManager;
    private final static Logger LOGGER = Logger.getLogger(DeliveryRegionRepositoryDB.class.getName());
    public DeliveryRegionRepositoryDB (EntityManager entMan){
        this.entityManager=entMan;
    }
    
    public DeliveryRegion getByExternalId(int id) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            Query query = entityManager.createQuery("SELECT pack FROM DeliveryRegion pack WHERE pack.external_id=:id");
            query.setParameter("id", id);
            DeliveryRegion region = (DeliveryRegion) query.getResultList().get(0);
            tx.commit();
            return region;
        } catch (Exception ex) {
             if( tx != null )
                tx.rollback();
             LOGGER.log(Level.SEVERE, "Error in getByExternalId with id ="+id, ex);
            throw new RepositoryException(ex);
        }
    }

    public DeliveryRegion getByLocation(double longitude, double latitude) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            Query query = entityManager.createQuery("SELECT pack FROM DeliveryRegion pack WHERE pack.longitude=:longitude AND pack.latitude=:latitude");
            query.setParameter("longitude", longitude);
            query.setParameter("latitude", latitude);
            DeliveryRegion region = (DeliveryRegion) query.getResultList().get(0);
            tx.commit();
            return region;
        } catch (Exception ex) {
             if( tx != null )
                tx.rollback();
             LOGGER.log(Level.SEVERE, "Error in getByLocation with longitude ="+longitude+" and latitude="+latitude, ex);
            throw new RepositoryException(ex);
        }
        
    }

    public DeliveryRegion getClosestByLocation(double longitude, double latitude) throws RepositoryException {
        DeliveryRegion nearest = null;
        double currentdistance=-1;
        List<DeliveryRegion> allRegions= (List<DeliveryRegion>) getAll();
        
        if(allRegions.isEmpty()){
            return null;
        }
        
         for (DeliveryRegion tempregion:allRegions){
            if(nearest!=null)
            {
                double deltaLong = Math.abs(tempregion.getLongitude()-longitude);
                double deltaLat = Math.abs(tempregion.getLatitude()-latitude);
                double tempdistance=Math.sqrt(deltaLong*deltaLong+deltaLat*deltaLat);
                
                if(tempdistance<currentdistance){
                    nearest=tempregion;
                    currentdistance=tempdistance;
                }
            }
            else{
                nearest=tempregion;
                
                double deltaLong = Math.abs(tempregion.getLongitude()-longitude);
                double deltaLat = Math.abs(tempregion.getLatitude()-latitude);
                currentdistance=Math.sqrt(deltaLong*deltaLong+deltaLat*deltaLat);
            }
        }
        
        return nearest;
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
            LOGGER.log(Level.SEVERE, "Error in add()", ex);
            throw new RepositoryException(ex);
        }
    }

    public void update(long id, DeliveryRegion Object) throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            DeliveryRegion update = entityManager.find(DeliveryRegion.class, id);
            update.setExternal_id(Object.getExternal_id());
            update.setLatitude(Object.getLatitude());
            update.setLongitude(Object.getLongitude());
            update.setDirectedPackage(Object.getDirectedPackage());
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            LOGGER.log(Level.SEVERE, "Error in update() with id ="+id, ex);
            throw new RepositoryException(ex);
        }
    }

    public void delete(long id) throws RepositoryException {
        EntityTransaction tx = null;
      try{
            tx = entityManager.getTransaction();
            tx.begin();
            DeliveryRegion todel=entityManager.find(DeliveryRegion.class,id);
            entityManager.remove(todel);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            LOGGER.log(Level.SEVERE, "Error in delete() with id ="+id, ex);
            throw new RepositoryException(ex);
        }
    }

    public Iterable<DeliveryRegion> getAll() throws RepositoryException {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            Query query = entityManager.createQuery("SELECT pack FROM DeliveryRegion pack");
            List<DeliveryRegion> regionList = query.getResultList();
            tx.commit();
            return regionList;
        } catch (Exception ex) {
             if( tx != null )
                tx.rollback();
             LOGGER.log(Level.SEVERE, "Error in getAll", ex);
            throw new RepositoryException(ex);
        }
    }

    public DeliveryRegion getById(long id) throws RepositoryException {
       DeliveryRegion result=null;
      EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            result=entityManager.find(DeliveryRegion.class, id);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            LOGGER.log(Level.SEVERE, "Error in getById with id ="+id, ex);
            throw new RepositoryException(ex);
        }
        return result;
    }
    
}
