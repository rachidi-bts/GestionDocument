
package com.gestion.demo.service.impl ;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.Responsable;
import com.gestion.demo.dao.ResponsableDao;
import com.gestion.demo.service.facade.ResponsableService;
import com.gestion.demo.service.facade.ServiceDocumentService;
import com.gestion.demo.service.util.SearchUtil; 

 @Service  

 public class ResponsableServiceImpl implements ResponsableService  {


 @Autowired 

 private ResponsableDao responsableDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private ServiceDocumentService servicedocumentService; 

 @Override 
public Responsable  save (Responsable responsable){

if(responsable== null){ 
 return null; 
}else {
 responsableDao.save(responsable);
return responsable;
}
}

 @Override 
public List< Responsable>  findAll(){
 return responsableDao.findAll();
}

 @Override 
public Responsable findById(Long id){
 return responsableDao.getOne(id);
}

 @Override 
public int delete(Responsable responsable){
if(responsable== null){ 
  return -1; 
}else {
 responsableDao.delete(responsable);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       responsableDao.deleteById(id);
}
public void clone(Responsable responsable,Responsable responsableClone){
if(responsable!= null && responsableClone != null){
responsableClone.setId(responsable.getId());
responsableClone.setLogin(responsable.getLogin());
responsableClone.setPassword(responsable.getPassword());
responsableClone.setServiceDocument(servicedocumentService.clone(responsable.getServiceDocument()));
}
}
public Responsable clone(Responsable responsable){
if(responsable== null){       return null ;
}else{Responsable responsableClone= new Responsable();
 clone(responsable,responsableClone);
return responsableClone;
}
}
public List<Responsable> clone(List<Responsable>responsables){
if(responsables== null){
       return null ;
}else{List<Responsable> responsablesClone = new ArrayList();
	 	 	 responsables.forEach((responsable)->{responsablesClone.add(clone(responsable));
});return responsablesClone;
}
}
 @Override 
 public List< Responsable>  findByCriteria(String login,String password,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(login,password,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String login,String password,Long idMin,Long idMax){
String query = "SELECT r FROM Responsable r where 1=1 ";
query += SearchUtil.addConstraint( "r", "login","=",login);
query += SearchUtil.addConstraint( "r", "password","=",password);
query += SearchUtil.addConstraintMinMax("r", "id", idMin, idMax);

  return query; 
}
}
