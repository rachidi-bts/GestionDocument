package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.Filiere;
public interface FiliereService {

public Filiere save(Filiere filiere); 
public List<Filiere>  findAll();
public Filiere findById(Long id);
public int delete(Filiere filiere);
public void  deleteById(Long id);
public void clone(Filiere filiere,Filiere filiereClone);
public Filiere clone(Filiere filiere);
public List<Filiere> clone(List<Filiere>filieres);
 public List<Filiere>  findByCriteria(String libelle,Long idMin,Long idMax);
 
 public Filiere findByLibelle(String libelle);
	
	public int deleteByLibelle(String libelle);

}
