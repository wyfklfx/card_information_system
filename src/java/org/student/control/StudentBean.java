package org.student.control;

import com.sun.org.apache.bcel.internal.Constants;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.studentcard.control.AccountControl;
import org.studentcard.database.control.SystemDBHelperBean;
import org.studentcard.database.model.ConsumeRecord;
import org.studentcard.database.model.LossReportRecord;
import org.studentcard.database.model.RefundRecord;
import org.studentcard.database.model.Student;
import org.studentcard.database.model.StudentCard;
import org.studentcard.database.model.TopUpRecord;

/**
 *
 * @author Lenovo
 */
@ManagedBean(name = "studentBean")
@ViewScoped
public class StudentBean implements Serializable {
    @EJB
    private SystemDBHelperBean systemDBHelperBean;
    private Student student;
    
    @PostConstruct
    public void init() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        student = (Student)session.getAttribute(AccountControl.SESSION_ATTR_USER);
        student = (Student)systemDBHelperBean.find(Student.class, student.getStudentID());
    }
    
    public StudentCard getStudentCardInfo(){
        return student.getStudentCardInfo();
    }
    
    public List<ConsumeRecord> getConsumeRecordList(){
        return student.getConsumeRecordList();
    }
    public List<RefundRecord> getRefundRecordList(){
        return student.getRefundRecordList();
    }
    public List<TopUpRecord> getTopUpRecordList(){
        return student.getTopUpRecordList();
    }
    public List<LossReportRecord> getLossRecordList(){
        return student.getLossReportRecordList();
    }
}
