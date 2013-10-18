/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import junit.framework.TestCase;

/**
 *
 * @author dominik
 */
public class DeliveryRegionRepositoryInMemoryTest extends TestCase {
    
    public DeliveryRegionRepositoryInMemoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getByExternalId method, of class DeliveryRegionRepositoryInMemory.
     */
    public void testGetByExternalId() {
        System.out.println("getByExternalId");
        
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        instance.regions.add(new DeliveryRegion(123,4.44,4.44));
        instance.regions.add(new DeliveryRegion(325,3.44,3.44));
        instance.regions.add(new DeliveryRegion(495,4.44,4.44));
        
        DeliveryRegion result = instance.getByExternalId(325);
        
        assertNotNull(result);
        assertEquals(3.44, result.getLongitude());
        assertEquals(3.44, result.getLatitude());
        assertEquals(325, result.getExternal_id());
    }
    
    public void testGetByExternalIdInvalid() {
        System.out.println("getByExternalId");
        
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        instance.regions.add(new DeliveryRegion(123,4.44,4.44));
        instance.regions.add(new DeliveryRegion(325,3.44,3.44));
        instance.regions.add(new DeliveryRegion(495,4.44,4.44));
        
        DeliveryRegion result = instance.getByExternalId(999);
        
        assertEquals(result,null);
    }

    /**
     * Test of getByLocation method, of class DeliveryRegionRepositoryInMemory.
     */
    public void testGetByLocation() {
        System.out.println("getByLocation");
        
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        instance.regions.add(new DeliveryRegion(123,5.44,5.44));
        instance.regions.add(new DeliveryRegion(325,3.44,3.44));
        instance.regions.add(new DeliveryRegion(495,4.44,4.44));
        
        DeliveryRegion result = instance.getByLocation(3.44, 3.44);
        
        assertNotNull(result);
        assertEquals(3.44, result.getLongitude());
        assertEquals(3.44, result.getLatitude());
        assertEquals(325, result.getExternal_id());
    }
    
    public void testGetByLocationInvalid() {
        System.out.println("getByLocation");
        
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        instance.regions.add(new DeliveryRegion(123,5.44,5.44));
        instance.regions.add(new DeliveryRegion(325,3.44,3.44));
        instance.regions.add(new DeliveryRegion(495,4.44,4.44));
        
        DeliveryRegion result = instance.getByLocation(3.45, 3.44);
        
        assertEquals(result,null);
    }

    /**
     * Test of getClosestByLocation method, of class DeliveryRegionRepositoryInMemory.
     */
    public void testGetClosestByLocation() {
        System.out.println("getClosestByLocation");
       
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        instance.regions.add(new DeliveryRegion(123,5.44,5.44));
        instance.regions.add(new DeliveryRegion(325,3.44,3.44));
        instance.regions.add(new DeliveryRegion(495,4.44,4.44));
        
        DeliveryRegion result = instance.getClosestByLocation(3.45, 3.54);
        
        assertNotNull(result);
        assertEquals(3.44, result.getLongitude());
        assertEquals(3.44, result.getLatitude());
        assertEquals(325, result.getExternal_id());
    }
    
    public void testGetClosestByLocationInvalid() {
        System.out.println("getClosestByLocation");
       
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        
        DeliveryRegion result = instance.getClosestByLocation(3.45, 3.54);
        
        assertEquals(null, result);
    }

    /**
     * Test of add method, of class DeliveryRegionRepositoryInMemory.
     */
    public void testAdd() {
        System.out.println("add");
        DeliveryRegion newRegion = new DeliveryRegion(123,1.23,2.23);
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        instance.add(newRegion);
        
        assertEquals(instance.regions.size(),1);
    }

    /**
     * Test of update method, of class DeliveryRegionRepositoryInMemory.
     */
    public void testUpdate() {
        System.out.println("update");
        
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        DeliveryRegion tempregion =new DeliveryRegion(123,5.44,5.44);
        tempregion.setId(1);
        instance.regions.add(tempregion);
        tempregion = new DeliveryRegion(325,3.44,3.44);
        tempregion.setId(2);
        instance.regions.add(tempregion);
        tempregion = new DeliveryRegion(987,4.44,4.44);
        tempregion.setId(3);
        instance.regions.add(tempregion);
        
        instance.update(1, new DeliveryRegion(1,2,3));
        
        DeliveryRegion result=instance.regions.get(0);
        
        assertNotNull(result);
        assertEquals(2.0, result.getLongitude());
        assertEquals(3.0, result.getLatitude());
        assertEquals(1, result.getExternal_id());
        
    }

    /**
     * Test of delete method, of class DeliveryRegionRepositoryInMemory.
     */
    public void testDelete() {
        System.out.println("delete");
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        DeliveryRegion tempregion =new DeliveryRegion(123,5.44,5.44);
        tempregion.setId(1);
        instance.regions.add(tempregion);
        
        instance.delete(1);
        
        assertEquals(instance.regions.isEmpty(),true);
        
    }
    
    public void testDeleteInvalid() {
        System.out.println("delete");
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        DeliveryRegion tempregion =new DeliveryRegion(123,5.44,5.44);
        tempregion.setId(1);
        instance.regions.add(tempregion);
        
        instance.delete(2);
        
        assertEquals(false,instance.regions.isEmpty());
        
    }
    /**
     * Test of getAll method, of class DeliveryRegionRepositoryInMemory.
     */
    public void testGetAll() {
        System.out.println("getAll");
        
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        instance.regions.add(new DeliveryRegion(123,5.44,5.44));
        instance.regions.add(new DeliveryRegion(325,3.44,3.44));
        instance.regions.add(new DeliveryRegion(495,4.44,4.44));
        
        List result = (List) instance.getAll();
        assertEquals(3, result.size());
    }

    /**
     * Test of getById method, of class DeliveryRegionRepositoryInMemory.
     */
    public void testGetById() {
        System.out.println("getById");
        
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        DeliveryRegion tempregion =new DeliveryRegion(123,5.44,5.44);
        tempregion.setId(1);
        instance.regions.add(tempregion);
        tempregion = new DeliveryRegion(325,3.44,3.44);
        tempregion.setId(2);
        instance.regions.add(tempregion);
        tempregion = new DeliveryRegion(987,4.44,4.44);
        tempregion.setId(3);
        instance.regions.add(tempregion);
        
        DeliveryRegion result=instance.getById(2);
        
        assertNotNull(result);
        assertEquals(3.44, result.getLongitude());
        assertEquals(3.44, result.getLatitude());
        assertEquals(325, result.getExternal_id());
    }
    public void testGetByIdInvalid() {
        System.out.println("getById");
        
        DeliveryRegionRepositoryInMemory instance = new DeliveryRegionRepositoryInMemory();
        DeliveryRegion tempregion =new DeliveryRegion(123,5.44,5.44);
        tempregion.setId(1);
        instance.regions.add(tempregion);
        tempregion = new DeliveryRegion(325,3.44,3.44);
        tempregion.setId(2);
        instance.regions.add(tempregion);
        tempregion = new DeliveryRegion(987,4.44,4.44);
        tempregion.setId(3);
        instance.regions.add(tempregion);
        
        DeliveryRegion result=instance.getById(20);
        
        assertEquals(null, result);
    }
}
