package org.admin.control;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.studentcard.control.AccountControl;
import org.studentcard.database.control.SystemDBHelperBean;
import org.studentcard.database.model.Admin;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "adminBean")
@ViewScoped
public class AdminBean implements Serializable {

    /**
     * Creates a new instance of AdminBean
     */
    
    private Admin admin;
    private String oldPassword;
    private String newPassword;
    @EJB
    private SystemDBHelperBean syshelp;
    public AdminBean() {
       
    }
    @PostConstruct
    public void init(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        admin = (Admin)session.getAttribute(AccountControl.SESSION_ATTR_USER);
        admin = (Admin)syshelp.find(Admin.class, admin.getAdminID());
   }
    public Admin getAdmin(){
        return admin;
    } 
    public String getOldPassword(){
        return oldPassword;
    }
    public String getNewPassword(){
        return newPassword;
    }
    public void setOldPassword(String oldPassword){
        this.oldPassword = oldPassword;
    }
    public void setNewPassword(String newPassword){
        this.newPassword = newPassword;
    }
    
    public void setPassword(){
        if (oldPassword.equals(admin.getPassword())){
            admin.setPassword(newPassword);
            syshelp.merge(admin);
        }
        oldPassword = "";
        newPassword = "";
    }
}
