package org.studentcard.model;

import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.studentcard.bundle.BundleUtil;
import org.studentcard.control.AccountControl;
import org.studentcard.database.control.SystemDBHelperBean;

/**
 *
 * @author Zhou Shengyun <GGGZ-1101-28@Live.cn>
 */
@Named(value = "userBean")
@ViewScoped
public class UserBean implements Serializable {
    private String userID;
    private String password;
    @EJB
    private SystemDBHelperBean dbHelperBean;
            
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public int login(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            int result = AccountControl.login(dbHelperBean, Integer.valueOf(userID), password);
            if(result == 0)
               context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, BundleUtil.getString(context, "TipUserOrPasswordIncorrect"),""));
            return result;
        }catch(NumberFormatException nfe){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, BundleUtil.getString(context, "TipUserOrPasswordIncorrect"),""));
        }catch(Exception e){
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, BundleUtil.getString(context, "TipServerInternalError"),""));
        }
        return 0;
    }
    
    public void logout(){
        AccountControl.logout();
    }
}
