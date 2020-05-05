package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.EtatDemmande;

public interface EtatDemmandeService {

	public EtatDemmande findByLibelle(String libelle);
	
	public int deleteByLibelle(String libelle);
	
	public int save(EtatDemmande etatDemmande);
	
	public List<EtatDemmande> findAll();
}
