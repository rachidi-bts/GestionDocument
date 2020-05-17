package com.gestion.demo.ws.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.demo.bean.Responsable;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.ResponsableVo; 

 @Component 
public class ResponsableConverter extends AbstractConverter<Responsable,ResponsableVo>{ 

private boolean serviceDocument; 

 @Autowired
 private ServiceDocumentConverter serviceDocumentConverter ; 

 @Override 
 public Responsable toItem(ResponsableVo vo) {
 if (vo == null) {
    return null;
      } else {
Responsable item = new Responsable();

 if(serviceDocument&& vo.getServiceDocumentVo() != null) {
 item.setServiceDocument(serviceDocumentConverter.toItem(vo.getServiceDocumentVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getLogin())) {
 item.setLogin(vo.getLogin());
} 

 if (StringUtil.isNotEmpty(vo.getPassword())) {
 item.setPassword(vo.getPassword());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public ResponsableVo toVo(Responsable item) {
 if (item == null) {
    return null;
      } else {
ResponsableVo vo = new ResponsableVo();

 if(serviceDocument&& item.getServiceDocument() != null) {
 vo.setServiceDocumentVo(serviceDocumentConverter.toVo(item.getServiceDocument()));
} 
 
 if (StringUtil.isNotEmpty(item.getLogin())) {
 vo.setLogin(item.getLogin());
} 

 if (StringUtil.isNotEmpty(item.getPassword())) {
 vo.setPassword(item.getPassword());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 

serviceDocument = true; 
}
 } 
