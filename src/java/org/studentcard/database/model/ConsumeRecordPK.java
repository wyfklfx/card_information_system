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
public class ConsumeRecordPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "StudentID")
    private int studentID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ConsumeTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date consumeTime;

    public ConsumeRecordPK() {
    }

    public ConsumeRecordPK(int studentID, Date consumeTime) {
        this.studentID = studentID;
        this.consumeTime = consumeTime;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentID;
        hash += (consumeTime != null ? consumeTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumeRecordPK)) {
            return false;
        }
        ConsumeRecordPK other = (ConsumeRecordPK) object;
        if (this.studentID != other.studentID) {
            return false;
        }
        if ((this.consumeTime == null && other.consumeTime != null) || (this.consumeTime != null && !this.consumeTime.equals(other.consumeTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.ConsumeRecordPK[ studentID=" + studentID + ", consumeTime=" + consumeTime + " ]";
    }
    
}
