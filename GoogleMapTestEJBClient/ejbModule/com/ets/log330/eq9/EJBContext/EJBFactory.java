/**
 * 
 */
package com.ets.log330.eq9.EJBContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Charly
 * 
 */
public final class EJBFactory {

    private static Context context;

    public static Object getEjbImplementation(Class<?> interfaceEjb) {

        try {

            if (context == null)
                context = new InitialContext();

            return context.lookup("java:app/GoogleMapTestEJB/" + interfaceEjb.getSimpleName() + "Impl");
        } catch (NamingException e) {
            e.printStackTrace();

            return null;
        }

    }
}
