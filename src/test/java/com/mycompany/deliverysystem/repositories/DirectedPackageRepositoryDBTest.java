/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
import com.mycompany.deliverysystem.entities.DirectedPackage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
        System.out.println("add");
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DeliveryRegion region=new DeliveryRegion(1,1.0,1.0);
        DirectedPackage pack =new DirectedPackage("address1",region);
        repo.add(pack);
        
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
        System.out.println("delete");
        long id = 0L;
     
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class DirectedPackageRepositoryDB.
     */
    public void testGetAll() throws Exception {
        System.out.println("getAll");
       
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class DirectedPackageRepositoryDB.
     */
    public void testGetById() throws Exception {
        System.out.println("getById");
       
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
