
package com.gestion.demo.service.impl ;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.DemmandeDocument;
import com.gestion.demo.dao.DemmandeDocumentDao;
import com.gestion.demo.service.facade.DemmandeDocumentService;
import com.gestion.demo.service.facade.DemmandeurService;
import com.gestion.demo.service.facade.EtatDemmandeService;
import com.gestion.demo.service.facade.TypeDocumentService;
import com.project.service.util.SearchUtil; 

 @Service  

 public class DemmandeDocumentServiceImpl implements DemmandeDocumentService  {


 @Autowired 

 private DemmandeDocumentDao demmandedocumentDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private DemmandeurService demmandeurService; 

 @Autowired 

 private TypeDocumentService typedocumentService; 

 @Autowired 

 private EtatDemmandeService etatdemmandeService; 

 @Override 
public DemmandeDocument  save (DemmandeDocument demmandedocument){

if(demmandedocument== null){ 
 return null; 
}else {
 demmandedocumentDao.save(demmandedocument);
return demmandedocument;
}
}

 @Override 
public List< DemmandeDocument>  findAll(){
 return demmandedocumentDao.findAll();
}

 @Override 
public DemmandeDocument findById(Long id){
 return demmandedocumentDao.getOne(id);
}

 @Override 
public int delete(DemmandeDocument demmandedocument){
if(demmandedocument== null){ 
  return -1; 
}else {
 demmandedocumentDao.delete(demmandedocument);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       demmandedocumentDao.deleteById(id);
}
public void clone(DemmandeDocument demmandedocument,DemmandeDocument demmandedocumentClone){
if(demmandedocument!= null && demmandedocumentClone != null){
demmandedocumentClone.setId(demmandedocument.getId());
demmandedocumentClone.setDateDemmande(demmandedocument.getDateDemmande());
demmandedocumentClone.setDateValidation(demmandedocument.getDateValidation());
demmandedocumentClone.setDemmandeur(demmandeurService.clone(demmandedocument.getDemmandeur()));
demmandedocumentClone.setTypeDocument(typedocumentService.clone(demmandedocument.getTypeDocument()));
demmandedocumentClone.setEtatDemmande(etatdemmandeService.clone(demmandedocument.getEtatDemmande()));
}
}
public DemmandeDocument clone(DemmandeDocument demmandedocument){
if(demmandedocument== null){       return null ;
}else{DemmandeDocument demmandedocumentClone= new DemmandeDocument();
 clone(demmandedocument,demmandedocumentClone);
return demmandedocumentClone;
}
}
public List<DemmandeDocument> clone(List<DemmandeDocument>demmandedocuments){
if(demmandedocuments== null){
       return null ;
}else{List<DemmandeDocument> demmandedocumentsClone = new ArrayList();
	 	 	 demmandedocuments.forEach((demmandedocument)->{demmandedocumentsClone.add(clone(demmandedocument));
});return demmandedocumentsClone;
}
}
 @Override 
 public List< DemmandeDocument>  findByCriteria(Long idMin,Long idMax,Date dateDemmandeMin,Date dateDemmandeMax,Date dateValidationMin,Date dateValidationMax){
 return entityManager.createQuery(constructQuery(idMin,idMax,dateDemmandeMin,dateDemmandeMax,dateValidationMin,dateValidationMax)).getResultList(); 
 }
private String constructQuery(Long idMin,Long idMax,Date dateDemmandeMin,Date dateDemmandeMax,Date dateValidationMin,Date dateValidationMax){
String query = "SELECT d FROM DemmandeDocument d where 1=1 ";
query += SearchUtil.addConstraintMinMax("d", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMaxDate("d"," dateDemmande", dateDemmandeMin, dateDemmandeMax);
query += SearchUtil.addConstraintMinMaxDate("d"," dateValidation", dateValidationMin, dateValidationMax);

  return query; 
}

@Override
public List<DemmandeDocument> findByDemmandeurNom(String nom) {
	return demmandedocumentDao.findByDemmandeurNom(nom);
}

@Override
public List<DemmandeDocument> findByDemmandeurCodeApogee(String codeApogee) {
	return demmandedocumentDao.findByDemmandeurCodeApogee(codeApogee);
}

@Override
public List<DemmandeDocument> findByDemmandeurCne(String cne) {
	return demmandedocumentDao.findByDemmandeurCne(cne);
}

@Override
public List<DemmandeDocument> findByTypeDocumentLibelle(String libelle) {
	return demmandedocumentDao.findByTypeDocumentLibelle(libelle);
}

@Override
public List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle) {
	return demmandedocumentDao.findByEtatDemmandeLibelle(libelle);
}

@Override
public DemmandeDocumentDao findByDateDemmande(Date dateDemmande) {
	return demmandedocumentDao.findByDateDemmande(dateDemmande);
}
}
