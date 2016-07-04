package org.studentcard.database.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zhou Shengyun <GGGZ-1101-28@Live.cn>
 */
@Entity
@Table(name = "RefundRecord", catalog = "StudentCardSystemDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefundRecord.findAll", query = "SELECT r FROM RefundRecord r"),
    @NamedQuery(name = "RefundRecord.findByStudentID", query = "SELECT r FROM RefundRecord r WHERE r.refundRecordPK.studentID = :studentID"),
    @NamedQuery(name = "RefundRecord.findByRefundTime", query = "SELECT r FROM RefundRecord r WHERE r.refundRecordPK.refundTime = :refundTime")})
public class RefundRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RefundRecordPK refundRecordPK;
    @Lob
    @Size(max = 65535)
    @Column(name = "RefundInfo")
    private String refundInfo;
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public RefundRecord() {
    }

    public RefundRecord(RefundRecordPK refundRecordPK) {
        this.refundRecordPK = refundRecordPK;
    }

    public RefundRecord(int studentID, Date refundTime) {
        this.refundRecordPK = new RefundRecordPK(studentID, refundTime);
    }

    public RefundRecordPK getRefundRecordPK() {
        return refundRecordPK;
    }

    public void setRefundRecordPK(RefundRecordPK refundRecordPK) {
        this.refundRecordPK = refundRecordPK;
    }

    public String getRefundInfo() {
        return refundInfo;
    }

    public void setRefundInfo(String refundInfo) {
        this.refundInfo = refundInfo;
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
        hash += (refundRecordPK != null ? refundRecordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefundRecord)) {
            return false;
        }
        RefundRecord other = (RefundRecord) object;
        if ((this.refundRecordPK == null && other.refundRecordPK != null) || (this.refundRecordPK != null && !this.refundRecordPK.equals(other.refundRecordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.RefundRecord[ refundRecordPK=" + refundRecordPK + " ]";
    }
    
}
