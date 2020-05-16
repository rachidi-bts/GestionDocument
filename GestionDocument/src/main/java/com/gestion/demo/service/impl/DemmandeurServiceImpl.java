
package com.gestion.demo.service.impl ;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.dao.DemmandeurDao;
import com.gestion.demo.service.facade.DemmandeurService;
import com.gestion.demo.service.facade.FiliereService;
import com.gestion.demo.service.util.SearchUtil; 

 @Service  

 public class DemmandeurServiceImpl implements DemmandeurService  {


 @Autowired 

 private DemmandeurDao demmandeurDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private FiliereService filiereService; 

 @Override 
public Demmandeur  save (Demmandeur demmandeur){

if(demmandeur== null){ 
 return null; 
}else {
 demmandeurDao.save(demmandeur);
return demmandeur;
}
}

 @Override 
public List< Demmandeur>  findAll(){
 return demmandeurDao.findAll();
}

 @Override 
public Demmandeur findById(Long id){
 return demmandeurDao.getOne(id);
}

 @Override 
public int delete(Demmandeur demmandeur){
if(demmandeur== null){ 
  return -1; 
}else {
 demmandeurDao.delete(demmandeur);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       demmandeurDao.deleteById(id);
}
public void clone(Demmandeur demmandeur,Demmandeur demmandeurClone){
if(demmandeur!= null && demmandeurClone != null){
demmandeurClone.setId(demmandeur.getId());
demmandeurClone.setCne(demmandeur.getCne());
demmandeurClone.setCodeApogee(demmandeur.getCodeApogee());
demmandeurClone.setNom(demmandeur.getNom());
demmandeurClone.setPrenom(demmandeur.getPrenom());
demmandeurClone.setCin(demmandeur.getCin());
demmandeurClone.setDateNaissance(demmandeur.getDateNaissance());
demmandeurClone.setVilleNaissance(demmandeur.getVilleNaissance());
demmandeurClone.setAnneeInscription(demmandeur.getAnneeInscription());
demmandeurClone.setLogin(demmandeur.getLogin());
demmandeurClone.setPassword(demmandeur.getPassword());
demmandeurClone.setFiliere(filiereService.clone(demmandeur.getFiliere()));
}
}
public Demmandeur clone(Demmandeur demmandeur){
if(demmandeur== null){       return null ;
}else{Demmandeur demmandeurClone= new Demmandeur();
 clone(demmandeur,demmandeurClone);
return demmandeurClone;
}
}
public List<Demmandeur> clone(List<Demmandeur>demmandeurs){
if(demmandeurs== null){
       return null ;
}else{List<Demmandeur> demmandeursClone = new ArrayList();
	 	 	 demmandeurs.forEach((demmandeur)->{demmandeursClone.add(clone(demmandeur));
});return demmandeursClone;
}
}
 @Override 
 public List< Demmandeur>  findByCriteria(String cne,String codeApogee,String nom,String prenom,String cin,String villeNaissance,String login,String password,Long idMin,Long idMax,Date dateNaissanceMin,Date dateNaissanceMax,Date anneeInscriptionMin,Date anneeInscriptionMax){
 return entityManager.createQuery(constructQuery(cne,codeApogee,nom,prenom,cin,villeNaissance,login,password,idMin,idMax,dateNaissanceMin,dateNaissanceMax,anneeInscriptionMin,anneeInscriptionMax)).getResultList(); 
 }
private String constructQuery(String cne,String codeApogee,String nom,String prenom,String cin,String villeNaissance,String login,String password,Long idMin,Long idMax,Date dateNaissanceMin,Date dateNaissanceMax,Date anneeInscriptionMin,Date anneeInscriptionMax){
String query = "SELECT d FROM Demmandeur d where 1=1 ";
query += SearchUtil.addConstraint( "d", "cne","=",cne);
query += SearchUtil.addConstraint( "d", "codeApogee","=",codeApogee);
query += SearchUtil.addConstraint( "d", "nom","=",nom);
query += SearchUtil.addConstraint( "d", "prenom","=",prenom);
query += SearchUtil.addConstraint( "d", "cin","=",cin);
query += SearchUtil.addConstraint( "d", "villeNaissance","=",villeNaissance);
query += SearchUtil.addConstraint( "d", "login","=",login);
query += SearchUtil.addConstraint( "d", "password","=",password);
query += SearchUtil.addConstraintMinMax("d", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMaxDate("d"," dateNaissance", dateNaissanceMin, dateNaissanceMax);
query += SearchUtil.addConstraintMinMaxDate("d"," anneeInscription", anneeInscriptionMin, anneeInscriptionMax);

  return query; 
}

@Override
public Demmandeur findByCne(String cne) {
	return demmandeurDao.findByCne(cne);
}

@Override
public Demmandeur findByCodeApogee(String codeApogee) {
	return demmandeurDao.findByCodeApogee(codeApogee);
}

@Override
public Demmandeur findByNom(String nom) {
	return demmandeurDao.findByNom(nom);
}

@Override
public Demmandeur findByCin(String cin) {
	return demmandeurDao.findByCin(cin);
}

@Override
public int deleteByCne(String cne) {
	Demmandeur demmandeur= demmandeurDao.findByCne(cne);
	if (demmandeur == null) {
		return -1;
	}else {
		demmandeurDao.delete(demmandeur);
		return 1;
	}
}
}
