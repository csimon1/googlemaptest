/**
 * 
 */
package com.csimon.google.api;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Charly
 * 
 */
class CoordinateSaxHandler extends DefaultHandler {

    private boolean getLocation;
    private boolean getLat;
    private boolean getLng;
    private Coordinate coord;

    /**
     * 
     */
    public CoordinateSaxHandler() {
        coord = new Coordinate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
     * java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("location")) {
            getLocation = true;
        }

        if (getLocation) {
            if (qName.equals("lat")) {
                getLat = true;
            } else if (qName.equals("lng")) {
                getLng = true;
            }
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("location")) {
            getLocation = false;
        }

        if (qName.equals("lat")) {
            getLat = false;
        } else if (qName.equals("lng")) {
            getLng = false;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (getLocation) {

            String value = new String(ch, start, length);

            if (getLat) {
                this.coord.setLatitude(Double.parseDouble(value));
                System.out.println("Coordinate handler : lat " + value);
            } else if (getLng) {
                this.coord.setLongitude(Double.parseDouble(value));
                System.out.println("Coordinate handler : lat " + value);
            }
        }
    }

    /**
     * @return
     */
    public Coordinate getCoordinates() {
        // TODO Auto-generated method stub
        return this.coord;
    }

}
