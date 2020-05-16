package com.gestion.demo.ws.converter;
 
import org.springframework.stereotype.Component;

import com.gestion.demo.bean.Filiere;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.FiliereVo; 

 @Component 
public class FiliereConverter extends AbstractConverter<Filiere,FiliereVo>{ 


 @Override 
 public Filiere toItem(FiliereVo vo) {
 if (vo == null) {
    return null;
      } else {
Filiere item = new Filiere();

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
 public FiliereVo toVo(Filiere item) {
 if (item == null) {
    return null;
      } else {
FiliereVo vo = new FiliereVo();

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