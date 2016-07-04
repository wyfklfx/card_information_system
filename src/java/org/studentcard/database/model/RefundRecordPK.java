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
public class RefundRecordPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "StudentID")
    private int studentID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RefundTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date refundTime;

    public RefundRecordPK() {
    }

    public RefundRecordPK(int studentID, Date refundTime) {
        this.studentID = studentID;
        this.refundTime = refundTime;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentID;
        hash += (refundTime != null ? refundTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefundRecordPK)) {
            return false;
        }
        RefundRecordPK other = (RefundRecordPK) object;
        if (this.studentID != other.studentID) {
            return false;
        }
        if ((this.refundTime == null && other.refundTime != null) || (this.refundTime != null && !this.refundTime.equals(other.refundTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.RefundRecordPK[ studentID=" + studentID + ", refundTime=" + refundTime + " ]";
    }
    
}
