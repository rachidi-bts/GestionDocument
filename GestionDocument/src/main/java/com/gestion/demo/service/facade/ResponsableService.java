package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.Responsable;

public interface ResponsableService {
	public Responsable findByLogin (String login);
	public int deleteByLogin (String login);
	
	public List<Responsable> findAll();
	public int save(Responsable responsable);
	public int update(Responsable responsable);
}
