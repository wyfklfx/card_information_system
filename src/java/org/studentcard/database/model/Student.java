package org.studentcard.database.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "Student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentID", query = "SELECT s FROM Student s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StudentID")
    private Integer studentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Name")
    private String name;
    
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "student")
    private StudentCard studentCardInfo;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<ConsumeRecord> consumeRecordList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<LossReportRecord> lossReportRecordList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<RefundRecord> refundRecordList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<TopUpRecord> topUpRecordList;
            
    public Student() {
    }

    public Student(Integer studentID) {
        this.studentID = studentID;
    }

    public Student(Integer studentID, String password, String name) {
        this.studentID = studentID;
        this.password = password;
        this.name = name;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.model.Student[ studentID=" + studentID + " ]";
    }

    public List<ConsumeRecord> getConsumeRecordList() {
        return consumeRecordList;
    }

    public List<LossReportRecord> getLossReportRecordList() {
        return lossReportRecordList;
    }

    public List<RefundRecord> getRefundRecordList() {
        return refundRecordList;
    }

    public List<TopUpRecord> getTopUpRecordList() {
        return topUpRecordList;
    }

    public StudentCard getStudentCardInfo(){
        return studentCardInfo;
    }
    /*public List<LossReportRecord> getLossRecordList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
