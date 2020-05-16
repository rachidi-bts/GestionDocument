package com.gestion.demo.ws.converter;
 
import org.springframework.stereotype.Component;

import com.gestion.demo.bean.EtatDemmande;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.EtatDemmandeVo; 

 @Component 
public class EtatDemmandeConverter extends AbstractConverter<EtatDemmande,EtatDemmandeVo>{ 


 @Override 
 public EtatDemmande toItem(EtatDemmandeVo vo) {
 if (vo == null) {
    return null;
      } else {
EtatDemmande item = new EtatDemmande();

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
 public EtatDemmandeVo toVo(EtatDemmande item) {
 if (item == null) {
    return null;
      } else {
EtatDemmandeVo vo = new EtatDemmandeVo();

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
