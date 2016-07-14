package org.admin.control;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.studentcard.database.control.SystemDBHelperBean;
import org.studentcard.database.model.Seller;
import org.studentcard.database.model.ShopInfo;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "controlSeller")
@ViewScoped
public class ControlSellerBean implements Serializable{

    /**
     * Creates a new instance of ControlSellerBean
     */
    private int sellerID;
    private String ssellerID;
    private String shopName;
    private Seller seller;
    private String sellerName;
    private boolean isExist;
    private boolean alreadyFind;
    private List<ShopInfo> shopinfos;

   
    @EJB
    private SystemDBHelperBean syshelp;
    public ControlSellerBean() {
        isExist = alreadyFind = false;
    }
    public List<ShopInfo> getShopinfos() {
        return shopinfos;
    }

    public void setShopinfos(List<ShopInfo> shopinfos) {
        this.shopinfos = shopinfos;
    }
    public String getSsellerID(){
        return ssellerID;
    }
    public void setSsellerID(String ssellerID){
        this.ssellerID = ssellerID; 
         try{
            sellerID = Integer.valueOf(ssellerID);
        }catch(NumberFormatException nfe){
            sellerID = -1;
        }
    }
    public int getSellerID(){
        return sellerID;
    }
    public void setSellerID(int sellerID){
        this.sellerID = sellerID;
    }
    public String getShopName(){
        return shopName;
    }
    public void setShopName(String name){
        shopName = name;
    }
    public String getSellerName(){
        return sellerName;
    }
    public void setSellerName(String sellerName){
        this.sellerName = sellerName;
    }
    public Seller getSeller(){
        return seller;
    }
    public void findSeller(){
        if(sellerID == -1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的店主号必须是整数", ""));
            return;
        }
        seller = (Seller)syshelp.find(Seller.class, sellerID);
        if (seller != null){
            isExist = true;
            sellerName = seller.getName();
            shopinfos = seller.getShopInfoList();
        }
        alreadyFind = true;
    }
    public void shopRegister(){
        if(sellerID == -1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的店主号必须是整数", ""));
            return;
        }
        if (!alreadyFind)
            findSeller();
        if(isExist){
            if(shopName == null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "店铺名不能为空", ""));
                return;
            }
            ShopInfo newshop = new ShopInfo(syshelp.count(ShopInfo.class) + 1, shopName);
            newshop.setOwnerID(seller);
            syshelp.create(newshop);
            seller = (Seller)syshelp.find(Seller.class, sellerID);
            shopinfos.add(newshop);
            sellerName = seller.getName();
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "店主号不存在，注册失败", ""));
        }
    }
    public void sellerRegister(){
            if(sellerName == null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "店主名不能为空", ""));
                return;
            }
            shopinfos.clear();
            sellerID = syshelp.count(Seller.class) + 1;
            ssellerID = Integer.toString(sellerID);
            seller = new Seller(sellerID, "123456", sellerName); 
            syshelp.create(seller);
            if (shopName != null){
                ShopInfo newshop = new ShopInfo(syshelp.count(ShopInfo.class) + 1, shopName);
                newshop.setOwnerID(seller);
                syshelp.create(newshop);
                seller = (Seller)syshelp.find(Seller.class, sellerID);
                shopinfos.add(newshop);
            }
    }
}
