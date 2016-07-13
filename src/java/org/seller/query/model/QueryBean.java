package org.seller.query.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.studentcard.control.AccountControl;
import org.studentcard.database.control.SystemDBHelperBean;
import org.studentcard.database.model.Seller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.faces.view.ViewScoped;
import org.studentcard.database.model.ConsumeRecord;
import org.studentcard.database.model.ShopInfo;


/**
 *
 * @author 1111
 */
@ManagedBean(name = "queryBean")
@ViewScoped
public class QueryBean implements Serializable {

private Seller seller;
private SimpleDateFormat format;
private List<ConsumeRecord> resulltList = new ArrayList<>();
private Date date;

@EJB
private SystemDBHelperBean dbHelperBean;

@PostConstruct
public void init(){
    HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    seller = (Seller)session.getAttribute(AccountControl.SESSION_ATTR_USER);
    seller = (Seller)dbHelperBean.find(Seller.class, seller.getSellerID());
  }


 
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



public List<ConsumeRecord> getInfos() {
    List<ConsumeRecord> list = new ArrayList<>();
    ConsumeRecord record; 
    format = new SimpleDateFormat("dd/MM/yyyy");
    for(ShopInfo s : seller.getShopInfoList()){
        list.addAll(s.getConsumeRecordList());
    }
    Iterator<ConsumeRecord> it = list.iterator();
    while(it.hasNext()){
        record = it.next();
        String recordTime = format.format((record.getConsumeRecordPK().getConsumeTime()));
        String parTime = format.format(date);
        if(recordTime.equals(parTime)){
            resulltList.add(record);
        }
    }

    return resulltList;
}
   
public QueryBean(){
  date = new Date();
  
}

}
