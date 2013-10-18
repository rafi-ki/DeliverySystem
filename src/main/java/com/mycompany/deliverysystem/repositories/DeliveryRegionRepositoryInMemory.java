/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dominik, rafael
 */
public class DeliveryRegionRepositoryInMemory implements DeliveryRegionRepository {

    public List<DeliveryRegion> regions = new ArrayList<DeliveryRegion>();

    public DeliveryRegion getByExternalId(int id) {
        
        for (DeliveryRegion tempregion:regions){
            if(tempregion.getExternal_id()==id){
                return tempregion;
            }
        }
        return null;
    }

    public DeliveryRegion getByLocation(double longitude, double latitude) {
        for (DeliveryRegion tempregion:regions){
            if((tempregion.getLatitude() == latitude) && (tempregion.getLongitude()== longitude) ){
                return tempregion;
            }
        }
        return null;
    }

    public DeliveryRegion getClosestByLocation(double longitude, double latitude) {
        if (regions.isEmpty()){
            return null;
        }
        
        DeliveryRegion nearest = null;
        double currentdistance = -1;
        
        for (DeliveryRegion tempregion:regions){
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

    public void add(DeliveryRegion newRegion) {
        regions.add(newRegion);
    }

    public void update(long id,DeliveryRegion Object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterable<DeliveryRegion> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DeliveryRegion getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
