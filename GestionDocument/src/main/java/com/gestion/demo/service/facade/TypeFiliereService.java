package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.TypeFiliere;
public interface TypeFiliereService {

public TypeFiliere save(TypeFiliere typeFiliere); 
public List<TypeFiliere>  findAll();
public TypeFiliere findById(Long id);
public int delete(TypeFiliere typeFiliere);
public void  deleteById(Long id);
public void clone(TypeFiliere typeFiliere,TypeFiliere typeFiliereClone);
public TypeFiliere clone(TypeFiliere typeFiliere);
public List<TypeFiliere> clone(List<TypeFiliere>typeFilieres);
 public List<TypeFiliere>  findByCriteria(String libelle,Long idMin,Long idMax);

}
