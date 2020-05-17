package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.ServiceDocument;
public interface ServiceDocumentService {

public ServiceDocument save(ServiceDocument servicedocument); 
public List<ServiceDocument>  findAll();
public ServiceDocument findById(Long id);
public int delete(ServiceDocument servicedocument);
public void  deleteById(Long id);
public void clone(ServiceDocument servicedocument,ServiceDocument servicedocumentClone);
public ServiceDocument clone(ServiceDocument servicedocument);
public List<ServiceDocument> clone(List<ServiceDocument>servicedocuments);
 public List<ServiceDocument>  findByCriteria(String libelle,Long idMin,Long idMax);

}
