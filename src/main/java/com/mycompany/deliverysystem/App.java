package com.mycompany.deliverysystem;

import com.mycompany.deliverysystem.repositories.DirectedPackageRepositoryDB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("deliverysystem");
        EntityManager manager = factory.createEntityManager();
        DirectedPackageRepositoryDB db = new DirectedPackageRepositoryDB(manager);
        try{
            db.getAll();
        }
        catch(Exception e)
        {
            
        }
    }
}
