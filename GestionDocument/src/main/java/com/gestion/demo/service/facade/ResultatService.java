package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.Resultat;

public interface ResultatService {

    public List<Resultat> findAll();
	   
    public Resultat findByLibelle(String libelle);
    public int deleteByLibelle(String libelle);
    
    public Resultat findById(Long id);
	
    public Resultat save(Resultat resultat);

    public List<Resultat> saveAll(List<Resultat> resultats);
    
     /**
     * update Resultat in database
     * @param resultat - Resultat to be updated
     * @return the updated Resultat, If the Resultat can't be updated return null.
     */
    public Resultat update(Resultat resultat);
    
    public int delete(Resultat resultat);
    
   
    
}