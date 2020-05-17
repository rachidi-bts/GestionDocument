package com.gestion.demo.ws.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.service.util.DateUtil;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.DemmandeurVo; 

 @Component 
public class DemmandeurConverter extends AbstractConverter<Demmandeur,DemmandeurVo>{ 

private boolean filiere; 

 @Autowired
 private FiliereConverter filiereConverter ; 

 @Override 
 public Demmandeur toItem(DemmandeurVo vo) {
 if (vo == null) {
    return null;
      } else {
Demmandeur item = new Demmandeur();

 if(filiere&& vo.getFiliereVo() != null) {
 item.setFiliere(filiereConverter.toItem(vo.getFiliereVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getCne())) {
 item.setCne(vo.getCne());
} 

 if (StringUtil.isNotEmpty(vo.getCodeApogee())) {
 item.setCodeApogee(vo.getCodeApogee());
} 

 if (StringUtil.isNotEmpty(vo.getNom())) {
 item.setNom(vo.getNom());
} 

 if (StringUtil.isNotEmpty(vo.getPrenom())) {
 item.setPrenom(vo.getPrenom());
} 

 if (StringUtil.isNotEmpty(vo.getCin())) {
 item.setCin(vo.getCin());
} 

 if (StringUtil.isNotEmpty(vo.getVilleNaissance())) {
 item.setVilleNaissance(vo.getVilleNaissance());
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

 if (vo.getDateNaissance() != null) {
 item.setDateNaissance(DateUtil.parse(vo.getDateNaissance()));
} 

 if (vo.getAnneeInscription() != null) {
 item.setAnneeInscription(DateUtil.parse(vo.getAnneeInscription()));
} 

return item;
 }
 }

  @Override 
 public DemmandeurVo toVo(Demmandeur item) {
 if (item == null) {
    return null;
      } else {
DemmandeurVo vo = new DemmandeurVo();

 if(filiere&& item.getFiliere() != null) {
 vo.setFiliereVo(filiereConverter.toVo(item.getFiliere()));
} 
 
 if (StringUtil.isNotEmpty(item.getCne())) {
 vo.setCne(item.getCne());
} 

 if (StringUtil.isNotEmpty(item.getCodeApogee())) {
 vo.setCodeApogee(item.getCodeApogee());
} 

 if (StringUtil.isNotEmpty(item.getNom())) {
 vo.setNom(item.getNom());
} 

 if (StringUtil.isNotEmpty(item.getPrenom())) {
 vo.setPrenom(item.getPrenom());
} 

 if (StringUtil.isNotEmpty(item.getCin())) {
 vo.setCin(item.getCin());
} 

 if (StringUtil.isNotEmpty(item.getVilleNaissance())) {
 vo.setVilleNaissance(item.getVilleNaissance());
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

 if (item.getDateNaissance() != null) {
 vo.setDateNaissance(DateUtil.formateDate(item.getDateNaissance()));
} 

 if (item.getAnneeInscription() != null) {
 vo.setAnneeInscription(DateUtil.formateDate(item.getAnneeInscription()));
} 

return vo;
 }
 }
public void init() { 

filiere = true; 
}
 } 
