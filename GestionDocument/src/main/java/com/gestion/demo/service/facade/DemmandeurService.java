package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.Demmandeur;

public interface DemmandeurService {

public Demmandeur findByCne(String cne);
	
	public Demmandeur findByCodeApogee(String codeApogee);
	
	public Demmandeur findByNom(String nom);
	
	public Demmandeur findByCin(String cin);

	public int deleteByCne(String cne);
	
	public int save (Demmandeur demmandeur);
	
	public List<Demmandeur> findAll();
}
