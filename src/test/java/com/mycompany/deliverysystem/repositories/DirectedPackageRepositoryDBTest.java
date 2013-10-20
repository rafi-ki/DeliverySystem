/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
import com.mycompany.deliverysystem.entities.DirectedPackage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 *
 * @author dominik
 */
public class DirectedPackageRepositoryDBTest extends TestCase {
    
    private EntityManager entityManager;
    
    public DirectedPackageRepositoryDBTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("deliverysystem");
        entityManager = factory.createEntityManager();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        entityManager.close();
    }

    /**
     * Test of getDirectedPackageByRegionId method, of class DirectedPackageRepositoryDB.
     */
    public void testGetDirectedPackageByRegionId() throws Exception {
        System.out.println("getDirectedPackageByRegionId - requires add(), delete()");
        
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DeliveryRegion region = new DeliveryRegion();
        region.setId(Long.MAX_VALUE);
        DirectedPackage newPackage = new DirectedPackage("address", region);
        repo.add(newPackage);
        
        //act
        Iterable<DirectedPackage> result = repo.getDirectedPackageByRegionId(region.getId());
        
        //achieve necessary
        int resultCount = 0;
        for (DirectedPackage p : result)
            resultCount++;
        
        //clean up
        repo.delete(newPackage.getId());
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(region);
        tx.commit();
        
        //assert
        assertEquals(resultCount, 1);
    }

    /**
     * Test of setPackageAsDelivered method, of class DirectedPackageRepositoryDB.
     */
    public void testSetPackageAsDelivered() throws Exception {
        System.out.println("setPackageAsDelivered - requires getById(), add(), delete()");
      
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage newPackage = new DirectedPackage();
        newPackage.setId(Long.MAX_VALUE);
        repo.add(newPackage);
        
        //act
        repo.setPackageAsDelivered(newPackage.getId());
        
        //achieve necessary
        DirectedPackage result = repo.getById(newPackage.getId());
        
        //clean up
        repo.delete(newPackage.getId());
        
        //assert
        assertTrue(result.isDelivered());
    }

    /**
     * Test of add method, of class DirectedPackageRepositoryDB.
     */
    public void testAdd() throws Exception {
        System.out.println("add - require getAll(), delete()");
        
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage pack = new DirectedPackage();
        long packId = Long.MAX_VALUE;
        pack.setId(packId);
        
        //act
        repo.add(pack);
        
        //achieve necessary
        DirectedPackage expResult = null;
        Iterable<DirectedPackage> allPackages = repo.getAll();
        for (DirectedPackage p : allPackages)
        {
            if (p.getId() == packId)
                expResult = p;
        }
        
         //clean up
        repo.delete(packId);
        
        //assert
        assertEquals(expResult, pack);
    }

    /**
     * Test of update method, of class DirectedPackageRepositoryDB.
     */
    public void testUpdate() throws Exception {
        System.out.println("update - requires getById(), add(), delete()");
        
        //arrange
        String updatedAddress = "update address";
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage newPackage = new DirectedPackage();
        newPackage.setId(Long.MAX_VALUE);
        repo.add(newPackage);
        DirectedPackage updatePackage = new DirectedPackage();
        updatePackage.setAddress(updatedAddress);
        
        //act
        repo.update(newPackage.getId(), updatePackage);
        
        //achieve necessary
        DirectedPackage result = repo.getById(newPackage.getId());
        
        //clean up
        repo.delete(newPackage.getId());
        
        //assert
        assertEquals(result.getAddress(), updatedAddress);
    }

    /**
     * Test of delete method, of class DirectedPackageRepositoryDB.
     */
    public void testDelete() throws Exception {
        System.out.println("delete - requires getAll(), add()");
        
        //arrange
        long packId = Long.MAX_VALUE;
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage tempPackage = new DirectedPackage();
        tempPackage.setId(packId);
        repo.add(tempPackage);
        
        //act
        repo.delete(packId);
        
        //achieve necessary
        Iterable<DirectedPackage> allPackages = repo.getAll();
        DirectedPackage result = null;
        for (DirectedPackage p : allPackages)
        {
            if (p.getId() == packId)
                result = p;
        }
        
        //clean up
        // nothing to do here
        
        //assert
        assertNull(result);
    }

    /**
     * Test of getAll method, of class DirectedPackageRepositoryDB.
     */
    public void testGetAll() throws Exception {
        System.out.println("getAll");
       
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        
        //act
        List<DirectedPackage> result = (List<DirectedPackage>) repo.getAll();
        
        //assert
        assertNotNull(result);
    }

    /**
     * Test of getById method, of class DirectedPackageRepositoryDB.
     */
    public void testGetById() throws Exception {
        System.out.println("getById - requires add(), delete()");
       
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage newPackage = new DirectedPackage();
        newPackage.setId(Long.MAX_VALUE);
        repo.add(newPackage);
        
        //act 
        DirectedPackage result = repo.getById(Long.MAX_VALUE);
        
        //achieve necessary
        // nothing to do here
        
        //clean up
        repo.delete(Long.MAX_VALUE);
        
        //assert
        assertEquals(result, newPackage);
    }
}
