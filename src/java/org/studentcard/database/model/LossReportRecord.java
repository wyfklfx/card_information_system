package org.studentcard.database.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "LossReportRecord", catalog = "StudentCardSystemDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LossReportRecord.findAll", query = "SELECT l FROM LossReportRecord l"),
    @NamedQuery(name = "LossReportRecord.findByStudentID", query = "SELECT l FROM LossReportRecord l WHERE l.lossReportRecordPK.studentID = :studentID"),
    @NamedQuery(name = "LossReportRecord.findByLossReportTime", query = "SELECT l FROM LossReportRecord l WHERE l.lossReportRecordPK.lossReportTime = :lossReportTime"),
    @NamedQuery(name = "LossReportRecord.findByPrevStudentCardID", query = "SELECT l FROM LossReportRecord l WHERE l.prevStudentCardID = :prevStudentCardID"),
    @NamedQuery(name = "LossReportRecord.findByLaterStudentCardID", query = "SELECT l FROM LossReportRecord l WHERE l.laterStudentCardID = :laterStudentCardID")})
public class LossReportRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LossReportRecordPK lossReportRecordPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PrevStudentCardID")
    private String prevStudentCardID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LaterStudentCardID")
    private String laterStudentCardID;
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public LossReportRecord() {
    }

    public LossReportRecord(LossReportRecordPK lossReportRecordPK) {
        this.lossReportRecordPK = lossReportRecordPK;
    }

    public LossReportRecord(LossReportRecordPK lossReportRecordPK, String prevStudentCardID, String laterStudentCardID) {
        this.lossReportRecordPK = lossReportRecordPK;
        this.prevStudentCardID = prevStudentCardID;
        this.laterStudentCardID = laterStudentCardID;
    }

    public LossReportRecord(int studentID, Date lossReportTime) {
        this.lossReportRecordPK = new LossReportRecordPK(studentID, lossReportTime);
    }

    public LossReportRecordPK getLossReportRecordPK() {
        return lossReportRecordPK;
    }

    public void setLossReportRecordPK(LossReportRecordPK lossReportRecordPK) {
        this.lossReportRecordPK = lossReportRecordPK;
    }

    public String getPrevStudentCardID() {
        return prevStudentCardID;
    }

    public void setPrevStudentCardID(String prevStudentCardID) {
        this.prevStudentCardID = prevStudentCardID;
    }

    public String getLaterStudentCardID() {
        return laterStudentCardID;
    }

    public void setLaterStudentCardID(String laterStudentCardID) {
        this.laterStudentCardID = laterStudentCardID;
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
        hash += (lossReportRecordPK != null ? lossReportRecordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LossReportRecord)) {
            return false;
        }
        LossReportRecord other = (LossReportRecord) object;
        if ((this.lossReportRecordPK == null && other.lossReportRecordPK != null) || (this.lossReportRecordPK != null && !this.lossReportRecordPK.equals(other.lossReportRecordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.LossReportRecord[ lossReportRecordPK=" + lossReportRecordPK + " ]";
    }
    
}
