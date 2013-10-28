/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
import com.mycompany.deliverysystem.entities.DirectedPackage;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author rafael
 */
public class DirectedPackageRepositoryInMemoryTest extends TestCase {
    
    public DirectedPackageRepositoryInMemoryTest(String testName) {
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
     * Test of getDirectedPackageByRegionId method, of class DirectedPackageRepositoryInMemory.
     */
    public void testGetDirectedPackageByRegionId() {
        System.out.println("getDirectedPackageByRegionId");
        long region_id = 0;
        long packageId = 2;
        //arrange 
        DirectedPackageRepositoryInMemory instance = new DirectedPackageRepositoryInMemory();
        instance.packageList.clear();
        DeliveryRegion region = new DeliveryRegion("1", 0, 0);
        region.setId(region_id);
        DirectedPackage dirPackage = new DirectedPackage("bla", region);
        dirPackage.setId(packageId);
        instance.packageList.add(dirPackage);
        
        //act
        Iterable<DirectedPackage> result = instance.getDirectedPackageByRegionId(region_id);
        
        //assert
        long resultId = -1;
        for (DirectedPackage p : result)
            resultId = p.getId();
        
        assertEquals(resultId, packageId);
    }

    /**
     * Test of setPackageAsDelivered method, of class DirectedPackageRepositoryInMemory.
     */
    public void testSetPackageAsDelivered() {
        System.out.println("setPackageAsDelivered");
        
        //arrange
        DirectedPackageRepositoryInMemory instance = new DirectedPackageRepositoryInMemory();
        instance.packageList.clear();
        DirectedPackage dirPackage = new DirectedPackage("", new DeliveryRegion());
        instance.add(dirPackage);
        
        //act
        instance.setPackageAsDelivered(dirPackage.getId());
        
        //assert
        boolean expResult = instance.packageList.get(0).isDelivered();
        assertTrue(expResult);
    }

    /**
     * Test of add method, of class DirectedPackageRepositoryInMemory.
     */
    public void testAdd() {
        System.out.println("add");
        
        //arrange
        DirectedPackageRepositoryInMemory instance = new DirectedPackageRepositoryInMemory();
        instance.packageList.clear();
        DirectedPackage dirPackage = new DirectedPackage("aaa", new DeliveryRegion());
        
        //act
        instance.add(dirPackage);
        
        //assert
        assertEquals(instance.packageList.size(), 1);
    }

    /**
     * Test of update method, of class DirectedPackageRepositoryInMemory.
     */
    public void testUpdate() {
        System.out.println("update");
        
        //arrange
        DirectedPackageRepositoryInMemory instance = new DirectedPackageRepositoryInMemory();
        instance.packageList.clear();
        DirectedPackage dirPackage = new DirectedPackage();
        instance.packageList.add(dirPackage);
        String expAddress = "Addresse 1";
        DirectedPackage newPackage = new DirectedPackage();
        newPackage.setAddress(expAddress);
        newPackage.setDelivered(true);
        
        //act
        instance.update(dirPackage.getId(), newPackage);
        
        //assert
        boolean equalAddress = instance.packageList.get(0).getAddress().equals(expAddress);
        boolean equalDeliveredState = instance.packageList.get(0).isDelivered();
        assertTrue(equalAddress && equalDeliveredState);
    }

    /**
     * Test of delete method, of class DirectedPackageRepositoryInMemory.
     */
    public void testDelete() {
        System.out.println("delete");
        
        //arrange
        DirectedPackageRepositoryInMemory instance = new DirectedPackageRepositoryInMemory();
        instance.packageList.clear();
        DirectedPackage dirPackage = new DirectedPackage("Address", new DeliveryRegion());
        long packageId = 1;
        dirPackage.setId(packageId);
        instance.packageList.add(dirPackage);
        
        //act
        instance.delete(packageId);
        
        //arrange
        assertTrue(instance.packageList.isEmpty());
    }

    /**
     * Test of getAll method, of class DirectedPackageRepositoryInMemory.
     */
    public void testGetAll() {
        System.out.println("getAll");
        
        //arrange
        DirectedPackageRepositoryInMemory instance = new DirectedPackageRepositoryInMemory();
        instance.packageList.clear();
        instance.packageList.add(new DirectedPackage());
        instance.packageList.add(new DirectedPackage("address", new DeliveryRegion()));
        
        //act
        List<DirectedPackage> result = (List<DirectedPackage>) instance.getAll();
        
        //assert
        assertEquals(result.size(), 2);
    }

    /**
     * Test of getById method, of class DirectedPackageRepositoryInMemory.
     */
    public void testGetById() {
        System.out.println("getById");
        
        //arrange
        DirectedPackageRepositoryInMemory instance = new DirectedPackageRepositoryInMemory();
        instance.packageList.clear();
        DirectedPackage dirPackage = new DirectedPackage();
        dirPackage.setId(2);
        instance.packageList.add(dirPackage);
        dirPackage = new DirectedPackage();
        dirPackage.setId(4);
        instance.packageList.add(dirPackage);
        
        //act
        DirectedPackage result = instance.getById(2);
        
        //assert
        assertEquals(result.getId(), 2);
    }
}
