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
@Table(name = "ConsumeRecord", catalog = "StudentCardSystemDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsumeRecord.findAll", query = "SELECT c FROM ConsumeRecord c"),
    @NamedQuery(name = "ConsumeRecord.findByStudentID", query = "SELECT c FROM ConsumeRecord c WHERE c.consumeRecordPK.studentID = :studentID"),
    @NamedQuery(name = "ConsumeRecord.findByConsumeTime", query = "SELECT c FROM ConsumeRecord c WHERE c.consumeRecordPK.consumeTime = :consumeTime"),
    @NamedQuery(name = "ConsumeRecord.findByBalance", query = "SELECT c FROM ConsumeRecord c WHERE c.balance = :balance")})
public class ConsumeRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsumeRecordPK consumeRecordPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Balance")
    private float balance;
    @Lob
    @Size(max = 65535)
    @Column(name = "ConsumeInfo")
    private String consumeInfo;
    @JoinColumn(name = "ShopID", referencedColumnName = "ShopID")
    @ManyToOne
    private ShopInfo shopID;
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public ConsumeRecord() {
    }

    public ConsumeRecord(ConsumeRecordPK consumeRecordPK) {
        this.consumeRecordPK = consumeRecordPK;
    }

    public ConsumeRecord(ConsumeRecordPK consumeRecordPK, float balance) {
        this.consumeRecordPK = consumeRecordPK;
        this.balance = balance;
    }

    public ConsumeRecord(int studentID, Date consumeTime) {
        this.consumeRecordPK = new ConsumeRecordPK(studentID, consumeTime);
    }

    public ConsumeRecordPK getConsumeRecordPK() {
        return consumeRecordPK;
    }

    public void setConsumeRecordPK(ConsumeRecordPK consumeRecordPK) {
        this.consumeRecordPK = consumeRecordPK;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getConsumeInfo() {
        return consumeInfo;
    }

    public void setConsumeInfo(String consumeInfo) {
        this.consumeInfo = consumeInfo;
    }

    public ShopInfo getShopID() {
        return shopID;
    }

    public void setShopID(ShopInfo shopID) {
        this.shopID = shopID;
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
        hash += (consumeRecordPK != null ? consumeRecordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumeRecord)) {
            return false;
        }
        ConsumeRecord other = (ConsumeRecord) object;
        if ((this.consumeRecordPK == null && other.consumeRecordPK != null) || (this.consumeRecordPK != null && !this.consumeRecordPK.equals(other.consumeRecordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.ConsumeRecord[ consumeRecordPK=" + consumeRecordPK + " ]";
    }
    
}
