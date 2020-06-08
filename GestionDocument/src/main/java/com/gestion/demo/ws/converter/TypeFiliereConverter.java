package com.gestion.demo.ws.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.demo.bean.TypeFiliere;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.TypeFiliereVo;

 @Component 
public class TypeFiliereConverter extends AbstractConverter<TypeFiliere,TypeFiliereVo>{ 

private boolean filiere; 

 @Autowired
 private FiliereConverter filiereConverter ; 

 @Override 
 public TypeFiliere toItem(TypeFiliereVo vo) {
 if (vo == null) {
    return null;
      } else {
TypeFiliere item = new TypeFiliere();

 if(filiere&& vo.getFiliereVo() != null) {
 item.setFiliere(filiereConverter.toItem(vo.getFiliereVo()));
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
 public TypeFiliereVo toVo(TypeFiliere item) {
 if (item == null) {
    return null;
      } else {
TypeFiliereVo vo = new TypeFiliereVo();

 if(filiere&& item.getFiliere() != null) {
 vo.setFilliereVo(filiereConverter.toVo(item.getFiliere()));
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

filiere = true; 
}
 } 
