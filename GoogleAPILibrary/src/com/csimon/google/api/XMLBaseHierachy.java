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
public class XMLBaseHierachy extends DefaultHandler {

    private int nbTab;

    /**
     * 
     */
    public XMLBaseHierachy() {
        nbTab = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
     * java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        for (int i = nbTab; i > 0; --i) {
            System.out.print("\t");
        }

        System.out.print("<" + qName);

        for (int i = 0; i < attributes.getLength(); ++i) {
            System.out.print(" " + attributes.getQName(i) + "=" + attributes.getValue(i));
        }

        System.out.print(">");

        ++nbTab;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        System.out.print(new String(ch, start, length));

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        --nbTab;
        System.out.print("</" + qName + ">");

    }

}
