
package com.gestion.demo.service.impl ;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.Filiere;
import com.gestion.demo.dao.FiliereDao;
import com.gestion.demo.service.facade.FiliereService;
import com.gestion.demo.service.util.SearchUtil; 

 @Service  

 public class FiliereServiceImpl implements FiliereService  {


 @Autowired 

 private FiliereDao filiereDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public Filiere  save (Filiere filiere){

if(filiere== null){ 
 return null; 
}else {
 filiereDao.save(filiere);
return filiere;
}
}

 @Override 
public List< Filiere>  findAll(){
 return filiereDao.findAll();
}

 @Override 
public Filiere findById(Long id){
 return filiereDao.getOne(id);
}

 @Override 
public int delete(Filiere filiere){
if(filiere== null){ 
  return -1; 
}else {
 filiereDao.delete(filiere);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       filiereDao.deleteById(id);
}
public void clone(Filiere filiere,Filiere filiereClone){
if(filiere!= null && filiereClone != null){
filiereClone.setId(filiere.getId());
filiereClone.setLibelle(filiere.getLibelle());
}
}
public Filiere clone(Filiere filiere){
if(filiere== null){       return null ;
}else{Filiere filiereClone= new Filiere();
 clone(filiere,filiereClone);
return filiereClone;
}
}
public List<Filiere> clone(List<Filiere>filieres){
if(filieres== null){
       return null ;
}else{List<Filiere> filieresClone = new ArrayList();
	 	 	 filieres.forEach((filiere)->{filieresClone.add(clone(filiere));
});return filieresClone;
}
}
 @Override 
 public List< Filiere>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT f FROM Filiere f where 1=1 ";
query += SearchUtil.addConstraint( "f", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("f", "id", idMin, idMax);

  return query; 
}
}
