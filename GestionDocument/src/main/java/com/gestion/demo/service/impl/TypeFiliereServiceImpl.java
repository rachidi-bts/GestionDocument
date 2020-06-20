
package com.gestion.demo.service.impl ;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.TypeFiliere;
import com.gestion.demo.dao.TypeFiliereDao;
import com.gestion.demo.service.facade.FiliereService;
import com.gestion.demo.service.facade.TypeFiliereService;
import com.gestion.demo.service.util.SearchUtil; 

 @Service  

 public class TypeFiliereServiceImpl implements TypeFiliereService  {


 @Autowired 

 private TypeFiliereDao typeFiliereDao;

 @Autowired 

 private EntityManager entityManager; 

 

 @Override 
public TypeFiliere  save (TypeFiliere typeFiliere){

if(typeFiliere== null){ 
 return null; 
}else {
 typeFiliereDao.save(typeFiliere);
return typeFiliere;
}
}

 @Override 
public List< TypeFiliere>  findAll(){
 return typeFiliereDao.findAll();
}

 @Override 
public TypeFiliere findById(Long id){
 return typeFiliereDao.getOne(id);
}

 @Override 
public int delete(TypeFiliere typeFiliere){
if(typeFiliere== null){ 
  return -1; 
}else {
 typeFiliereDao.delete(typeFiliere);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       typeFiliereDao.deleteById(id);
}
public void clone(TypeFiliere typeFiliere,TypeFiliere typeFiliereClone){
if(typeFiliere!= null && typeFiliereClone != null){
typeFiliereClone.setId(typeFiliere.getId());
typeFiliereClone.setLibelle(typeFiliere.getLibelle());
}
}
public TypeFiliere clone(TypeFiliere typeFiliere){
if(typeFiliere== null){       return null ;
}else{TypeFiliere typeFiliereClone= new TypeFiliere();
 clone(typeFiliere,typeFiliereClone);
return typeFiliereClone;
}
}
public List<TypeFiliere> clone(List<TypeFiliere>typeFilieres){
if(typeFilieres== null){
       return null ;
}else{List<TypeFiliere> typeFilieresClone = new ArrayList();
	 	 	 typeFilieres.forEach((typeFiliere)->{typeFilieresClone.add(clone(typeFiliere));
});return typeFilieresClone;
}
}
 @Override 
 public List< TypeFiliere>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT t FROM TypeFilliere t where 1=1 ";
query += SearchUtil.addConstraint( "t", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("t", "id", idMin, idMax);

  return query; 
}
}
