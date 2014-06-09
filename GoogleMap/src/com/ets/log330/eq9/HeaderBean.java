/**
 * 
 */
package com.ets.log330.eq9;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import com.csimon.ets.MenuItem;

/**
 * @author Charly
 * 
 */
@ManagedBean
public class HeaderBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2879248257643395412L;
    private MenuItem home;
    private MenuItem map;

    /**
     * 
     */
    public HeaderBean() {
        home = new MenuItem("Home", "/index.xhtml", "ui-icon-home", true);
        map = new MenuItem("Map", "/map.xhtml", "ui-icon-image", true);
    }

    public MenuItem getHome() {
        return home;
    }

    public MenuItem getMap() {
        return map;
    }
}
