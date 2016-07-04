package org.studentcard.database.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Zhou Shengyun <GGGZ-1101-28@Live.cn>
 */
@Embeddable
public class TopUpRecordPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "StudentID")
    private int studentID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TopUpTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date topUpTime;

    public TopUpRecordPK() {
    }

    public TopUpRecordPK(int studentID, Date topUpTime) {
        this.studentID = studentID;
        this.topUpTime = topUpTime;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Date getTopUpTime() {
        return topUpTime;
    }

    public void setTopUpTime(Date topUpTime) {
        this.topUpTime = topUpTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentID;
        hash += (topUpTime != null ? topUpTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TopUpRecordPK)) {
            return false;
        }
        TopUpRecordPK other = (TopUpRecordPK) object;
        if (this.studentID != other.studentID) {
            return false;
        }
        if ((this.topUpTime == null && other.topUpTime != null) || (this.topUpTime != null && !this.topUpTime.equals(other.topUpTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.TopUpRecordPK[ studentID=" + studentID + ", topUpTime=" + topUpTime + " ]";
    }
    
}
