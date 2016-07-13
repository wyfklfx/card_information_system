
package org.seller.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.studentcard.control.AccountControl;
import org.studentcard.database.control.SystemDBHelperBean;
import org.studentcard.database.model.ConsumeRecord;
import org.studentcard.database.model.Seller;
import org.studentcard.database.model.ShopInfo;


/**
 *
 * @author 1111
 */
@ManagedBean(name = "sellerBean")
@ViewScoped
public class SellerBean implements Serializable {

private Seller seller;


@EJB
private SystemDBHelperBean dbHelperBean;

@PostConstruct
public void init(){
    HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    seller = (Seller)session.getAttribute(AccountControl.SESSION_ATTR_USER);
    seller = (Seller)dbHelperBean.find(Seller.class, seller.getSellerID());
}

public List<ConsumeRecord> getInfos() {
    List<ConsumeRecord> resultList = new ArrayList<>();
    for(ShopInfo s : seller.getShopInfoList()){
        resultList.addAll(s.getConsumeRecordList());
    }
    return resultList;
}

public SellerBean() {

} 

}
