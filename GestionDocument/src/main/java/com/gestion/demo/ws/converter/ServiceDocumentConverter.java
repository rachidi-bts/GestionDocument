package com.gestion.demo.ws.converter;
 
import org.springframework.stereotype.Component;

import com.gestion.demo.bean.ServiceDocument;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.ServiceDocumentVo; 

 @Component 
public class ServiceDocumentConverter extends AbstractConverter<ServiceDocument,ServiceDocumentVo>{ 


 @Override 
 public ServiceDocument toItem(ServiceDocumentVo vo) {
 if (vo == null) {
    return null;
      } else {
ServiceDocument item = new ServiceDocument();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public ServiceDocumentVo toVo(ServiceDocument item) {
 if (item == null) {
    return null;
      } else {
ServiceDocumentVo vo = new ServiceDocumentVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 
}
 } 
