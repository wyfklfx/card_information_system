package org.studentcard.database.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zhou Shengyun <GGGZ-1101-28@Live.cn>
 */
@Entity
@Table(name = "ShopInfo", catalog = "StudentCardSystemDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShopInfo.findAll", query = "SELECT s FROM ShopInfo s"),
    @NamedQuery(name = "ShopInfo.findByShopName", query = "SELECT s FROM ShopInfo s WHERE s.shopName = :shopName"),
    @NamedQuery(name = "ShopInfo.findByShopID", query = "SELECT s FROM ShopInfo s WHERE s.shopID = :shopID")})
public class ShopInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ShopName")
    private String shopName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShopID")
    private Integer shopID;
    @JoinColumn(name = "OwnerID", referencedColumnName = "SellerID")
    @ManyToOne(optional = false)
    private Seller ownerID;
    @OneToMany(mappedBy = "shopID")
    private List<ConsumeRecord> consumeRecordList;

    public ShopInfo() {
    }

    public ShopInfo(Integer shopID) {
        this.shopID = shopID;
    }

    public ShopInfo(Integer shopID, String shopName) {
        this.shopID = shopID;
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopID() {
        return shopID;
    }

    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }

    public Seller getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Seller ownerID) {
        this.ownerID = ownerID;
    }

    @XmlTransient
    public List<ConsumeRecord> getConsumeRecordList() {
        return consumeRecordList;
    }

    public void setConsumeRecordList(List<ConsumeRecord> consumeRecordList) {
        this.consumeRecordList = consumeRecordList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopID != null ? shopID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopInfo)) {
            return false;
        }
        ShopInfo other = (ShopInfo) object;
        if ((this.shopID == null && other.shopID != null) || (this.shopID != null && !this.shopID.equals(other.shopID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.ShopInfo[ shopID=" + shopID + " ]";
    }
    
}
