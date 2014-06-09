/**
 * 
 */
package com.ets.log330.eq9;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.csimon.google.api.APIFunctions;
import com.csimon.google.api.Coordinate;

/**
 * @author Charly
 * 
 */
@Stateless
public class PlacesServiceImpl implements PlacesService {

    private Logger log = Logger.getLogger(PlacesService.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.ets.log330.eq9.PlacesService#findPlaces(java.lang.String)
     */
    @Override
    public List<Adress> findPlaces(String startingWith) {

        APIFunctions api = new APIFunctions();

        List<AdressEntity> adress = convertAdress(api.findAdress(startingWith));

        // CoordinateEntity coord;
        // for (AdressEntity ad : adress) {
        // coord = (CoordinateEntity) this.getCoordinates(ad.getAdress());
        // ad.setCoordinate(coord);
        // }

        return new ArrayList<Adress>(adress);

    }

    /**
     * @param findAdress
     * @return
     */
    private List<AdressEntity> convertAdress(List<String> adresses) {
        List<AdressEntity> adresseslst = new ArrayList<AdressEntity>();
        for (String adString : adresses) {
            AdressEntity ad = new AdressEntity();
            ad.setAdress(adString);
            adresseslst.add(ad);
        }

        return adresseslst;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ets.log330.eq9.PlacesService#getCoordinates(java.lang.String)
     */
    @Override
    public Adress getCoordinates(Adress adresse) {
        log.info("search coordinate for " + adresse);

        APIFunctions api = new APIFunctions();

        AdressEntity ad = new AdressEntity();

        CoordinateEntity coord = new CoordinateEntity();
        Coordinate c = api.getCoordinates(adresse.getAdress());

        if (c != null) {
            coord.setLatitude(c.getLatitude());
            coord.setLongitude(c.getLongitude());
            log.info("coordinate are : lat " + c.getLatitude() + " - lng " + c.getLongitude());
        } else {
            log.info("coordinate are null");
        }

        ad.setCoordinate(coord);

        return ad;

    }
}
