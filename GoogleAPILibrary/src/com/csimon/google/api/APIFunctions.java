/**
 * 
 */
package com.csimon.google.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * @author Charly
 * 
 */
public class APIFunctions {

    private URL baseUrl;
    private String APIKey = "AIzaSyBuDtl3TlPSgDpqaHZ_YfrbCVQfYEcejlc";
    private String langage = "fr";

    public APIFunctions() {
        try {
            baseUrl = new URL("https://maps.googleapis.com/maps/api/");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Coordinate getCoordinates(String adress) {

        try {
            URL placeUrl = new URL(baseUrl, "geocode/xml?sensor=true&address=" + URLEncoder.encode(adress.replace(' ', '+'), "UTF-8"));

            System.out.println(placeUrl.toString());

            SAXParserFactory parserFact = SAXParserFactory.newInstance();
            SAXParser parser;

            parser = parserFact.newSAXParser();

            CoordinateSaxHandler handler = new CoordinateSaxHandler();

            parser.parse(placeUrl.openStream(), handler);

            System.out.println("xml parsed");

            return handler.getCoordinates();

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("coordinate null -> exception");
        return new Coordinate();

    }

    public List<String> findAdress(String startingWith) {

        try {
            URL placeUrl = new URL(baseUrl, "place/autocomplete/xml?types=geocode&language=" + langage + "&sensor=true&key=" + APIKey + "&input="
                    + URLEncoder.encode(startingWith.replace(' ', '+'), "UTF-8"));
            SAXParserFactory parserFact = SAXParserFactory.newInstance();
            SAXParser parser;

            parser = parserFact.newSAXParser();

            PlaceSaxHandler handler = new PlaceSaxHandler();

            parser.parse(placeUrl.openStream(), handler);

            return handler.getPlaces();

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new ArrayList<String>();

    }

}
