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
import javax.persistence.Persistence;
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
        System.out.println("getDirectedPackageByRegionId");
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPackageAsDelivered method, of class DirectedPackageRepositoryDB.
     */
    public void testSetPackageAsDelivered() throws Exception {
        System.out.println("setPackageAsDelivered");
      
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class DirectedPackageRepositoryDB.
     */
    public void testAdd() throws Exception {
        System.out.println("add - require getAll(), delete()");
        
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DeliveryRegion region = new DeliveryRegion(1,1.0,1.0);
        DirectedPackage pack = new DirectedPackage("address1",region);
        long packId = Long.MAX_VALUE;
        pack.setId(packId);
        
        //act
        repo.add(pack);
        
        //assert
        DirectedPackage expResult = null;
        Iterable<DirectedPackage> allPackages = repo.getAll();
        for (DirectedPackage p : allPackages)
        {
            if (p.getId() == packId)
                expResult = p;
        }
        
        //clean up
        repo.delete(packId);
        
        assertEquals(expResult, pack);
    }

    /**
     * Test of update method, of class DirectedPackageRepositoryDB.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
       
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        
        //clean
        // nothing to do here
        
        //assert
        Iterable<DirectedPackage> allPackages = repo.getAll();
        DirectedPackage result = null;
        for (DirectedPackage p : allPackages)
        {
            if (p.getId() == packId)
                result = p;
        }
        
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
        
        //clean up
        repo.delete(Long.MAX_VALUE);
        
        //assert
        assertEquals(result, newPackage);
    }
}
