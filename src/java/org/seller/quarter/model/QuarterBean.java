package org.seller.quarter.model;

import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
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
@ManagedBean(name = "quarterBean")
@ViewScoped
public class QuarterBean implements  Serializable{
 
private Seller seller;
private List<ConsumeRecord> resulltList1 = new ArrayList<>();
private List<ConsumeRecord> resulltList2 = new ArrayList<>();
private List<ConsumeRecord> resulltList3 = new ArrayList<>();
private List<ConsumeRecord> resulltList4 = new ArrayList<>();




@EJB
private SystemDBHelperBean dbHelperBean;

@PostConstruct
public void init(){
    HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    seller = (Seller)session.getAttribute(AccountControl.SESSION_ATTR_USER);
    seller = (Seller)dbHelperBean.find(Seller.class, seller.getSellerID());
  }


    public QuarterBean() {
   
    }
    
    public List<ConsumeRecord> getQuarter1(){
        List<ConsumeRecord> list = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int month;
        ConsumeRecord record1;
        
        for(ShopInfo s : seller.getShopInfoList()){
            list.addAll(s.getConsumeRecordList());
        }
        
        Iterator<ConsumeRecord> it = list.iterator();
        
        while(it.hasNext()){
            record1 = it.next();
            c.setTime((record1.getConsumeRecordPK().getConsumeTime()));
            month = c.get(Calendar.MONTH) + 1;
            if(month == 1 || month == 2 || month==3){
               resulltList1.add(record1);
            }
        }
        return resulltList1;
    }
    
    
    public List<ConsumeRecord> getQuarter2(){
        List<ConsumeRecord> list = new ArrayList<>();
        
        Calendar c = Calendar.getInstance();
        int month;
        
        for(ShopInfo s : seller.getShopInfoList()){
            list.addAll(s.getConsumeRecordList());
        }
        
        Iterator<ConsumeRecord> it = list.iterator();
        
        while(it.hasNext()){
            ConsumeRecord record2 = it.next();
            c.setTime((record2.getConsumeRecordPK().getConsumeTime()));
            month = c.get(Calendar.MONTH) + 1;
            if(month == 4 || month == 5 || month==6){
               resulltList2.add(record2);
            }
        }
        return resulltList2;
    }
    
    
    public List<ConsumeRecord> getQuarter3(){
        List<ConsumeRecord> list = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int month;
        
        for(ShopInfo s : seller.getShopInfoList()){
            list.addAll(s.getConsumeRecordList());
        }
        
        Iterator<ConsumeRecord> it = list.iterator();
        
        while(it.hasNext()){
            ConsumeRecord record3 = it.next();
            c.setTime((record3.getConsumeRecordPK().getConsumeTime()));
            month = c.get(Calendar.MONTH) + 1;
            if(month == 7 || month == 8 || month==9){
               resulltList3.add(record3);
            }
        }
        return resulltList3;
    }
    
    
    public List<ConsumeRecord> getQuarter4(){
        List<ConsumeRecord> list = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int month;
        
        for(ShopInfo s : seller.getShopInfoList()){
            list.addAll(s.getConsumeRecordList());
        }
        
        Iterator<ConsumeRecord> it = list.iterator();
        
        while(it.hasNext()){
            ConsumeRecord record4 = it.next();
            c.setTime((record4.getConsumeRecordPK().getConsumeTime()));
            month = c.get(Calendar.MONTH) + 1;
            if(month == 10 || month == 11 || month==12){
               resulltList4.add(record4);
            }
        }
        return resulltList4;
    }
    
    
<<<<<<< HEAD
    public float getQuarterBalance1(){
        float balance1 = 0;
        System.out.println(resulltList1.size());
        for(ConsumeRecord record :resulltList1){
            balance1 +=  record.getBalance();
            System.out.println(balance1);
        }
        return balance1;
    }
    
    public float getQuarterBalance2(){
        float balance2 = 0;
        System.out.println(resulltList2.size());
        for(ConsumeRecord record :resulltList2){
            balance2 +=  record.getBalance();
            System.out.println(balance2);
        }
        return balance2;
    }
      
    public float getQuarterBalance3(){
        float balance3 = 0;
        System.out.println(resulltList3.size());
        for(ConsumeRecord record :resulltList3){
            balance3 +=  record.getBalance();
            System.out.println(balance3);
        }
        return balance3;
    }
       
    public float getQuarterBalance4(){
        float balance4 = 0;
        System.out.println(resulltList4.size());
        for(ConsumeRecord record :resulltList4){
            balance4 +=  record.getBalance();
            System.out.println(balance4);
        }
        return balance4;
    }
=======
    
    
    
>>>>>>> 5332c4b72a826b09dcb046aacf230bf907c408ff
    
}
