/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import junit.framework.TestCase;

/**
 *
 * @author dominik,rafael
 */
public class DeliveryRegionRepositoryDBTest extends TestCase {
    private  EntityManager entityManager;
    public DeliveryRegionRepositoryDBTest(String testName) {
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
     * Test of getByExternalId method, of class DeliveryRegionRepositoryDB.
     */
    public void testGetByExternalId() throws Exception {
        System.out.println("getByExternalId");
        int id = 0;
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        DeliveryRegion expResult = null;
        DeliveryRegion result = instance.getByExternalId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByLocation method, of class DeliveryRegionRepositoryDB.
     */
    public void testGetByLocation() throws Exception {
        System.out.println("getByLocation");
        double longitude = 0.0;
        double latitude = 0.0;
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        DeliveryRegion expResult = null;
        DeliveryRegion result = instance.getByLocation(longitude, latitude);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClosestByLocation method, of class DeliveryRegionRepositoryDB.
     */
    public void testGetClosestByLocation() throws Exception {
        System.out.println("getClosestByLocation");
        double longitude = 0.0;
        double latitude = 0.0;
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        DeliveryRegion expResult = null;
        DeliveryRegion result = instance.getClosestByLocation(longitude, latitude);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class DeliveryRegionRepositoryDB.
     */
    public void testAdd() throws Exception {
        System.out.println("add");
        //arrange
        DeliveryRegion Object = new DeliveryRegion(333, 3.33, 5.55);
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        Object.setId(Long.MAX_VALUE);
        
        //act
        instance.add(Object);
        
        //assert
        DeliveryRegion result=null;
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            result = entityManager.find(DeliveryRegion.class, Object.getId());
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            fail("Excepion at getting added object from database!");
            throw new RepositoryException(ex);
        }
        assertNotNull(result);
        assertEquals(333, result.getExternal_id());
        assertEquals(3.33,result.getLongitude());
        assertEquals(5.55,result.getLatitude());
        
        //clean up
        TestMethod_Remove(Object);
    }

    /**
     * Test of update method, of class DeliveryRegionRepositoryDB.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
        long id = 0L;
        DeliveryRegion Object = null;
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        instance.update(id, Object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DeliveryRegionRepositoryDB.
     */
    public void testDelete() throws Exception {
        System.out.println("delete");
        long id = 0L;
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class DeliveryRegionRepositoryDB.
     */
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        Iterable expResult = null;
        Iterable result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class DeliveryRegionRepositoryDB.
     */
    public void testGetById() throws Exception {
        System.out.println("getById");
        long id = 0L;
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        DeliveryRegion expResult = null;
        DeliveryRegion result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
  private void TestMethod_Remove(DeliveryRegion Object)throws RepositoryException{
      EntityTransaction tx = null;
      try{
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(Object);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw new RepositoryException(ex);
        }
  }
}
