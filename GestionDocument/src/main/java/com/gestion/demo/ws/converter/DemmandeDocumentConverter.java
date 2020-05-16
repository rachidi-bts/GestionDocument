package com.gestion.demo.ws.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.demo.bean.DemmandeDocument;
import com.gestion.demo.service.util.DateUtil;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.ws.vo.DemmandeDocumentVo; 

 @Component 
public class DemmandeDocumentConverter extends AbstractConverter<DemmandeDocument,DemmandeDocumentVo>{ 

private boolean demmandeur; 

 @Autowired
 private DemmandeurConverter demmandeurConverter ; 
private boolean typeDocument; 

 @Autowired
 private TypeDocumentConverter typeDocumentConverter ; 
private boolean etatDemmande; 

 @Autowired
 private EtatDemmandeConverter etatDemmandeConverter ; 

 @Override 
 public DemmandeDocument toItem(DemmandeDocumentVo vo) {
 if (vo == null) {
    return null;
      } else {
DemmandeDocument item = new DemmandeDocument();

 if(demmandeur&& vo.getDemmandeurVo() != null) {
 item.setDemmandeur(demmandeurConverter.toItem(vo.getDemmandeurVo()));
} 
 
 if(typeDocument&& vo.getTypeDocumentVo() != null) {
 item.setTypeDocument(typeDocumentConverter.toItem(vo.getTypeDocumentVo()));
} 
 
 if(etatDemmande&& vo.getEtatDemmandeVo() != null) {
 item.setEtatDemmande(etatDemmandeConverter.toItem(vo.getEtatDemmandeVo()));
} 
 
 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getDateDemmande() != null) {
 item.setDateDemmande(DateUtil.parse(vo.getDateDemmande()));
} 

 if (vo.getDateValidation() != null) {
 item.setDateValidation(DateUtil.parse(vo.getDateValidation()));
} 

return item;
 }
 }

  @Override 
 public DemmandeDocumentVo toVo(DemmandeDocument item) {
 if (item == null) {
    return null;
      } else {
DemmandeDocumentVo vo = new DemmandeDocumentVo();

 if(demmandeur&& item.getDemmandeur() != null) {
 vo.setDemmandeurVo(demmandeurConverter.toVo(item.getDemmandeur()));
} 
 
 if(typeDocument&& item.getTypeDocument() != null) {
 vo.setTypeDocumentVo(typeDocumentConverter.toVo(item.getTypeDocument()));
} 
 
 if(etatDemmande&& item.getEtatDemmande() != null) {
 vo.setEtatDemmandeVo(etatDemmandeConverter.toVo(item.getEtatDemmande()));
} 
 
 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getDateDemmande() != null) {
 vo.setDateDemmande(DateUtil.formateDate(item.getDateDemmande()));
} 

 if (item.getDateValidation() != null) {
 vo.setDateValidation(DateUtil.formateDate(item.getDateValidation()));
} 

return vo;
 }
 }
public void init() { 

demmandeur = true; 

typeDocument = true; 

etatDemmande = true; 
}
 } 
