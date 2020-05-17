package com.gestion.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.Filiere;


@Repository
 public interface FiliereDao extends JpaRepository<Filiere,Long> {


    public Filiere findByLibelle(String libelle);
	
	public int deleteByLibelle(String libelle);

}
