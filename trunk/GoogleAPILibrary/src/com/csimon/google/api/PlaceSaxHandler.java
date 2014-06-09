/**
 * 
 */
package com.csimon.google.api;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Charly
 * 
 */
class PlaceSaxHandler extends DefaultHandler {

    private boolean getChars;
    private List<String> places;

    /**
     * 
     */
    public PlaceSaxHandler() {
        this.places = new ArrayList<String>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
     * java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("description")) {
            getChars = true;
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
        if (qName.equals("description")) {
            getChars = false;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (getChars) {
            this.places.add(new String(ch, start, length));
        }
    }

    /**
     * @return
     */
    public List<String> getPlaces() {
        // TODO Auto-generated method stub
        return new ArrayList<String>(places);
    }

}
