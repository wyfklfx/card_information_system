package org.studentcard.database.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zhou Shengyun <GGGZ-1101-28@Live.cn>
 */
@Entity
@Table(name = "StudentCard", catalog = "StudentCardSystemDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentCard.findAll", query = "SELECT s FROM StudentCard s"),
    @NamedQuery(name = "StudentCard.findByStudentID", query = "SELECT s FROM StudentCard s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "StudentCard.findByStudentCardID", query = "SELECT s FROM StudentCard s WHERE s.studentCardID = :studentCardID"),
    @NamedQuery(name = "StudentCard.findByBalance", query = "SELECT s FROM StudentCard s WHERE s.balance = :balance")})
public class StudentCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StudentID")
    private Integer studentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "StudentCardID")
    private String studentCardID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Balance")
    private float balance;
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Student student;

    public StudentCard() {
    }

    public StudentCard(Integer studentID) {
        this.studentID = studentID;
    }

    public StudentCard(Integer studentID, String studentCardID, float balance) {
        this.studentID = studentID;
        this.studentCardID = studentCardID;
        this.balance = balance;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentCardID() {
        return studentCardID;
    }

    public void setStudentCardID(String studentCardID) {
        this.studentCardID = studentCardID;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
        if (!(object instanceof StudentCard)) {
            return false;
        }
        StudentCard other = (StudentCard) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.StudentCard[ studentID=" + studentID + " ]";
    }
    
}
