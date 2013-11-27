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
import javax.persistence.Query;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
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
    
    private void testmethod_add(DirectedPackage newPackage)
    {
        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(newPackage);
            tx.commit();
        } catch (Exception err){
            if( tx != null )
                tx.rollback();
        }
    }
    
    private void testmethod_delete(long id)
    {
         EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            DirectedPackage toDelete = entityManager.find(DirectedPackage.class, id);
            entityManager.remove(toDelete);
            tx.commit();
        } catch(Exception ex) {
            if (tx != null)
                tx.rollback();
        }
    }
    
    private Iterable<DirectedPackage> testmethod_getAll()
    {
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
             return null;
        }
    }
    
    private DirectedPackage testmethod_getById(long id)
    {
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
            return null;
        }
    }

    /**
     * Test of getDirectedPackageByRegionId method, of class DirectedPackageRepositoryDB.
     */
    public void testGetDirectedPackageByRegionId() throws Exception {
        System.out.println("getDirectedPackageByRegionId ");
        
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DeliveryRegion region = new DeliveryRegion();
        region.setId(Long.MAX_VALUE);
        DirectedPackage newPackage = new DirectedPackage("street", "postal", "city", region);
        this.testmethod_add(newPackage);
        
        //act
        Iterable<DirectedPackage> result = repo.getDirectedPackageByRegionId(region.getId());
        
        //achieve necessary
        int resultCount = 0;
        for (DirectedPackage p : result)
            resultCount++;
        
        //clean up
        this.testmethod_delete(newPackage.getId());
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
        System.out.println("setPackageAsDelivered");
      
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage newPackage = new DirectedPackage();
        newPackage.setId(Long.MAX_VALUE);
        this.testmethod_add(newPackage);
        
        //act
        repo.setPackageAsDelivered(newPackage.getId());
        
        //achieve necessary
        DirectedPackage result = this.testmethod_getById(newPackage.getId());
        
        //clean up
        this.testmethod_delete(newPackage.getId());
        
        //assert
        assertTrue(result.isDelivered());
    }

    /**
     * Test of add method, of class DirectedPackageRepositoryDB.
     */
    public void testAdd() throws Exception {
        System.out.println("add");
        
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage pack = new DirectedPackage();
        long packId = Long.MAX_VALUE;
        pack.setId(packId);
        
        //act
        repo.add(pack);
        
        //achieve necessary
        DirectedPackage expResult = null;
        Iterable<DirectedPackage> allPackages = this.testmethod_getAll();
        for (DirectedPackage p : allPackages)
        {
            if (p.getId() == packId)
                expResult = p;
        }
        
         //clean up
        this.testmethod_delete(packId);
        
        //assert
        assertEquals(expResult, pack);
    }

    /**
     * Test of update method, of class DirectedPackageRepositoryDB.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        //arrange
        String updateStreet = "update street";
        String updatePostal = "update postal";
        String updateCity = "update city";
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage newPackage = new DirectedPackage();
        newPackage.setId(Long.MAX_VALUE);
        this.testmethod_add(newPackage);
        DirectedPackage updatePackage = new DirectedPackage();
        updatePackage.setStreet(updateStreet);
        updatePackage.setPostalcode(updatePostal);
        updatePackage.setCity(updateCity);
        
        //act
        repo.update(newPackage.getId(), updatePackage);
        
        //achieve necessary
        DirectedPackage result = this.testmethod_getById(newPackage.getId());
        
        //clean up
        this.testmethod_delete(newPackage.getId());
        
        //assert
        boolean equalStreet = result.getStreet().equals(updateStreet);
        boolean equalPostal = result.getPostalcode().equals(updatePostal);
        boolean equalCity = result.getCity().equals(updateCity);
        assertTrue(equalStreet && equalPostal && equalCity);
    }

    /**
     * Test of delete method, of class DirectedPackageRepositoryDB.
     */
    public void testDelete() throws Exception {
        System.out.println("delete");
        
        //arrange
        long packId = Long.MAX_VALUE;
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage tempPackage = new DirectedPackage();
        tempPackage.setId(packId);
        this.testmethod_add(tempPackage);
        
        //act
        repo.delete(packId);
        
        //achieve necessary
        Iterable<DirectedPackage> allPackages = this.testmethod_getAll();
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
        System.out.println("getById");
       
        //arrange
        DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
        DirectedPackage newPackage = new DirectedPackage();
        newPackage.setId(Long.MAX_VALUE);
        this.testmethod_add(newPackage);
        
        //act 
        DirectedPackage result = repo.getById(Long.MAX_VALUE);
        
        //achieve necessary
        // nothing to do here
        
        //clean up
        this.testmethod_delete(Long.MAX_VALUE);
        
        //assert
        assertEquals(result, newPackage);
    }
    
    public void testExceptionInAdd(){
            System.out.println("ExceptionInAdd");
            //arrange
           DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
            //act 
            try{
                repo.add(null);
                fail("No Exception was thrown!");
            }catch (Exception ex){
                //assert
                
            }
    }
    
     public void testExceptionInUpdate(){
            System.out.println("ExceptionInUpdate");
            //arrange
           DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
            //act 
            try{
                repo.update(-1,null);
                fail("No Exception was thrown!");
            }catch (Exception ex){
                //assert
                
            }
    }
    
      public void testExceptionInDelete(){
            System.out.println("ExceptionInDelete");
            //arrange
           DirectedPackageRepositoryDB repo = new DirectedPackageRepositoryDB(entityManager);
            //act 
            try{
                repo.delete(-1);
                fail("No Exception was thrown!");
            }catch (Exception ex){
                //assert
                
            }
    }
}
