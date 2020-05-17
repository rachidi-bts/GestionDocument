package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.Responsable; 
public interface ResponsableService {

public Responsable save(Responsable responsable); 
public List<Responsable>  findAll();
public Responsable findById(Long id);
public int delete(Responsable responsable);
public void  deleteById(Long id);
public void clone(Responsable responsable,Responsable responsableClone);
public Responsable clone(Responsable responsable);
public List<Responsable> clone(List<Responsable>responsables);
public List<Responsable>  findByCriteria(String login,String password,Long idMin,Long idMax);

}
