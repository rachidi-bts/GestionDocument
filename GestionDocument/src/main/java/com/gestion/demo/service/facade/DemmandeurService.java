package com.gestion.demo.service.facade;


import java.util.Date;
import java.util.List;

import com.gestion.demo.bean.Demmandeur;

public interface DemmandeurService {

public Demmandeur save(Demmandeur demmandeur); 
public List<Demmandeur>  findAll();
public Demmandeur findById(Long id);
public int delete(Demmandeur demmandeur);
public void  deleteById(Long id);
public void clone(Demmandeur demmandeur,Demmandeur demmandeurClone);
public Demmandeur clone(Demmandeur demmandeur);
public List<Demmandeur> clone(List<Demmandeur>demmandeurs);
 public List<Demmandeur>  findByCriteria(String cne,String codeApogee,String nom,String prenom,String cin,String villeNaissance,String login,String password,Long idMin,Long idMax,Date dateNaissanceMin,Date dateNaissanceMax,Date anneeInscriptionMin,Date anneeInscriptionMax);

 public Demmandeur findByCne(String cne);
	
	public Demmandeur findByCodeApogee(String codeApogee);
	
	public Demmandeur findByNom(String nom);
	
	public Demmandeur findByCin(String cin);
	
	public List<Demmandeur> findByFiliereAbrv(String abrv);

	public int deleteByCne(String cne);
	
	
}
