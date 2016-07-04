package org.studentcard.control;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.studentcard.database.control.SystemDBHelperBean;
import org.studentcard.database.model.Admin;
import org.studentcard.database.model.Seller;
import org.studentcard.database.model.Student;

/**
 *
 * @author Zhou Shengyun <GGGZ-1101-28@Live.cn>
 */
public class AccountControl {
    public static final int ACCOUNT_CATEGORY_STUDENT = 1;
    public static final int ACCOUNT_CATEGORY_SELLER = 2;
    public static final int ACCOUNT_CATEGORY_ADMIN = 3;
    
    public static final String SESSION_ATTR_USER = "user";
    
    private static Student findStudent(SystemDBHelperBean dbBean, int userID){
        return (Student)dbBean.find(Student.class, userID);
    }
    
    private static Seller findSeller(SystemDBHelperBean dbBean, int userID){
        return (Seller)dbBean.find(Seller.class, userID);
    }
    
    private static Admin findAdmin(SystemDBHelperBean dbBean, int userID){
        return (Admin)dbBean.find(Admin.class, userID);
    }
    
    public static int login(SystemDBHelperBean dbBean, int userID, String password){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Student s = findStudent(dbBean, userID);
        if(s != null){
            if(s.getPassword().equals(password)){
                session.setAttribute(SESSION_ATTR_USER, s);
                return ACCOUNT_CATEGORY_STUDENT;
            }
            return 0;
        }
        Seller se = findSeller(dbBean, userID);
        if(se != null){
            if(se.getPassword().equals(password)){
                session.setAttribute(SESSION_ATTR_USER, se);
                return ACCOUNT_CATEGORY_SELLER;
            }
            return 0;
        }
        Admin admin = findAdmin(dbBean, userID);
        if(admin != null){
            if(admin.getPassword().equals(password)){
                session.setAttribute(SESSION_ATTR_USER, admin);
                return ACCOUNT_CATEGORY_ADMIN;
            }
        }
        return 0;
    }
    
    public static void logout(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.removeAttribute(SESSION_ATTR_USER);
    }
}
