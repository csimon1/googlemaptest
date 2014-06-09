/**
 * 
 */
package com.ets.log330.eq9.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.ets.log330.eq9.Adress;
import com.ets.log330.eq9.PlacesService;
import com.ets.log330.eq9.EJBContext.EJBFactory;

/**
 * @author Charly
 * 
 */
@FacesConverter(forClass = Adress.class)
public class AdresseConverter implements Converter {

    @Inject
    PlacesService placeService;

    /**
     * 
     */
    public AdresseConverter() {
        placeService = (PlacesService) EJBFactory.getEjbImplementation(PlacesService.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
     * , javax.faces.component.UIComponent, java.lang.String)
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        List<Adress> ads = placeService.findPlaces(value);

        return ads.get(0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
     * , javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null && value instanceof Adress) {
            return ((Adress) value).getAdress();
        }

        return " invalid adress";
    }

}
