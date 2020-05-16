
package com.gestion.demo.service.impl ;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.EtatDemmande;
import com.gestion.demo.dao.EtatDemmandeDao;
import com.gestion.demo.service.facade.EtatDemmandeService;
import com.gestion.demo.service.util.SearchUtil; 

 @Service  

 public class EtatDemmandeServiceImpl implements EtatDemmandeService  {


 @Autowired 

 private EtatDemmandeDao etatdemmandeDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public EtatDemmande  save (EtatDemmande etatdemmande){

if(etatdemmande== null){ 
 return null; 
}else {
 etatdemmandeDao.save(etatdemmande);
return etatdemmande;
}
}

 @Override 
public List< EtatDemmande>  findAll(){
 return etatdemmandeDao.findAll();
}

 @Override 
public EtatDemmande findById(Long id){
 return etatdemmandeDao.getOne(id);
}

 @Override 
public int delete(EtatDemmande etatdemmande){
if(etatdemmande== null){ 
  return -1; 
}else {
 etatdemmandeDao.delete(etatdemmande);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       etatdemmandeDao.deleteById(id);
}
public void clone(EtatDemmande etatdemmande,EtatDemmande etatdemmandeClone){
if(etatdemmande!= null && etatdemmandeClone != null){
etatdemmandeClone.setId(etatdemmande.getId());
etatdemmandeClone.setLibelle(etatdemmande.getLibelle());
}
}
public EtatDemmande clone(EtatDemmande etatdemmande){
if(etatdemmande== null){       return null ;
}else{EtatDemmande etatdemmandeClone= new EtatDemmande();
 clone(etatdemmande,etatdemmandeClone);
return etatdemmandeClone;
}
}
public List<EtatDemmande> clone(List<EtatDemmande>etatdemmandes){
if(etatdemmandes== null){
       return null ;
}else{List<EtatDemmande> etatdemmandesClone = new ArrayList();
	 	 	 etatdemmandes.forEach((etatdemmande)->{etatdemmandesClone.add(clone(etatdemmande));
});return etatdemmandesClone;
}
}
 @Override 
 public List< EtatDemmande>  findByCriteria(String libelle,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax){
String query = "SELECT e FROM EtatDemmande e where 1=1 ";
query += SearchUtil.addConstraint( "e", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("e", "id", idMin, idMax);

  return query; 
}

@Override
public EtatDemmande findByLibelle(String libelle) {
	return etatdemmandeDao.findByLibelle(libelle);
}

@Override
public int deleteByLibelle(String libelle) {
	return etatdemmandeDao.deleteByLibelle(libelle);
}
}
