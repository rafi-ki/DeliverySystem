/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package defines;

/**
 *
 * @author dominik,rafael
 */
public class GeoLocation {
    private double longitude;
    private double latitude;
    
    public GeoLocation (double longitudein, double latitudein){
        this.latitude=latitudein;
        this.longitude=longitudein;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
