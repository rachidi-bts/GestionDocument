package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.EtatDemmande;
public interface EtatDemmandeService {

public EtatDemmande save(EtatDemmande etatdemmande); 
public List<EtatDemmande>  findAll();
public EtatDemmande findById(Long id);
public int delete(EtatDemmande etatdemmande);
public void  deleteById(Long id);
public void clone(EtatDemmande etatdemmande,EtatDemmande etatdemmandeClone);
public EtatDemmande clone(EtatDemmande etatdemmande);
public List<EtatDemmande> clone(List<EtatDemmande>etatdemmandes);
 public List<EtatDemmande>  findByCriteria(String libelle,Long idMin,Long idMax);
 
 public EtatDemmande findByLibelle(String libelle);
	
	public int deleteByLibelle(String libelle);

}
