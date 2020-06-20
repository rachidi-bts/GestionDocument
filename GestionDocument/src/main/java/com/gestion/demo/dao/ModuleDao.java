package com.gestion.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestion.demo.bean.Module;


@Repository
public interface ModuleDao extends JpaRepository<Module,Long> {

	public Module findByLibelle(String libelle);
	
       int deleteByLibelle(String libelle);


}