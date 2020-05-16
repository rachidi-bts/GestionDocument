package com.gestion.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.EtatDemmande;


@Repository
 public interface EtatDemmandeDao extends JpaRepository<EtatDemmande,Long> {

	public EtatDemmande findByLibelle(String libelle);
	
	public int deleteByLibelle(String libelle);



}
