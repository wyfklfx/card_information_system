/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view.multimedia.contentFlow;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author 1111
 */
@ManagedBean(name = "imagesView")
@SessionScoped
public class ImagesView implements Serializable {

  private List<String> images;
  @PostConstruct
  public void init(){
      images = new ArrayList<>();
      for(int i = 1;i <= 17;i++){
          images.add("bg" + i + ".jpg");
      }
  }
  
  public List<String> getImages(){
      return images;
  }
}
