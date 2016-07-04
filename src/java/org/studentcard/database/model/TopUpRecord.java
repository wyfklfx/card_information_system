package org.studentcard.database.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zhou Shengyun <GGGZ-1101-28@Live.cn>
 */
@Entity
@Table(name = "TopUpRecord", catalog = "StudentCardSystemDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TopUpRecord.findAll", query = "SELECT t FROM TopUpRecord t"),
    @NamedQuery(name = "TopUpRecord.findByStudentID", query = "SELECT t FROM TopUpRecord t WHERE t.topUpRecordPK.studentID = :studentID"),
    @NamedQuery(name = "TopUpRecord.findByTopUpTime", query = "SELECT t FROM TopUpRecord t WHERE t.topUpRecordPK.topUpTime = :topUpTime"),
    @NamedQuery(name = "TopUpRecord.findByBalance", query = "SELECT t FROM TopUpRecord t WHERE t.balance = :balance")})
public class TopUpRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TopUpRecordPK topUpRecordPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Balance")
    private float balance;
    @Lob
    @Size(max = 65535)
    @Column(name = "TopUpInfo")
    private String topUpInfo;
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public TopUpRecord() {
    }

    public TopUpRecord(TopUpRecordPK topUpRecordPK) {
        this.topUpRecordPK = topUpRecordPK;
    }

    public TopUpRecord(TopUpRecordPK topUpRecordPK, float balance) {
        this.topUpRecordPK = topUpRecordPK;
        this.balance = balance;
    }

    public TopUpRecord(int studentID, Date topUpTime) {
        this.topUpRecordPK = new TopUpRecordPK(studentID, topUpTime);
    }

    public TopUpRecordPK getTopUpRecordPK() {
        return topUpRecordPK;
    }

    public void setTopUpRecordPK(TopUpRecordPK topUpRecordPK) {
        this.topUpRecordPK = topUpRecordPK;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getTopUpInfo() {
        return topUpInfo;
    }

    public void setTopUpInfo(String topUpInfo) {
        this.topUpInfo = topUpInfo;
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
        hash += (topUpRecordPK != null ? topUpRecordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TopUpRecord)) {
            return false;
        }
        TopUpRecord other = (TopUpRecord) object;
        if ((this.topUpRecordPK == null && other.topUpRecordPK != null) || (this.topUpRecordPK != null && !this.topUpRecordPK.equals(other.topUpRecordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.TopUpRecord[ topUpRecordPK=" + topUpRecordPK + " ]";
    }
    
}
