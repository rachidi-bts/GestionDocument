package com.gestion.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.Responsable;

@Repository
public interface ResponsableDao extends JpaRepository <Responsable,Long>{
	public Responsable findByLogin (String login);
	public int deleteByLogin (String login);
	
	
}
