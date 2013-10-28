/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
import java.util.List;
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
        //arrange
        DeliveryRegion object =new DeliveryRegion("555",2.0,4.0);
        object.setId(Long.MAX_VALUE);
        TestMethod_Add(object);
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        
        //act
        DeliveryRegion result = instance.getByExternalId("555");
        
        //clean up
        TestMethod_Remove(object);
        
        //assert
        assertEquals(object, result);
    }

    /**
     * Test of getByLocation method, of class DeliveryRegionRepositoryDB.
     */
    public void testGetByLocation() throws Exception {
        System.out.println("getByLocation");
        //arrange
        DeliveryRegion object =new DeliveryRegion("555",2.0,4.0);
        object.setId(Long.MAX_VALUE);
        TestMethod_Add(object);
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        
        //act
        DeliveryRegion result = instance.getByLocation(2.0, 4.0);
        
        //clean up
        TestMethod_Remove(object);
        
        //assert
        assertEquals(object, result);
        
        
    }

    /**
     * Test of getClosestByLocation method, of class DeliveryRegionRepositoryDB.
     */
    public void testGetClosestByLocation() throws Exception {
        System.out.println("getClosestByLocation");
       //arrange
        DeliveryRegion object =new DeliveryRegion("111",2.0,4.0);
        object.setId(Long.MAX_VALUE);
        TestMethod_Add(object);
        
        DeliveryRegion expResult =new DeliveryRegion("2",5.0,5.0);
        expResult.setId(Long.MAX_VALUE-1);
        TestMethod_Add(expResult);
        
        object =new DeliveryRegion("3",0.0,0.0);
        object.setId(Long.MAX_VALUE-2);
        TestMethod_Add(object);
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        
        //act
        DeliveryRegion result = instance.getClosestByLocation(4.5, 5.6);
        
        //clean up
        TestMethod_RemoveById(Long.MAX_VALUE);
        TestMethod_RemoveById(Long.MAX_VALUE-1);
        TestMethod_RemoveById(Long.MAX_VALUE-2);
        
        //assert
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class DeliveryRegionRepositoryDB.
     */
    public void testAdd() throws Exception {
        System.out.println("add");
        //arrange
        DeliveryRegion Object = new DeliveryRegion("333", 3.33, 5.55);
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        Object.setId(Long.MAX_VALUE);
        
        //act
        instance.add(Object);
        
        DeliveryRegion result=TestMethod_getById(Object.getId());
        //clean up
        TestMethod_Remove(Object);
        
        //assert
        assertNotNull(result);
        assertEquals("333", result.getExternal_id());
        assertEquals(3.33,result.getLongitude());
        assertEquals(5.55,result.getLatitude());
        
        
    }

    /**
     * Test of update method, of class DeliveryRegionRepositoryDB.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        //arrange
        DeliveryRegion Object = new DeliveryRegion("333", 3.33, 5.55);
        Object.setId(Long.MAX_VALUE);
        TestMethod_Add(Object);
        Object= new DeliveryRegion("888",7,9);
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        //act
        instance.update(Long.MAX_VALUE, Object);
        DeliveryRegion result=TestMethod_getById(Long.MAX_VALUE);
        //clean up
        TestMethod_RemoveById(Long.MAX_VALUE);
        
        //assert
        
        assertNotNull(result);
        assertEquals("888", result.getExternal_id());
        assertEquals(7.0, result.getLongitude());
        assertEquals(9.0, result.getLatitude());
        
        
    }

    /**
     * Test of delete method, of class DeliveryRegionRepositoryDB.
     */
    public void testDelete() throws Exception {
        System.out.println("delete");
        //arrange
        DeliveryRegion object =new DeliveryRegion("1",2,4);
        object.setId(Long.MAX_VALUE);
        TestMethod_Add(object);
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        
        //act
        instance.delete(Long.MAX_VALUE);
        
        //assert
        DeliveryRegion result=TestMethod_getById(Long.MAX_VALUE);
        
        assertNull(result);
    }

    /**
     * Test of getAll method, of class DeliveryRegionRepositoryDB.
     */
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        //arrange
        DeliveryRegion object =new DeliveryRegion("1",2.0,4.0);
        object.setId(Long.MAX_VALUE);
        TestMethod_Add(object);
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        
        //act
        List<DeliveryRegion> result = (List<DeliveryRegion>) instance.getAll();
        
        //clean up
        TestMethod_Remove(object);
        //assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.contains(object));
        
        
    }

    /**
     * Test of getById method, of class DeliveryRegionRepositoryDB.
     */
    public void testGetById() throws Exception {
        System.out.println("getById");
        //arrange
        DeliveryRegion object =new DeliveryRegion("1",2.0,4.0);
        object.setId(Long.MAX_VALUE);
        TestMethod_Add(object);
        DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
        
        //getresult and clean up
        DeliveryRegion result = instance.getById(object.getId());
        TestMethod_Remove(object);
        
        //assert
        assertEquals(object, result);
        
    }
    
    public void testExceptionInAdd(){
    
            System.out.println("ExceptionInAdd");
            
            //arrange
       
            DeliveryRegionRepositoryDB instance = new DeliveryRegionRepositoryDB(entityManager);
            
            //act 
            try{
                instance.add(null);
                fail("No Exception was thrown!");
            }catch (Exception ex){
                //assert
                
            }
        
            
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
  private void TestMethod_Add(DeliveryRegion Object)throws RepositoryException{
      EntityTransaction tx = null;
      try{
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(Object);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw new RepositoryException(ex);
        }
  }
  
  private void TestMethod_RemoveById(long id)throws RepositoryException{
      EntityTransaction tx = null;
      try{
            tx = entityManager.getTransaction();
            tx.begin();
            DeliveryRegion Object = entityManager.find(DeliveryRegion.class, id);
            entityManager.remove(Object);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw new RepositoryException(ex);
        }
  }
  private DeliveryRegion TestMethod_getById(long id)throws RepositoryException{
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
            throw new RepositoryException(ex);
        }
        return result;
  }
  
}
