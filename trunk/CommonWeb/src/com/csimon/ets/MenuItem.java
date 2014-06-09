/**
 * 
 */
package com.csimon.ets;

/**
 * @author Charly
 * 
 */
public class MenuItem {

    private String name;
    private String url;
    private String icon;
    private boolean rendered;

    /**
     * 
     */
    public MenuItem() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
    public MenuItem(String name, String url, String icon, boolean rendered) {
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.rendered = rendered;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     *            the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the rendered
     */
    public boolean isRendered() {
        return rendered;
    }

    /**
     * @param rendered
     *            the rendered to set
     */
    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }
}
