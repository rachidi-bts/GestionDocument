package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.TypeDocument; 
public interface TypeDocumentService {

public TypeDocument save(TypeDocument typedocument); 
public List<TypeDocument>  findAll();
public TypeDocument findById(Long id);
public int delete(TypeDocument typedocument);
public void  deleteById(Long id);
public void clone(TypeDocument typedocument,TypeDocument typedocumentClone);
public TypeDocument clone(TypeDocument typedocument);
public List<TypeDocument> clone(List<TypeDocument>typedocuments);
 public List<TypeDocument>  findByCriteria(String libelle,Long idMin,Long idMax);

}
