/**
 * 
 */
package com.ets.log330.eq9;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Charly
 * 
 */
@Local
public interface PlacesService {

    List<Adress> findPlaces(String startingWith);

    /**
     * @param adresse
     */
    Adress getCoordinates(Adress adresse);

}
