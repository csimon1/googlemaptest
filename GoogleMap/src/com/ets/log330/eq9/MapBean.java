/**
 * 
 */
package com.ets.log330.eq9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.ets.log330.eq9.EJBContext.EJBFactory;

/**
 * @author Charly
 * 
 */
@ManagedBean
@SessionScoped
public class MapBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7722842752634855408L;

    private MapModel advancedModel;

    private Marker marker;

    private int zoom;
    private LatLng center;

    private List<Adress> addedAdresses;

    private Adress selectedAdress;

    private PlacesService placesService;

    /**
     * 
     */
    public MapBean() {
        advancedModel = new DefaultMapModel();

        placesService = (PlacesService) EJBFactory.getEjbImplementation(PlacesService.class);

        center = new LatLng(45.5086699, -73.5539925);
        zoom = 7;

        this.addedAdresses = new ArrayList<Adress>();
    }

    public MapModel getAdvancedModel() {
        return advancedModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

    public Marker getMarker() {
        return marker;
    }

    public void removeSelectedAdress() {

        this.addedAdresses.remove(this.selectedAdress);

        this.advancedModel = new DefaultMapModel();

        for (Adress ad : this.addedAdresses) {
            this.addAdressToMapModel(ad);
        }
    }

    public Adress getSelectedAdress() {
        return selectedAdress;
    }

    public void setSelectedAdress(Adress adress) {
        this.selectedAdress = adress;
    }

    public void onStateChange(StateChangeEvent event) {
        this.zoom = event.getZoomLevel();
        this.center = event.getCenter();

        System.out.println("Zoom Level " + zoom);
        System.out.println("center " + center.toString());

    }

    private Adress adresse = null;

    public List<Adress> completeAdresse(String query) {
        // https://maps.googleapis.com/maps/api/place/autocomplete/json?input=Vict&types=geocode&language=fr&sensor=true&key=AIzaSyBuDtl3TlPSgDpqaHZ_YfrbCVQfYEcejlc

        List<Adress> adresses = placesService.findPlaces(query);

        return adresses;
    }

    public Adress getAdresse() {
        return adresse;
    }

    public void setAdresse(Adress adresse) {
        this.adresse = adresse;
    }

    public void handleSelectAdresse(SelectEvent event) {

        this.addAdress((Adress) event.getObject());

    }

    private void addAdress(Adress adress) {
        this.addAdressToMapModel(adress);
        this.addedAdresses.add(adress);

        this.adresse = adress;
    }

    /**
     * @param adresse
     * 
     */
    private void addAdressToMapModel(Adress adresse) {

        Adress coord = placesService.getCoordinates(adresse);

        LatLng coord1 = new LatLng(coord.getCoordinate().getLatitude(), coord.getCoordinate().getLongitude());

        advancedModel.addOverlay(new Marker(coord1, adresse.getAdress()));
    }

    public String getCenterMap() {

        return center.getLat() + ", " + center.getLng();
    }

    public int getZoom() {
        return zoom;
    }

    public List<Adress> getAdresses() {
        return addedAdresses;
    }
}
