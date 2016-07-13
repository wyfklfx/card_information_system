package org.studentcard.database.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Seller", catalog = "StudentCardSystemDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s"),
    @NamedQuery(name = "Seller.findBySellerID", query = "SELECT s FROM Seller s WHERE s.sellerID = :sellerID"),
    @NamedQuery(name = "Seller.findByPassword", query = "SELECT s FROM Seller s WHERE s.password = :password"),
    @NamedQuery(name = "Seller.findByName", query = "SELECT s FROM Seller s WHERE s.name = :name")})
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SellerID")
    private Integer sellerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerID")
    private List<ShopInfo> shopInfoList;

    public Seller() {
    }

    public Seller(Integer sellerID) {
        this.sellerID = sellerID;
    } 

    public Seller(Integer sellerID, String password, String name) {
        this.sellerID = sellerID;
        this.password = password;
        this.name = name;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<ShopInfo> getShopInfoList() {
        return shopInfoList;
    }

    public void setShopInfoList(List<ShopInfo> shopInfoList) {
        this.shopInfoList = shopInfoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellerID != null ? sellerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seller)) {
            return false;
        }
        Seller other = (Seller) object;
        if ((this.sellerID == null && other.sellerID != null) || (this.sellerID != null && !this.sellerID.equals(other.sellerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.studentcard.database.model.Seller[ sellerID=" + sellerID + " ]";
    }
    
}
