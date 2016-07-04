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
public class LossReportRecordPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "StudentID")
    private int studentID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LossReportTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lossReportTime;

    public LossReportRecordPK() {
    }

    public LossReportRecordPK(int studentID, Date lossReportTime) {
        this.studentID = studentID;
        this.lossReportTime = lossReportTime;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Date getLossReportTime() {
        return lossReportTime;
    }

    public void setLossReportTime(Date lossReportTime) {
        this.lossReportTime = lossReportTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentID;
        hash += (lossReportTime != null ? lossReportTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LossReportRecordPK)) {
            return false;
        }
        LossReportRecordPK other = (LossReportRecordPK) object;
        if (this.studentID != other.studentID) {
            return false;
        }
        if ((this.lossReportTime == null && other.lossReportTime != null) || (this.lossReportTime != null && !this.lossReportTime.equals(other.lossReportTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.LossReportRecordPK[ studentID=" + studentID + ", lossReportTime=" + lossReportTime + " ]";
    }
    
}
