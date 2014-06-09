/**
 * 
 */
package com.ets.log330.eq9;

/**
 * @author Charly
 * 
 */
public class AdressEntity implements Adress {

    private String adress;
    private CoordinateEntity coord;

    /*
     * (non-Javadoc)
     * 
     * @see com.ets.log330.eq9.Adress#getAdress()
     */
    @Override
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ets.log330.eq9.Adress#getCoordinate()
     */
    @Override
    public Coordinate getCoordinate() {
        return coord;
    }

    public void setCoordinate(CoordinateEntity coord) {
        this.coord = coord;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return true;

        if (!(obj instanceof AdressEntity))
            return false;

        AdressEntity o = (AdressEntity) obj;

        if (this.adress != null && this.adress.equals(o.adress))
            if (this.coord != null && this.coord.equals(o.coord))
                return true;

        return false;

    }

}
