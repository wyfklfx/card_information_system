package org.studentcard.bundle;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;

/**
 *
 * @author buptsse-zero
 */
public class BundleUtil {
    public static ResourceBundle getResourceBundle(ServletRequest request){
        return ResourceBundle.getBundle("org.studentcard.bundle.string", request.getLocale());
    }
    
    public static String getString(ServletRequest request, String key){
        ResourceBundle bundle = getResourceBundle(request);
        try{
            return bundle.getString(key);
        }catch(MissingResourceException mre){
            mre.printStackTrace();
            return "";
        }
    }
    
    public static String getString(FacesContext context, String key){
        return getString((ServletRequest)context.getExternalContext().getRequest(), key);
    }
}
