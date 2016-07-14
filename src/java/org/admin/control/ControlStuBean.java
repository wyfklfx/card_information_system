package org.admin.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.studentcard.database.control.SystemDBHelperBean;
import org.studentcard.database.model.LossReportRecord;
import org.studentcard.database.model.RefundRecord;
import org.studentcard.database.model.Student;
import org.studentcard.database.model.StudentCard;
import org.studentcard.database.model.TopUpRecord;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "controlStu")
@ViewScoped
public class ControlStuBean implements Serializable{

    /**
     * Creates a new instance of ControlStuBean
     */
    private int studentID;
    private String sstudentID;
    private Date topUpTime;
    private Date refundTime;
    private Date lossReportTime;
    private String smoney;
    private float money;
    private float balance;
    private String topUpInfo;
    private boolean isExist;
    private boolean alreadyFind;
    private StudentCard stuCard;
    private Student stu;
    private List<TopUpRecord> topups;
    private List<RefundRecord> refunds;
    private List<LossReportRecord> lossreports;

    
    
    @EJB
    private SystemDBHelperBean syshelp;
    public ControlStuBean() {
        isExist = alreadyFind = false;
        balance = money = 0;
    }
    public List<TopUpRecord> getTopups() {
        return topups;
    }

    public void setTopups(List<TopUpRecord> topups) {
        this.topups = topups;
    }
     public List<RefundRecord> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<RefundRecord> refunds) {
        this.refunds = refunds;
    }

    public List<LossReportRecord> getLossreports() {
        return lossreports;
    }

    public void setLossreports(List<LossReportRecord> lossreports) {
        this.lossreports = lossreports;
    }
    public int getStudentID(){
        return studentID;
    }
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    public String getSstudentID(){
        return sstudentID;
    }
    public void setSstudentID(String sstudentID){
        this.sstudentID = sstudentID;
        try{
            studentID = Integer.valueOf(sstudentID);
        }catch(NumberFormatException nfe){
            studentID = -1;
        }
    }
    public Date getTopUpTime(){
        return topUpTime;
    }
    public void setTopUpTime(Date topUpTime){
        this.topUpTime = topUpTime;
    }
    public Date getRefundTime(){
        return refundTime;
    }
    public void setRefundTime(Date refundTime){
        this.refundTime = refundTime;
    }
    public Date getLossReportTime(){
        return lossReportTime;
    }
    public void setLossReportTime(Date lossReportTime){
        this.lossReportTime = lossReportTime;
    }
    public String getSmoney(){
        return smoney;
    }
    public void setSmoney(String smoney){
        this.smoney = smoney;
        try{
            money = Float.valueOf(smoney);
        }catch(NumberFormatException nfe){
            money = 0;
        }
    }
    public float getMoney(){
        return money;
    }
    public void setMoney(float money){
        this.money = money;
    }
    public float getBalance(){
        return balance;
    }
    public void setBalance(float balance){
        this.balance = balance;
    }
    public String getTopUpInfo(){
         return topUpInfo;
    }
    public void setTopUpInfo(String topUpInfo){
        this.topUpInfo = topUpInfo;
    }
    public StudentCard getStuCard(){
        return stuCard;
    }
    public Student getStu(){
        return stu;
    }
    public void findStuAndCard(){
        if(studentID == -1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的学号必须是整数", ""));
            return;
        }
        stu = (Student)syshelp.find(Student.class, studentID);
        topups = stu.getTopUpRecordList();
        refunds = stu.getRefundRecordList();
        lossreports = stu.getLossReportRecordList();
        alreadyFind = true;
        if (stu != null){
            stuCard = (StudentCard)syshelp.find(StudentCard.class, studentID);
            if (stuCard != null){
                balance = stuCard.getBalance();
                isExist = true;
            }
        }
    }
    public void topUp(){
        if(studentID == -1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的学号必须是整数", ""));
            return;
        }
        if(money <= 0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的金额必须是大于0的实数", ""));
            return;
        }
        if (!alreadyFind)
            findStuAndCard();
        if(isExist){
            stuCard.setBalance(stuCard.getBalance() + money);
            syshelp.merge(stuCard);
            topUpTime = new Date();
            TopUpRecord newRecord = new TopUpRecord(studentID, topUpTime);
            newRecord.setBalance(money);
            syshelp.create(newRecord);
            stu = (Student)syshelp.find(Student.class, studentID);
            topups.add(newRecord);
        }
    }
    public void refund(){
        if(studentID == -1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的学号必须是整数", ""));
            return;
        }
        if(money <= 0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的金额必须是大于0的实数", ""));
            return;
        }
        if (!alreadyFind)
            findStuAndCard();
        if(isExist){
            float cardBalance = stuCard.getBalance();
            if (cardBalance >= money){
                stuCard.setBalance(stuCard.getBalance() - money);
                syshelp.merge(stuCard);
                refundTime = new Date();
                RefundRecord newRecord = new RefundRecord(studentID, refundTime);
               /// newRecord.setBalance(money);
                syshelp.create(newRecord);
                stu = (Student)syshelp.find(Student.class, studentID);
                refunds.add(newRecord);
            }
            else
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的金额不能超过卡中余额", ""));
        }
    }
    public void lossReport(){
        if(studentID == -1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的学号必须是整数", ""));
            return;
        }
       if (!alreadyFind)
            findStuAndCard();
        if(isExist){
            lossReportTime = new Date();
            LossReportRecord newRecord = new LossReportRecord(studentID, lossReportTime);
            newRecord.setPrevStudentCardID(stuCard.getStudentCardID());
            String newID = Integer.toString(studentID) + Long.toString(((System.currentTimeMillis())));
            newRecord.setLaterStudentCardID(newID);
            syshelp.create(newRecord);
            stuCard.setStudentCardID(newID);
            syshelp.merge(stuCard);
            stu = (Student)syshelp.find(Student.class, studentID);
            lossreports.add(newRecord);
        }
        else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "该学生未注册，挂失失败", ""));
    }
    public void studentRegister(){
        if(studentID == -1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的学号必须是整数", ""));
            return;
        }
        if (!alreadyFind)
            findStuAndCard();
        if(!isExist){
            stuCard = new StudentCard(studentID);
            stuCard.setStudentCardID( Integer.toString(studentID) + Long.toString(((System.currentTimeMillis()))));
            stuCard.setBalance(money);
            syshelp.create(stuCard);
            if (money > 0){
                topUpTime = new Date();
                TopUpRecord newRecord = new TopUpRecord(studentID, topUpTime);
                newRecord.setBalance(money);
                syshelp.create(newRecord);
                stu = (Student)syshelp.find(Student.class, studentID);
                topups.add(newRecord);
            }
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "该学生已注册", ""));
        }
    }
}
