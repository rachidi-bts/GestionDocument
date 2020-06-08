package com.gestion.demo.ws.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.demo.bean.TypeDocument;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.TypeDocumentVo; 

 @Component 
public class TypeDocumentConverter extends AbstractConverter<TypeDocument,TypeDocumentVo>{ 

private boolean typeFilliere; 

 @Autowired
 private TypeFiliereConverter typeFilliereConverter ; 

 @Override 
 public TypeDocument toItem(TypeDocumentVo vo) {
 if (vo == null) {
    return null;
      } else {
TypeDocument item = new TypeDocument();

 if(typeFilliere&& vo.getTypeFilliereVo() != null) {
 item.setTypeFilliere(typeFilliereConverter.toItem(vo.getTypeFilliereVo()));
} 
 
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
 public TypeDocumentVo toVo(TypeDocument item) {
 if (item == null) {
    return null;
      } else {
TypeDocumentVo vo = new TypeDocumentVo();

 if(typeFilliere&& item.getTypeFilliere() != null) {
 vo.setTypeFilliereVo(typeFilliereConverter.toVo(item.getTypeFilliere()));
} 
 
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

typeFilliere = true; 
}
 } 
