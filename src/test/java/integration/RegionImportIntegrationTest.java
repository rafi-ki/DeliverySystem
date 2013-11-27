/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integration;

import com.mycompany.deliverysystem.entities.DeliveryRegion;
import com.mycompany.deliverysystem.repositories.DeliveryRegionRepository;
import com.mycompany.deliverysystem.repositories.DeliveryRegionRepositoryDB;
import com.mycompany.deliverysystem.repositories.RepositoryException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import junit.framework.TestCase;

/**
 *
 * @author rafael
 */
public class RegionImportIntegrationTest extends TestCase {
    
    private final String USER_AGENT = "Mozilla/5.0";
    private EntityManager entityManager;
    
    public RegionImportIntegrationTest(String testName) {
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
    }

    /**
     * Integration Test of Region Import
     */
    public void testRegionImport() {
        System.out.println("RegionImportIntegrationTest");
        String url = "http://localhost:8080/DeliverySystemRegionImport/webresources/import";
        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);

            String street = "Panzerplatz 12";
            String postal = "3333";
            String city = "vindobona";
            String externalKey = "RudiTheKing";
            String data = "<RegionData>" +
                "  <Region Key=\"" + externalKey + "\">" +
                "    <DisplayName>Ost Region</DisplayName>" +
                "    <Address>" +
                "      <Street>" + street + "</Street>" +
                "      <PostalCode>" + postal + "</PostalCode>" +
                "      <City>" + city + "</City>" +
                "    </Address>" +
                "  </Region> </RegionData>";
            
            // Send post request
            con.setDoOutput(true);
            con.setRequestProperty ( "Content-Type", "text/xml" );
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(data);
            wr.flush();
            wr.close();
 
            // receiving answer is important, otherwise the server would do nothing
            con.getResponseCode();
            con.getResponseMessage();
            
            DeliveryRegionRepository repo = new DeliveryRegionRepositoryDB(entityManager);
            DeliveryRegion delreg = repo.getByExternalId(externalKey);
            String resultKey = delreg.getExternal_id();
            
            //clean up
            TestMethod_Remove(delreg);
            
            // assert
            assertEquals(resultKey, externalKey);
        }
        catch (IOException ex)
        {
           ex.printStackTrace();
           fail("Integration  test failed because of IO operations");
        } catch (RepositoryException ex) {
            ex.printStackTrace();
            fail("Integration test failed because could not retrieve DeliveryRegion by ExternalId");
        }
     }
    
    /**
     * Integration Test of Region Import
     */
    public void testRegionImportWrongSyntax() {
        System.out.println("RegionImportWrongSyntax");
        String url = "http://localhost:8080/DeliverySystemRegionImport/webresources/import";
        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);

            String street = "Panzerplatz 12";
            String postal = "3333";
            String city = "vindobona";
            String externalKey = "RudiTheKing";
            String data = "<RegionFailData>" + // NOTE: this is the wrong root element
                "  <Region Key=\"" + externalKey + "\">" +
                "    <DisplayName>Ost Region</DisplayName>" +
                "    <Address>" +
                "      <Street>" + street + "</Street>" +
                "      <PostalCode>" + postal + "</PostalCode>" +
                "      <City>" + city + "</City>" +
                "    </Address>" +
                "  </Region> </RegionFailData>";
            
            // Send post request
            con.setDoOutput(true);
            con.setRequestProperty ( "Content-Type", "text/xml" );
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(data);
            wr.flush();
            wr.close();
 
            // receiving answer is important, otherwise the server would do nothing
            int responseCode = con.getResponseCode();
            
            // assert bad request
            assertEquals(responseCode, 400);
        }
        catch (IOException ex)
        {
           ex.printStackTrace();
           fail("Integration  test failed because of IO operations");
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
}
