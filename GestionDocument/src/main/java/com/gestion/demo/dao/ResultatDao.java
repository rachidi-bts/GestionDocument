package com.gestion.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.Resultat;


@Repository
public interface ResultatDao extends JpaRepository<Resultat,Long> {

	public Resultat findByLibelle(String libelle);
	
    public   int deleteByLibelle(String libelle);


}