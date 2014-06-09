/**
 * 
 */
package com.csimon.google.api;

/**
 * @author Charly
 * 
 */
public class Adress {

    private String adress;
    private Coordinate coord;

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress
     *            the adress to set
     */
    protected void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the coord
     */
    public Coordinate getCoord() {
        return coord;
    }

    /**
     * @param coord
     *            the coord to set
     */
    protected void setCoord(Coordinate coord) {
        this.coord = coord;
    }

}
