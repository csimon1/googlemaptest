/**
 * 
 */
package com.csimon.google.api;


/**
 * @author Charly
 * 
 */
public class Coordinate {

    private Double lng;
    private Double lat;

    /**
     * 
     */
    public Coordinate() {
        lng = new Double(0);
        lat = new Double(0);
    }

    public Coordinate(double longitude, double latitude) {
        lng = new Double(longitude);
        lat = new Double(latitude);
    }

    public Coordinate(Coordinate coord) {
        lng = coord.lng;
        lat = coord.lat;
    }

    public double getLongitude() {
        return lng;
    }

    public void setLongitude(double longitude) {
        this.lng = longitude;
    }

    public double getLatitude() {
        return lat;
    }

    public void setLatitude(double latitude) {
        this.lat = latitude;
    }

}
