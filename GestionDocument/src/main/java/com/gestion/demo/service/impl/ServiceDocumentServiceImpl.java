
package com.gestion.demo.service.impl ;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.ServiceDocument;
import com.gestion.demo.dao.ServiceDocumentDao;
import com.gestion.demo.service.facade.ServiceDocumentService;
import com.gestion.demo.service.util.SearchUtil; 

 @Service  

 public class ServiceDocumentServiceImpl implements ServiceDocumentService  {


 @Autowired 

 private ServiceDocumentDao servicedocumentDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public ServiceDocument  save (ServiceDocument servicedocument){

if(servicedocument== null){ 
 return null; 
}else {
 servicedocumentDao.save(servicedocument);
return servicedocument;
}
}

 @Override 
public List< ServiceDocument>  findAll(){
 return servicedocumentDao.findAll();
}

 @Override 
public ServiceDocument findById(Long id){
 return servicedocumentDao.getOne(id);
}

 @Override 
public int delete(ServiceDocument servicedocument){
if(servicedocument== null){ 
  return -1; 
}else {
 servicedocumentDao.delete(servicedocument);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       servicedocumentDao.deleteById(id);
}
public void clone(ServiceDocument servicedocument,ServiceDocument servicedocumentClone){
if(servicedocument!= null && servicedocumentClone != null){
servicedocumentClone.setId(servicedocument.getId());
servicedocumentClone.setLibelle(servicedocument.getLibelle());
}
}
public ServiceDocument clone(ServiceDocument servicedocument){
if(servicedocument== null){       return null ;
}else{ServiceDocument servicedocumentClone= new ServiceDocument();
 clone(servicedocument,servicedocumentClone);
return servicedocumentClone;
}
}
public List<ServiceDocument> clone(List<ServiceDocument>servicedocuments){
if(servicedocuments== null){
       return null ;
}else{List<ServiceDocument> servicedocumentsClone = new ArrayList();
	 	 	 servicedocuments.forEach((servicedocument)->{servicedocumentsClone.add(clone(servicedocument));
});return servicedocumentsClone;
}
}
 @Override 
 public List< ServiceDocument>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT s FROM ServiceDocument s where 1=1 ";
query += SearchUtil.addConstraint( "s", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("s", "id", idMin, idMax);

  return query; 
}
}
