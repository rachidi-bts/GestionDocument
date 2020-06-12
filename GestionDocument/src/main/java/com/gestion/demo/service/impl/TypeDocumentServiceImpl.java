
package com.gestion.demo.service.impl ;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.TypeDocument;
import com.gestion.demo.dao.TypeDocumentDao;
import com.gestion.demo.service.facade.TypeFiliereService;
import com.gestion.demo.service.facade.TypeDocumentService;
import com.gestion.demo.service.util.SearchUtil; 

 @Service  

 public class TypeDocumentServiceImpl implements TypeDocumentService  {


 @Autowired 

 private TypeDocumentDao typedocumentDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private TypeFiliereService typeFilliereService; 

 @Override 
public TypeDocument  save (TypeDocument typedocument){

if(typedocument== null){ 
 return null; 
}else {
 typedocumentDao.save(typedocument);
return typedocument;
}
}

 @Override 
public List< TypeDocument>  findAll(){
 return typedocumentDao.findAll();
}

 @Override 
public TypeDocument findById(Long id){
 return typedocumentDao.getOne(id);
}

 @Override 
public int delete(TypeDocument typedocument){
if(typedocument== null){ 
  return -1; 
}else {
 typedocumentDao.delete(typedocument);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       typedocumentDao.deleteById(id);
}
public void clone(TypeDocument typedocument,TypeDocument typedocumentClone){
if(typedocument!= null && typedocumentClone != null){
typedocumentClone.setId(typedocument.getId());
typedocumentClone.setLibelle(typedocument.getLibelle());
typedocumentClone.setTypeFilliere(typeFilliereService.clone(typedocument.getTypeFilliere()));
}
}
public TypeDocument clone(TypeDocument typedocument){
if(typedocument== null){       return null ;
}else{TypeDocument typedocumentClone= new TypeDocument();
 clone(typedocument,typedocumentClone);
return typedocumentClone;
}
}
public List<TypeDocument> clone(List<TypeDocument>typedocuments){
if(typedocuments== null){
       return null ;
}else{List<TypeDocument> typedocumentsClone = new ArrayList();
	 	 	 typedocuments.forEach((typedocument)->{typedocumentsClone.add(clone(typedocument));
});return typedocumentsClone;
}
}
 @Override 
 public List< TypeDocument>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT t FROM TypeDocument t where 1=1 ";
query += SearchUtil.addConstraint( "t", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("t", "id", idMin, idMax);

  return query; 
}

@Override
public TypeDocument findByLibelle(String libelle) {
	return typedocumentDao.findByLibelle(libelle);
}
}
